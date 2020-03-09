/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Climber;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.pullUp;
import frc.robot.commands.pullDown;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveBase m_driveBase = new DriveBase();
  private final Climber m_climber = new Climber();
  XboxController xController = new XboxController(0);
  // Buttons
  JoystickButton kA,kB;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    kA = new JoystickButton(xController, XboxController.Button.kA.value);
    kB = new JoystickButton(xController, XboxController.Button.kB.value);

    configureButtonBindings();
    m_driveBase.setDefaultCommand(
      new RunCommand(() -> m_driveBase.arcadeDrive(xController.getY(Hand.kLeft),xController.getX(Hand.kRight)), m_driveBase));      
    }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    kA.whenHeld(new pullUp(m_climber));
    kB.whenHeld(new pullDown(m_climber));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Command to run in autonomous
    return new AutoDrive(m_driveBase);
  }
}
