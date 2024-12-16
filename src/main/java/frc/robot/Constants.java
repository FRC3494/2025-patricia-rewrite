// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class OI {
    public static final int PRIMARY_CONTROLLER_PORT = 0;
  }

  public static final class Drive {
    public static final int rightMotor = 1;
    public static final int leftMotor = 0;

    public static final double deadband = 0.05;

    public static final double driveFactor = 1.2;
    public static final double turnFactor = 0.8;
  }

  public static final class Magazine {
    public static final int frontMotor = 4;
    public static final int backMotor = 6;

    public static final double magazineSpeed = 0.5;
  }

  public static final class Intake {
    public static final int intakeMotor = 5;

    public static final double intakeSpeed = 0.5;
  }

  public static final class Shooter {
    public static final int frontWheelMotor = 2;
    public static final int backWheelMotor = 3;

    public static final double shooterSpeed = 0.7;
  }
}
