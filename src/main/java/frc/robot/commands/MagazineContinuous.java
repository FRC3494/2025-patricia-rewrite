package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Magazine;

public class MagazineContinuous extends Command {
  Magazine magazine;

  public MagazineContinuous(Magazine magazine) {
    this.magazine = magazine;
    addRequirements(magazine);
  }

  public void initialize() {

  }

  public void execute() {
    if (OI.intakeAndMagazine()) {
      magazine.setSpeed(Constants.Magazine.magazineSpeed);
    } else if (OI.reverseIntakeAndMagazine()) {
      magazine.setSpeed(-Constants.Magazine.magazineSpeed);
    } else {
      magazine.setSpeed(0);
    }
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    magazine.setSpeed(0);
  }

  public void interrupted() {
    end();
  }
}
