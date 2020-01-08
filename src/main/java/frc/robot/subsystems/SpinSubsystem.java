/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    //TODO: fix this
    private final TalonSRX m_spinner = new TalonSRX(15);

    public void spin(double pow) {
        pow=pow/10.0;
        m_spinner.set(ControlMode.PercentOutput, pow);
    }
}