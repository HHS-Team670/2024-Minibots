package frc.robot.subsystems;


import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;

public class ReflectanceSensor {
    private final XRPReflectanceSensor m_reflectancesensor;
    
    public ReflectanceSensor(){
        m_reflectancesensor = new XRPReflectanceSensor();
    }

    public double getLeft(){
        return m_reflectancesensor.getLeftReflectanceValue();
    }

    public double getRight(){
        return m_reflectancesensor.getRightReflectanceValue();
    }
}
