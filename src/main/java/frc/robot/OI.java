package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public final class OI {
  public static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  private static XboxController primaryController = new XboxController(Constants.OI.PRIMARY_CONTROLLER_PORT);

  public static XboxController getPrimaryController() {
    return primaryController;
  }

  public static double getLeftJoystickY() {
    return primaryController.getLeftY();
  }

  public static double getRightJoystickX() {
    return primaryController.getRightX();
  }

  public static boolean getA() {
    return primaryController.getAButton();
  }

  public static boolean getB() {
    return primaryController.getBButton();
  }

  public static boolean getLeftBumper() {
    return primaryController.getLeftBumper();
  }

  public static boolean getRightBumper() {
    return primaryController.getRightBumper();
  }
}
