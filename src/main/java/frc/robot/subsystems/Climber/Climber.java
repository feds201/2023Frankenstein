// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private final TalonFX climbMotor;
  
  public Climber() {
    climbMotor = new TalonFX(0);
  }

  public void moveMotor() {
    climbMotor.set(ControlMode.PercentOutput, 0.2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
