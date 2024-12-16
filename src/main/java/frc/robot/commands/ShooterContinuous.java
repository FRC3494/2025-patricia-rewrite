package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Shooter;

public class ShooterContinuous extends Command {
  Shooter shooter;

  public ShooterContinuous(Shooter shooter) {
    this.shooter = shooter;
    addRequirements(shooter);
  }

  public void initialize() {

  }

  public void execute() {
    if (OI.getB()) {
      shooter.setSpeed(Constants.Shooter.shooterSpeed);
    } else {
      shooter.setSpeed(0);
    }
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    shooter.setSpeed(0);
  }

  public void interrupted() {
    end();
  }
}
