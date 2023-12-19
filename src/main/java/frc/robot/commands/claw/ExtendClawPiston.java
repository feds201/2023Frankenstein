// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw.Claw;

public class ExtendClawPiston extends CommandBase {
  /** Creates a new ExtendClawPiston. */
  private final Claw s_claw;
  
  public ExtendClawPiston(Claw claw) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s_claw = claw;
    addRequirements(s_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_claw.extendPiston();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
