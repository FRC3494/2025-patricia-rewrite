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
    // if (OI.decreaseShooterSpeed()) {
    // topSpeed -= Constants.Shooter.speedAdjustStep;
    // bottomSpeed -= Constants.Shooter.speedAdjustStep;
    // } else if (OI.increaseShooterSpeed()) {
    // topSpeed += Constants.Shooter.speedAdjustStep;
    // bottomSpeed += Constants.Shooter.speedAdjustStep;
    // }

    // if (topSpeed > 1) {
    // topSpeed = 1;
    // }
    // if (bottomSpeed > 1) {
    // bottomSpeed = 1;
    // }
    // if (topSpeed < -1) {
    // topSpeed = -1;
    // }
    // if (bottomSpeed < -1) {
    // bottomSpeed = -1;
    // }

    // // TODO: add AKit dep and change to Logger
    // System.out.println("Top Roller: " + topSpeed);
    // System.out.println("Bottom Roller: " + bottomSpeed);
    // System.out.println("");

    if (OI.shooterSpeed() > 0) {
      if (OI.mediumShooter()) {
        shooter.setTopSpeed(Constants.Shooter.shooterMaxSpeedMedium * OI.shooterSpeed());
        shooter.setBottomSpeed(Constants.Shooter.shooterMaxSpeedMedium * OI.shooterSpeed());
      } else if (OI.fastShooter()) {
        shooter.setTopSpeed(Constants.Shooter.shooterMaxSpeedFast * OI.shooterSpeed());
        shooter.setBottomSpeed(Constants.Shooter.shooterMaxSpeedFast * OI.shooterSpeed());
      } else {
        shooter.setTopSpeed(Constants.Shooter.shooterMaxSpeedNormal * OI.shooterSpeed());
        shooter.setBottomSpeed(Constants.Shooter.shooterMaxSpeedNormal * OI.shooterSpeed());
      }
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
