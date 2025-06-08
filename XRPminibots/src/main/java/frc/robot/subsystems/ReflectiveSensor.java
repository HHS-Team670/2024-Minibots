package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;

public class ReflectiveSensor {
    // Stores the instance to avoid multiple instances of the same subsystem
    private static ReflectiveSensor mInstance = null;

    public static synchronized ReflectiveSensor getInstance() {
        mInstance = mInstance == null ? new ReflectiveSensor() : mInstance;
        return mInstance;
    }

    private XRPReflectanceSensor mReflectanceSensor = new XRPReflectanceSensor();

    public double leftValue() {
        return mReflectanceSensor.getLeftReflectanceValue();
    }

    public double rightValue() {
        return mReflectanceSensor.getRightReflectanceValue();
    }
}