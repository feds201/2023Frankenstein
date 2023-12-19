package frc.robot.commands.BoxGrabber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BoxGrabber.BoxGrabber;

public class ExtendBoxGrabber extends CommandBase {
    BoxGrabber b_boxGrabber;

    public ExtendBoxGrabber(BoxGrabber BoxGrabber) {
        b_boxGrabber = BoxGrabber;
        addRequirements(b_boxGrabber);
    }
    
    @Override
    public void initialize() {
        b_boxGrabber.extendBoxGrabber();
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() { return true; }

    @Override
    public void end(boolean interrupted) {}
}