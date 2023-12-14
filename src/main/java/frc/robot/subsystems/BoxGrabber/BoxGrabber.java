package frc.robot.subsystems.BoxGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class BoxGrabber{

    DoubleSolenoid boxGrabber;
    Boolean extended;

    public BoxGrabber() {
        // boxGrabber = new DoubleSolenoid(0);
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
}