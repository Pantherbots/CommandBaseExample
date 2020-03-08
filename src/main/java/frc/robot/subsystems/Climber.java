/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

  private Spark m_elevMotor;

  public Climber() {
    m_elevMotor = new Spark(Constants.kMotorPort);
  }

  public void raise() {
    m_elevMotor.set(0.5);
  }

  public void lower() {
    m_elevMotor.set(-0.5);
  }

  public void stopMotor() {
    m_elevMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
