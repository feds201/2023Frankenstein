package frc.robot.subsystems.Claw;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
    // the can id is 5
    TalonFX clawMotor;
    DoubleSolenoid clawPiston;
    boolean pulleyRunning, pistonExtended;

    public Claw() {
        clawMotor = new TalonFX(5);
        clawPiston = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 0, 0); // TODO: Figure out the ids for this
        pulleyRunning = false;
        pistonExtended = false; // TODO: wait isn't this automatically extended from the getgo?
    }

    public boolean isPulleyRunning() {
        if (pulleyRunning) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPistonExtended() {
        if(pistonExtended) {
            return true;
        } else {
            return false;
        }
    }

    public void windPulley() {
        clawMotor.set(ControlMode.PercentOutput, .1);
        pulleyRunning = true;
    }

    public void unwindPulley() {
        clawMotor.set(ControlMode.PercentOutput, -.1);
        pulleyRunning = true;
    }

    public void stopPulley() {
        clawMotor.set(ControlMode.PercentOutput, 0);
    }

    public void extendPiston() {
        clawPiston.set(Value.kForward);
        pistonExtended = true;
    }

    public void retractPiston() {
        clawPiston.set(Value.kReverse);
        pistonExtended = false;
    }
}
