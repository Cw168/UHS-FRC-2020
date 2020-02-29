/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class WinchServoSubsystem extends SubsystemBase {
    private final Servo m_switch = new Servo(0);
    public static boolean toggleOn = false;

    public void toggle() {
        if (!toggleOn) {
            m_switch.setAngle(30);
            toggleOn=true;
        } else {
            m_switch.setAngle(180);
            toggleOn=false;
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
