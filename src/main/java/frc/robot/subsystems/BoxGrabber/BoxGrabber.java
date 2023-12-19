package frc.robot.subsystems.BoxGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BoxGrabber extends SubsystemBase{

    DoubleSolenoid boxGrabber;
    Boolean extended;

    public BoxGrabber() {
        boxGrabber = new DoubleSolenoid(02, PneumaticsModuleType.CTREPCM, 1, 0);
        extended = false;
    }

    public boolean isExtended(){
        if(extended){
            return true;
        }else{
            return false;
        }
    }

    public void Change(){
        if(isExtended()){
            System.out.println("Retract!");
            extended = false;
        }else{
            System.out.println("Extend!");
            extended = true;
        }
    }

    /**
     * 
     */
    public void extendBoxGrabber(){
        boxGrabber.set(Value.kReverse);
        extended = true;
    }
    public void retractBoxGrabber(){
        boxGrabber.set(Value.kForward);
        extended = false;
    }
}