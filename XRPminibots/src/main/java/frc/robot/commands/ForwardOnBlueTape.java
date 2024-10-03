package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class ForwardOnBlueTape extends Command {
  private Drivetrain m_drive;
  private ReflectiveSensor m_sensor;
  private double m_speed;

  public ForwardOnBlueTape(Drivetrain drivetrain, ReflectiveSensor sensor, double speed) {
    m_drive = drivetrain;
    m_sensor = sensor;
    m_speed = speed;
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
    if (m_sensor.leftValue() < 0.8 && m_sensor.rightValue() < 0.8){
      m_drive.arcadeDrive(m_speed,0);
    //if swerved too much to the right
    } else if (m_sensor.leftValue() < 0.8 && m_sensor.rightValue() >= 0.8){
        m_drive.arcadeDrive(1,0.3);
    //if swerved too much to the left
    } else if (m_sensor.leftValue() >= 0.8 && m_sensor.rightValue() < 0.8){
        m_drive.arcadeDrive(1,-0.3);
    }
    System.out.println(m_sensor.leftValue() + " " + m_sensor.rightValue());
  }

  // @Override
  // public void execute(){
  //   //move forward
  //   m_drive.arcadeDrive(m_speed,0);
  //   //if swerved too much to the right
  //   if (m_sensor.leftValue() < 0.8 && m_sensor.rightValue() >= 0.8){
  //     while (m_sensor.rightValue() >= 0.8){
  //       m_drive.arcadeDrive(0,-1 * m_speed);
  //     }
  //   //if swerved too much to the left
  //   } else if (m_sensor.leftValue() >= 0.8 && m_sensor.rightValue() < 0.8){
  //     while (m_sensor.leftValue() >= 0.8){
  //       m_drive.arcadeDrive(0,m_speed);
  //     }
  //   }
  // }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return (m_sensor.leftValue() >= 0.8 && m_sensor.rightValue() >= 0.8);
  }

}
