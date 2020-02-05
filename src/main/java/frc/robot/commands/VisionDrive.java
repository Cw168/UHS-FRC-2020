package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.VisionControlConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.pidcontroller.VisionPIDRotation;

public class VisionDrive extends CommandBase {

    private NetworkTable table;

    // debug
    private final double speedMultiplier = 0.2;
    private NetworkTableEntry hAngleEntry;
    private NetworkTableEntry vAngleEntry;

    private final VisionPIDRotation m_visionPIDRotation;

    public VisionDrive(VisionPIDRotation visionPIDRotation) {
        m_visionPIDRotation = visionPIDRotation;
        table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("vision");
        hAngleEntry = table.getEntry("yaw");
        vAngleEntry = table.getEntry("pitch");
        addRequirements(m_visionPIDRotation);
    }

    @Override
    public void execute() {
        double rotDeficit = 0;
        double distDeficit = 0;
        double hAngle = hAngleEntry.getDouble(0); // horizontal rotation
        double vAngle = vAngleEntry.getDouble(0); // vertical angle. Convert this to distance pls
        if (hAngle > VisionControlConstants.angleDeadzone) {
            rotDeficit += VisionControlConstants.minForce;
        } else if (hAngle < VisionControlConstants.angleDeadzone) {
            rotDeficit -= VisionControlConstants.minForce;
        }
        if (vAngle > VisionControlConstants.distanceDeadzone) {
            distDeficit += VisionControlConstants.minForce;
        } else if (vAngle < VisionControlConstants.distanceDeadzone) {
            distDeficit -= VisionControlConstants.minForce;
        }
        m_visionPIDRotation.setSetpoint(rotDeficit);
        SmartDashboard.putString("Vision Info", "Speed: " + distDeficit * speedMultiplier + " Rotation: " + rotDeficit);

    }

    @Override
    public void end(boolean interrupted) {
        m_visionPIDRotation.setSetpoint(0);
    }

    @Override
    public boolean isFinished() {
        return m_visionPIDRotation.atSetpoint();
    }
}