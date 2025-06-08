package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command {
  private Drivetrain mDrivetrain;
  private ReflectiveSensor mSensor;
  private double forwardSpeed;
  private double colorValue;

  public LineFollowing(double forwardSpeed, double colorValue) {
    this.mDrivetrain = Drivetrain.getInstance();
    this.mSensor = ReflectiveSensor.getInstance();
    this.forwardSpeed = forwardSpeed;
    this.colorValue = colorValue;
    addRequirements(mDrivetrain);
  }

  @Override
  public void initialize() {
    mDrivetrain.arcadeDrive(0, 0);
    mDrivetrain.resetEncoders();
  }

  @Override
  public void execute() {
    // move forward if both sensors detect less light than the color value
    if (mSensor.leftValue() < colorValue && mSensor.rightValue() < colorValue) {
      mDrivetrain.arcadeDrive(forwardSpeed, 0);
    } else if (mSensor.leftValue() < colorValue && mSensor.rightValue() >= colorValue) {
      //If swerved too far right and only left sensor detects the tape, move forward and rotate left
      mDrivetrain.arcadeDrive(0.8, 0.6);
    } else if (mSensor.leftValue() >= colorValue && mSensor.rightValue() < colorValue) {
      mDrivetrain.arcadeDrive(0.8, -0.6);
    }
  }

  @Override
  public boolean isFinished() {
    //If both sensors do not detect tape, the line following is finished
    return (mSensor.leftValue() >= colorValue && mSensor.rightValue() >= colorValue);
  }

  @Override
  public void end(boolean interrupted) {
    mDrivetrain.arcadeDrive(0, 0);
  }
}