package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveAutoAlign extends Command {
    private double m_distance;
    private double m_speed;
    private Drivetrain m_drivetrain;
    private double m_alignAngle;
    public DriveAutoAlign(double distance, double speed, double alignAngle , Drivetrain drivetrain){
        addRequirements(drivetrain);
        m_drivetrain = drivetrain;
        m_distance = distance;
        m_speed = speed;
        m_alignAngle = alignAngle;
    }

    @Override
    public void initialize() {
        m_drivetrain.arcadeDrive(0, 0);
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute(){
        m_drivetrain.arcadeDrive(m_speed, 0);
        while(!turnFinished()){
            m_drivetrain.arcadeDrive(0, m_speed);
        }
    }

    public boolean turnFinished() {
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
        double leftDistance = Math.abs(m_drivetrain.getLeftDistanceInch());
        double rightDistance = Math.abs(m_drivetrain.getRightDistanceInch());
        return (leftDistance + rightDistance) / 2.0;
      }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.arcadeDrive(0, 0);
    }
   
    @Override
    public boolean isFinished() {
        return Math.abs(m_drivetrain.getAverageDistanceInch()) >= m_distance;
    }
}
