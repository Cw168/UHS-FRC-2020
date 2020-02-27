/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class LiftSubsystem extends SubsystemBase {
    private final VictorSPX m_liftMotor = new VictorSPX(Constants.LiftConstants.liftMotor);
    private final VictorSPX m_follow = new VictorSPX(Constants.LiftConstants.liftFollow);
    private double speedMultiplier = 0.25;  
    private NetworkTableEntry speedEntry; 
    private final ShuffleboardTab tab = Shuffleboard.getTab("Scoring");
                                                  

  public LiftSubsystem() {
      m_follow.follow(m_liftMotor);
   
  }

  public void setSpeed(double s) {
      s*= speedMultiplier;
      m_liftMotor.set(ControlMode.PercentOutput, s);
  }
  
  public void setSpeedMultiplier(double speed, boolean updateNT) {
    if (0 <= speed && speed <= 2) {
      speedMultiplier = speed;
      if (updateNT) {
        System.out.println("Putted Single Speed Multiplier NT entry");
        speedEntry.setDouble(speedMultiplier);
      }
    } else {
      System.out.println("Putted Single Speed Multiplier NT entry");
      speedEntry.setDouble(speedMultiplier);
    }  
  }


  @Override
  public void periodic() {
    if (speedEntry == null) {
        speedEntry = tab.addPersistent("lift", 1).getEntry();
        System.out.println("Added Single Speed Multiplier NT entry");
      }
      setSpeedMultiplier(speedEntry.getDouble(0.25), false);
    
  }
}