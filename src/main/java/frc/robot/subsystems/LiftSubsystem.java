/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.LiftConstants;
import frc.robot.Constants.Ports;

public class LiftSubsystem extends SubsystemBase {
  private final TalonSRX m_liftMotor = new TalonSRX(Constants.Ports.lift);
  private final TalonSRX m_follow = new TalonSRX(Constants.Ports.liftFollow);
  // private final
  private double speedMultiplier = 1;
  private NetworkTableEntry speedEntry, encoderEntry;
  private final ShuffleboardTab tab = Shuffleboard.getTab("Lift");
  private static boolean init = false;
  private final Encoder m_encoder;

  public LiftSubsystem() {
    m_encoder = new Encoder(Ports.liftEncoderA, Ports.liftEncoderB, false, EncodingType.k4X);
    m_liftMotor.setNeutralMode(NeutralMode.Brake);
    m_follow.setNeutralMode(NeutralMode.Brake);
    m_follow.follow(m_liftMotor);
    m_liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
  }

  public void setSpeed(double s) {
    if (!(s > 0 && m_encoder.getDistance() > LiftConstants.liftUpperBound)
        || !(s < 0 && m_encoder.getDistance() > LiftConstants.liftLowerBound)) {
      s *= speedMultiplier;
      m_liftMotor.set(ControlMode.PercentOutput, s);
    }

  }

  public void setSpeedMultiplier(double speed) {
    setSpeedMultiplier(speed, true);
  }

  public void setSpeedMultiplier(double speed, boolean updateNT) {
    if (0 <= speed && speed <= 2) {
      speedMultiplier = speed;
      if (updateNT) {
        System.out.println("Lift Speed Multiplier update");
        speedEntry.setDouble(speedMultiplier);
      }
    } else {
      System.out.println("Lift Speed Multiplier update");
      speedEntry.setDouble(speedMultiplier);
    }
  }

  @Override
  public void periodic() {
    if (speedEntry == null) {
      speedEntry = tab.addPersistent("Lift Speed Multiplier", 1).getEntry();
      System.out.println("Added Lift Speed Multiplier NT entry");
    }
    if (encoderEntry == null) {
      encoderEntry = tab.addPersistent("Encoder Reading", 1).getEntry();
      System.out.println("Added Lift Encoder NT entry");
    }
    setSpeedMultiplier(speedEntry.getDouble(0.25), false);
    encoderEntry.setDouble(m_encoder.getDistance());
  }

  public void initialize() {
    init = true;
  }

  public boolean getInit() {
    return init;
  }
}