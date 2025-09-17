package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Shooter;

public class ShooterContinuous extends Command {
  Shooter shooter;
  double topSpeed = 0;
  double bottomSpeed = 0;

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

    if (OI.mediumShooter()) {
      topSpeed = Constants.Shooter.shooterMaxSpeedMedium;
      bottomSpeed = Constants.Shooter.shooterMaxSpeedMedium;
    } else if (OI.fastShooter()) {
      topSpeed = Constants.Shooter.shooterMaxSpeedFast;
      bottomSpeed = Constants.Shooter.shooterMaxSpeedFast;
    } else {
      topSpeed = Constants.Shooter.shooterMaxSpeedNormal;
      bottomSpeed = Constants.Shooter.shooterMaxSpeedNormal;
    }

    topSpeed *= OI.shooterSpeed();
    bottomSpeed *= OI.shooterSpeed();

    if (OI.differentialShooterSpeeds()) {
      bottomSpeed *= Constants.Shooter.bottomSpeedRatio;
    }

    shooter.setTopSpeed(topSpeed);
    shooter.setBottomSpeed(bottomSpeed);
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
