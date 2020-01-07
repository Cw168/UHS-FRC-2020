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
    private final TalonSRX spinner = new TalonSRX(-1);

    /**
     * Creates a new ExampleSubsystem.
     */
    public SpinSubsystem() {
    }

    @Override
    public void periodic() {

    }

    public void spin(int pow) {
        spinner.set(ControlMode.PercentOutput, pow);
    }

}
