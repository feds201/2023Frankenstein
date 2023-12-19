package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    TalonFX intakeMotor;
    boolean input;

    public Intake() {
        // The TalonFX can id is 3
        intakeMotor = new TalonFX(3);
        input = false;
    }

    public boolean isShooting() {
        if (input) {
            return true;
        } else {
            return false;
        }
    }

    public void collectBalls() {
        intakeMotor.set(ControlMode.PercentOutput, 0.1);
        input = true;
    }

    public void stopIntake() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
        input = false;
    }
}