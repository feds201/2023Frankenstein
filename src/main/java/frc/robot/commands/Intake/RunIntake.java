package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends CommandBase {
    Intake i_Intake;

    public RunIntake(Intake intake) {
        i_Intake = intake;
        addRequirements(i_Intake);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() { 
        i_Intake.collectBalls(); 
    }

    @Override
    public boolean isFinished() { return false; }

    @Override
    public void end(boolean interrupted) { 
        i_Intake.stopIntake();
    }
}
