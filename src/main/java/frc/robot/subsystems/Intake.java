package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  Talon intakeMotor;

  public Intake() {
    intakeMotor = new Talon(Constants.Intake.intakeMotor);
  }

  public void setSpeed(double speed) {
    intakeMotor.set(-1 * speed);
  }
}
