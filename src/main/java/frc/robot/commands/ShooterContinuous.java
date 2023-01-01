package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Shooter;

public class ShooterContinuous extends Command {
  Shooter shooter;
  double topSpeed = Constants.Shooter.shooterTopSpeed;
  double bottomSpeed = Constants.Shooter.shooterBottomSpeed;

  public ShooterContinuous(Shooter shooter) {
    this.shooter = shooter;
    addRequirements(shooter);
  }

  public void initialize() {

  }

  public void execute() {
    if (OI.getLeftBumper()) {
      topSpeed -= Constants.Shooter.speedAdjustStep;
      bottomSpeed -= Constants.Shooter.speedAdjustStep;
    } else if (OI.getRightBumper()) {
      topSpeed += Constants.Shooter.speedAdjustStep;
      bottomSpeed += Constants.Shooter.speedAdjustStep;
    }

    if (topSpeed > 1) {
      topSpeed = 1;
    }
    if (bottomSpeed > 1) {
      bottomSpeed = 1;
    }
    if (topSpeed < -1) {
      topSpeed = -1;
    }
    if (bottomSpeed < -1) {
      bottomSpeed = -1;
    }

    System.out.println("Top Roller: " + topSpeed);
    System.out.println("Bottom Roller: " + bottomSpeed);
    System.out.println("");

    if (OI.getB()) {
      shooter.setTopSpeed(topSpeed);
      shooter.setBottomSpeed(bottomSpeed);
    } else {
      shooter.setTopSpeed(0);
      shooter.setBottomSpeed(0);
    }
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    shooter.setTopSpeed(0);
    shooter.setBottomSpeed(0);
  }

  public void interrupted() {
    end();
  }
}
