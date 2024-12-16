package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Intake;

public class IntakeContinuous extends Command {
  Intake intake;

  public IntakeContinuous(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  public void initialize() {

  }

  public void execute() {
    if (OI.getA()) {
      intake.setSpeed(Constants.Intake.intakeSpeed);
    } else {
      intake.setSpeed(0);
    }
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    intake.setSpeed(0);
  }

  public void interrupted() {
    end();
  }
}
