package frc.robot.commands.BoxGrabber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BoxGrabber.BoxGrabber;

public class RunBoxGrabber extends CommandBase {
    BoxGrabber b_boxGrabber;

    public RunBoxGrabber(BoxGrabber BoxGrabber) {
        b_boxGrabber = BoxGrabber;
        addRequirements(b_boxGrabber);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        b_boxGrabber.retractBoxGrabber();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
      b_boxGrabber.extendBoxGrabber();
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