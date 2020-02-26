/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ColorConstants {
        public static final int waitCycle = 5;
        public static final int colorRange = 30;

        /**
         * [i][j] i: 0-1-2-3=blue-green-red-yellow | j: 0-1-2=r-g-b
         */
        public static final int[][] colorTarget = { { 30, 100, 120 }, { 40, 150, 65 }, { 140, 80, 30 },
                { 80, 145, 30 } };
    }

    public static final int controllerPrecision = 1000;
    public static final double joystickDeadzone = 0.1;

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final double kDriverControllerCurvature = 3;
    }

    public static final class VisionControlConstants {
        // Amount of angle tolerated to be considered "aligned"
        public static final int angleDeadzone = 5;
        public static final int distanceDeadzone = 5;
        // Proportional control for vision adjust. Use PID later
        public static final double KpRot = 0.1;
        public static final double KpDist = 0.1;
        public static final double KiRot = .0001;
        public static final double KiDist = .0001;
        public static final double KdRot = 2.5;
        public static final double KdDist = 2.5;
        // Minimum force when driving
        public static final double minForce = 0.05;
        // angle limits in degrees
        public static final double innerPortAngleLimit = 33;
        public static final double mToInch = 39.3701;
    }

    public static final class LiftConstants {
        // todo
        public static final int liftMotor = -1;
        public static final int liftFollow = -1;
        public static final double Kp = 1;
        public static final double Kd = 0;
        public static final double Ki = 0;
    }

    public static final class DriveConstants {
        public static final int leftMotor = 1;
        public static final int rightMotor = 3;
        public static final int leftFollowMotor = 2;
        public static final int rightFollowMotor = 0;
    }

    public static final class FlywheelCons {
        public static final int flySingle = 2;
        public static final int leftMotor = 1;
        public static final int rightMotor = 0;
    }

    public static final class SpinCons {
        public static final int spinner = 2;
    }

    public static class Gains {
        public final double kP;
        public final double kI;
        public final double kD;
        public final double kF;
        public final int kIzone;
        public final double kPeakOutput;

        public Gains(double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput) {
            kP = _kP;
            kI = _kI;
            kD = _kD;
            kF = _kF;
            kIzone = _kIzone;
            kPeakOutput = _kPeakOutput;
        }
    }

    public static final class PIDConstants {
        public final static int kTimeoutMs = 30;

        /**
         * PID Gains may have to be adjusted based on the responsiveness of control
         * loop. kF: 1023 represents output value to Talon at 100%, 6800 represents
         * Velocity units at 100% output Not all set of Gains are used in this project
         * and may be removed as desired.
         * 
         * kP kI kD kF Iz PeakOut
         */
        public final static Gains kGains_Distanc = new Gains(0.1, 0.0, 0.0, 0.0, 100, 0.50);
        public final static Gains kGains_Turning = new Gains(2.0, 0.0, 4.0, 0.0, 200, 1.00);
        public final static Gains kGains_Velocit = new Gains(0.1, 0.0, 20.0, 1023.0 / 6800.0, 300, 0.75);
        public final static Gains kGains_MotProf = new Gains(1.0, 0.0, 0.0, 1023.0 / 6800.0, 400, 1.00);
        /** ---- Flat constants, you should not need to change these ---- */
        /*
         * We allow either a 0 or 1 when selecting an ordinal for remote devices [You
         * can have up to 2 devices assigned remotely to a talon/victor]
         */
        public final static int REMOTE_0 = 0;
        public final static int REMOTE_1 = 1;
        /*
         * We allow either a 0 or 1 when selecting a PID Index, where 0 is primary and 1
         * is auxiliary
         */
        public final static int PID_PRIMARY = 0;
        public final static int PID_TURN = 1;
        /*
         * Firmware currently supports slots [0, 3] and can be used for either PID Set
         */
        public final static int SLOT_0 = 0;
        public final static int SLOT_1 = 1;
        public final static int SLOT_2 = 2;
        public final static int SLOT_3 = 3;
        /* ---- Named slots, used to clarify code ---- */
        public final static int kSlot_Distanc = SLOT_0;
        public final static int kSlot_Turning = SLOT_1;
        public final static int kSlot_Velocit = SLOT_2;
        public final static int kSlot_MotProf = SLOT_3;
    }

    public static final class FlyWheelPIDConstants {
        public static final double kP = -1;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kF = 0;
    }
}
