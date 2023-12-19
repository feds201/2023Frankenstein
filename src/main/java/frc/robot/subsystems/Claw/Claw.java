package frc.robot.subsystems.Claw;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
    // the can id is 5
    TalonFX clawMotor;
    boolean input;

    public Claw() {
        clawMotor = new TalonFX(5);
        input = false;
    }

    public boolean isPulling() {
        if (input) {
            return true;
        } else {
            return false;
        }
    }

    public void windPulley() {
        clawMotor.set(ControlMode.PercentOutput, .1);
        input = true;
    }

    public void unwindPulley() {
        clawMotor.set(ControlMode.PercentOutput, -.1);
        input = true;
    }
}
