/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBase extends SubsystemBase {

  private WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(Constants.kVictorPort0);
  private WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(Constants.kVictorPort1);
  private WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(Constants.kVictorPort2);
  private WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(Constants.kVictorPort3);
  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotor1, rightMotor1);

  public DriveBase() {
    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

  }

  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
