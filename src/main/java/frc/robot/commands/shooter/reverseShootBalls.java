package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class reverseShootBalls extends CommandBase{
    Shooter s_shooter;
    public reverseShootBalls(Shooter shooter) {
        s_shooter = shooter;
        addRequirements(s_shooter);
    }
    @Override
    public void end(boolean interrupted) {
        s_shooter.stopShooting();
    }
    @Override
    public void execute() {
        s_shooter.reverseShootBalls();
        
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
