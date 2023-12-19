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
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        i_Intake.stopIntake();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
      i_Intake.collectBalls();
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }

}
