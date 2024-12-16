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
    double leftY = OI.deadband(-1 * OI.getLeftJoystickY(), Constants.Drive.deadband);
    double rightX = OI.deadband(OI.getRightJoystickX(), Constants.Drive.deadband);

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
