// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final XRPServo servoMotor;

  // Stores the instance to avoid multiple instances of the same subsystem
  private static Arm mInstance = null;

  public static synchronized Arm getInstance() {
    mInstance = mInstance == null ? new Arm() : mInstance;
    return mInstance;
  }

  public enum ArmPosition {
    STOW(0.0),
    UP(90.0);

    private double angle;

    private ArmPosition(double angle) {
      this.angle = angle;
    }

    public double getAngle() {
      return this.angle;
    }
  }

  // Creates a new arm
  public Arm() {
    // Device number 4 maps to the physical Servo 1 port on the XRP
    servoMotor = new XRPServo(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Set the angle of the arm to the degree parameter (0-180 degrees)
  public void setAngle(ArmPosition armPos) {
    servoMotor.setAngle(armPos.getAngle());
  }
}
