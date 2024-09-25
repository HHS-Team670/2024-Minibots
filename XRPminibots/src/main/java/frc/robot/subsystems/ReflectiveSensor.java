package frc.robot.subsystems;


import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;

public class ReflectiveSensor {
    private XRPReflectanceSensor m_RelfectSensor = new XRPReflectanceSensor();

    public double leftValue(){
        return m_RelfectSensor.getLeftReflectanceValue();
    }

    public double rightValue(){
        return m_RelfectSensor.getRightReflectanceValue();
    }
}
