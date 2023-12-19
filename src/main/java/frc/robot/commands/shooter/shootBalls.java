package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class ShootBalls extends CommandBase {
    Shooter s_shooter;
    
    public ShootBalls(Shooter shooter) {
        s_shooter = shooter;
        addRequirements(s_shooter);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        s_shooter.shootBalls();
    }

    @Override
    public boolean isFinished() { return true; }

    @Override
    public void end(boolean interrupted) {
        s_shooter.stopShooting();
    }
}
