package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class ReverseShootBalls extends CommandBase{
    Shooter s_shooter;
    public ReverseShootBalls(Shooter shooter) {
        s_shooter = shooter;
        addRequirements(s_shooter);
    }
    @Override
    public void initialize() {}

    @Override
    public void execute() {
        s_shooter.reverseShootBalls();
    }

    @Override
    public boolean isFinished() { return false; }

    @Override
    public void end(boolean interrupted) {
        s_shooter.stopShooting();
    }
}
