package frc.robot.subsystems.pidcontroller;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.LiftConstants;
import frc.robot.Constants.VisionControlConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class LiftPID extends PIDSubsystem {
    private final LiftSubsystem m_lift;
    private final Encoder m_encoder;

    public LiftPID() {
        super(new PIDController(LiftConstants.Kp, LiftConstants.Ki, LiftConstants.Kd), 0);
        m_lift = new LiftSubsystem();
        m_encoder = new Encoder(0, 1, false, EncodingType.k4X);
        m_encoder.setDistancePerPulse(0.001);

    }

    @Override
    protected void useOutput(double output, double setpoint) {
        m_lift.setSpeed(output);
    }

    @Override
    protected double getMeasurement() {
        return m_encoder.getDistance();
    }

}