package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class ForwardOnBlueTape extends Command {
  private Drivetrain m_drive;
  private ReflectiveSensor m_sensor;
  private double m_speed;
  private double colorValue;

  public ForwardOnBlueTape(Drivetrain drivetrain, ReflectiveSensor sensor, double speed, double color) {
    m_drive = drivetrain;
    m_sensor = sensor;
    m_speed = speed;
    colorValue = color;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  @Override
  public void execute(){
    //move forward
    if (m_sensor.leftValue() < colorValue && m_sensor.rightValue() < colorValue){
      m_drive.arcadeDrive(m_speed,0);
    } else if (m_sensor.leftValue() < colorValue && m_sensor.rightValue() >= colorValue){
      m_drive.arcadeDrive(0.8,0.6);
    //if swerved too much to the left
    } else if (m_sensor.leftValue() >= colorValue && m_sensor.rightValue() < colorValue){
      m_drive.arcadeDrive(0.8,-0.6);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    System.out.println(m_sensor.leftValue());
    System.out.println(m_sensor.rightValue());
    return (m_sensor.leftValue() >= colorValue && m_sensor.rightValue() >= colorValue);
  }

}
