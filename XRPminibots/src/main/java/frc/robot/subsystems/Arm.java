// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final XRPServo m_armServo;
  private double amountPerRun;
  private boolean runUp;
  private boolean runDown;

  /** Creates a new Arm. */
  public Arm() {
    // Device number 4 maps to the physical Servo 1 port on the XRP
    m_armServo = new XRPServo(4);
  }


  double Min(double x, double y) {
    if (x > y){
      return y;
    } else {
      return x;
    }
  }

  double Max(double x, double y) {
    if (x > y){
      return x;
    } else {
      return y;
    }
  }


  public void moveArm(){
    this.goDown();
    this.goUp();
  }

  public void goUp(){
    if (runUp) {
      double angle = Min(amountPerRun + m_armServo.getAngle() , 180);
      this.setAngle(angle);
    }
  }

  public void goDown(){
    if (runDown) {
      double angle = Max(amountPerRun + m_armServo.getAngle() , 0);
      this.setAngle(angle);
    }
  }

  public void startUp(double amountPerSec, boolean val){
    amountPerRun = amountPerSec;
    runUp = val;
  }


  public void startDown(double amountPerSec, boolean val){
    amountPerRun = amountPerSec;
    runDown = val;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Set the current angle of the arm (0 - 180 degrees).
   *
   * @param angleDeg Desired arm angle in degrees
   */
  public void setAngle(double angleDeg) {
    m_armServo.setAngle(angleDeg);
  }
}
