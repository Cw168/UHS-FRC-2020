package frc.robot.commands.pidcommand;

import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;


public class RotationPIDCommand extends ProfiledPIDCommand {
    //goal is in degrees, clockwise
    public RotationPIDCommand(DriveSubsystem drive, double goal) {
        super(new ProfiledPIDController(DriveConstants.KpRot, DriveConstants.KiRot,
                DriveConstants.KdRot, new TrapezoidProfile.Constraints(10, 20)),
                // Close loop on heading
                drive::getEncoderLeft,
                // Set reference to target
                (goal/360 * Constants.PhysicalMeasurements.driveBaseWidth * Math.PI) / (Constants.PhysicalMeasurements.wheelDiam * Math.PI) * 4096,
                // Pipe output to turn robot
                (output, setpoint) -> drive.arcadeDrive(0, output),
                // Require the drive
                drive);

        // Set the controller to be continuous (because it is an angle controller)
        getController().enableContinuousInput(-180, 180);
        // Set the controller tolerance - the delta tolerance ensures the robot is
        // stationary at the
        // setpoint before it is considered as having reached the reference
        // getController().setTolerance(DriveConstants.kTurnToleranceDeg,
        // DriveConstants.kTurnRateToleranceDegPerS);
    }

    @Override
    public boolean isFinished() {
        // End when the controller is at the reference.
        return getController().atGoal();
    }
}