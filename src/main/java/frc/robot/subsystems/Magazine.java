package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Magazine extends SubsystemBase {
  Talon frontMotor;
  Talon backMotor;

  public Magazine() {
    frontMotor = new Talon(Constants.Magazine.frontMotor);
    backMotor = new Talon(Constants.Magazine.backMotor);
  }

  public void setSpeed(double speed) {
    frontMotor.set(speed);
    backMotor.set(-1 * speed);
  }
}
