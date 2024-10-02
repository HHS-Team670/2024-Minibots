package frc.robot.subsystems;



import edu.wpi.first.wpilibj.AnalogInput;

public class RangeFinder {
    private AnalogInput m_Rangefinder = new AnalogInput(2);
    
    public double rangeInInches(){
        return m_Rangefinder.getVoltage();
    }


    public boolean checkInRangeInches(double range){
        return range > rangeInInches();
    }

}


