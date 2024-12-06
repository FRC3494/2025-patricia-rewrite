package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class DriveContinuous extends Command {
  Drivetrain drivetrain;

  public DriveContinuous(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  public void initialize() {

  }

  public void execute() {
    double leftY = -1 * OI.getLeftJoystickY();
    double rightX = OI.getRightJoystickX();
    if (Math.abs(leftY) < Constants.Drive.deadband) {
      leftY = 0;
    }
    if (Math.abs(rightX) < Constants.Drive.deadband) {
      rightX = 0;
    }

    System.out.println((Constants.Drive.driveFactor * leftY + Constants.Drive.turnFactor * rightX)
        / Constants.Drive.driveFactor);
    System.out.println((Constants.Drive.driveFactor * leftY + (-1 * Constants.Drive.turnFactor * rightX))
        / Constants.Drive.driveFactor);

    drivetrain.setLeftMotor((Constants.Drive.driveFactor * leftY + Constants.Drive.turnFactor * rightX)
        / Constants.Drive.driveFactor);
    drivetrain.setRightMotor((Constants.Drive.driveFactor * leftY + (-1 * Constants.Drive.turnFactor * rightX))
        / Constants.Drive.driveFactor);
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    drivetrain.setLeftMotor(0);
    drivetrain.setRightMotor(0);
  }

  public void interrupted() {
    end();
  }
}
