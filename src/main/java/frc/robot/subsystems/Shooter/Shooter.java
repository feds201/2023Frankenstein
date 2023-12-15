package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    TalonFX shooterMotor;
    boolean input;

    public Shooter(){
        shooterMotor = new TalonFX(4);
        input = false;
    } 

    public boolean isShooting(){
        if(input){
            return true;
        }else{
            return false;
        }
    }

    //public void Change(){
    //    if(isShooting()){
    //        System.out.println("Stop Shooting");
    //        shooting = false;
    //    }else{
    //        System.out.println("Shoot");
    //        shooting = true;
    //    }
    //}
    


    public void shootBalls(){
        shooterMotor.set(ControlMode.PercentOutput, -0.35);
        input = true;
    }
    public void stopShooting(){
        shooterMotor.set(ControlMode.PercentOutput, 0);
        input = false;
    }
    public void reverseShootBalls(){
        shooterMotor.set(ControlMode.PercentOutput, 0.2);
        input = true;
    }
}