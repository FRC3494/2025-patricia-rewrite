// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveContinuous;
import frc.robot.commands.IntakeContinuous;
import frc.robot.commands.MagazineContinuous;
import frc.robot.commands.ShooterContinuous;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final DriveContinuous m_driveContinuous = new DriveContinuous(m_drivetrain);

  private final Magazine m_magazine = new Magazine();
  private final MagazineContinuous m_magazineContinuous = new MagazineContinuous(m_magazine);

  private final Intake m_intake = new Intake();
  private final IntakeContinuous m_intakeContinuous = new IntakeContinuous(m_intake);

  private final Shooter m_shooter = new Shooter();
  private final ShooterContinuous m_shooterContinuous = new ShooterContinuous(m_shooter);

  private final Command m_DefaultAuto = new StartEndCommand(
      () -> {
        m_shooter.setBottomSpeed(0.2);
        m_shooter.setTopSpeed(0.2);
      },
      () -> {
        m_shooter.setBottomSpeed(0);
        m_shooter.setTopSpeed(0);
      },
      m_shooter);
  private final Command m_AltAuto = new StartEndCommand(
      () -> {
        m_magazine.setSpeed(0.5);
      },
      () -> {
        m_magazine.setSpeed(0);
      }, m_magazine);
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_chooser.setDefaultOption("DefaultAuto", m_DefaultAuto);
    m_chooser.addOption("AltAuto", m_AltAuto);
    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  // // An example command will be run in autonomous
  // return Autos.exampleAuto(m_exampleSubsystem);
  // }

  public Command getDriveContinuous() {
    return m_driveContinuous;
  }

  public Command getMagazineContinuous() {
    return m_magazineContinuous;
  }

  public Command getIntakeContinuous() {
    return m_intakeContinuous;
  }

  public Command getShooterContinuous() {
    return m_shooterContinuous;
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}