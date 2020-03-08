/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * An example command that uses an example subsystem.
 */

public class pullUp extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Climber m_subsystem;
  private final JoystickButton m_button;
  private final Timer m_timer = new Timer();
  /**
   *
   * AutoDrive command is used to move the robot in autonomous mode
   * 
   * @param subsystem The subsystem used by this command.
   */
  public pullUp(JoystickButton button, Climber subsystem) {
    m_subsystem = subsystem;
    m_button = button;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.raise(); // drive forwards half speed
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_timer.reset();
    m_subsystem.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
 //   System.out.println("Done?");
    if (m_timer.get() >= 10.0 ) {
      return true;
    }
    return false;
  }
}
