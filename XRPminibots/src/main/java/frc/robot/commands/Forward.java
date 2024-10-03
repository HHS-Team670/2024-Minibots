package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;


public class Forward extends Command{
  private Drivetrain m_drive;
  private double m_distance;
  private double m_speed;
  private double m_totalDistance;

  public Forward(Drivetrain drivetrain, double distance, double speed) {
    m_drive = drivetrain;
    m_distance = distance;
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
    m_drive.arcadeDrive(m_speed,0);
    double gyroAngle = m_drive.getGyroAngleZ();
    double angle;
    if (gyroAngle < 180){
      angle = gyroAngle;
    } else {
      angle = 360 - gyroAngle;
    }
    angle = - m_drive.getGyroAngleZ();
    m_totalDistance += Math.abs(m_drive.getAverageDistanceInch());
    m_drive.resetEncoders();
    if (angle < 180){
      while (!turnFinished(angle)){
        m_drive.arcadeDrive(0,-m_speed);
      }
    } else if (angle > 180){
      while (!turnFinished(angle)){
        m_drive.arcadeDrive(0,m_speed);
      }
    }
    m_drive.resetEncoders();
  }
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }
  @Override
  public boolean isFinished() {
    return m_totalDistance >= m_distance;
  }

  public boolean turnFinished(double m_alignAngle) {
    /* Need to convert distance travelled to degrees. The Standard
       XRP Chassis found here, https://www.sparkfun.com/products/22230,
       has a wheel placement diameter (163 mm) - width of the wheel (8 mm) = 155 mm
       or 6.102 inches. We then take into consideration the width of the tires.
    */
    double inchPerDegree = Math.PI * 6.102 / 360;
    // Compare distance travelled from start to distance based on degree turn
    return getAverageTurningDistance() >= (inchPerDegree * m_alignAngle);
  }

  private double getAverageTurningDistance() {
    double leftDistance = Math.abs(m_drive.getLeftDistanceInch());
    double rightDistance = Math.abs(m_drive.getRightDistanceInch());
    return (leftDistance + rightDistance) / 2.0;
  }
}
