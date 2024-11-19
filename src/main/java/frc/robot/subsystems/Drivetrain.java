package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  Talon leftMotor;
  Talon rightMotor;

  public Drivetrain() {
    leftMotor = new Talon(Constants.Drivetrain.leftMotor);
    rightMotor = new Talon(Constants.Drivetrain.rightMotor);
  }
}
