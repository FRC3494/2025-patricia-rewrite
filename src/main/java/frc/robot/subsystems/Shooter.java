package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  Talon frontWheelMotor;
  Talon backWheelMotor;

  public Shooter() {
    frontWheelMotor = new Talon(Constants.Shooter.frontWheelMotor);
    backWheelMotor = new Talon(Constants.Shooter.backWheelMotor);
  }

  public void setSpeed(double speed) {
    frontWheelMotor.set(speed);
    backWheelMotor.set(speed);
  }
}
