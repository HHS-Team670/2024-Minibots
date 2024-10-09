package frc.robot.commands;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;


public class BalanceDrive extends Command {

    private ReflectiveSensor reflectiveSensor;
    private final Drivetrain m_drive;
    private final double m_duration;
    private long m_startTime;
    private final double m_speed;
    
    public BalanceDrive(double speed, double distance, Drivetrain drive, ReflectiveSensor reflectiveSensor) {
        m_speed = speed;
        m_duration = distance;
        m_drive = drive;
        this.reflectiveSensor = reflectiveSensor;
        addRequirements(drive);
      }

    public void initialize() {
        m_drive.resetEncoders();
        m_drive.arcadeDrive(0, 0);
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {

        if(reflectiveSensor.leftValue() <= 0.8){
             m_drive.arcadeDrive(m_speed, 0);
        }
        else if(reflectiveSensor.rightValue() <= 0.8){
             m_drive.arcadeDrive(m_speed, 0);
        }
        else if(reflectiveSensor.leftValue() > 0.8 && reflectiveSensor.rightValue() > 0.8 ){
             m_drive.arcadeDrive(0, m_speed/4);
        } else {
            System.out.println(reflectiveSensor.leftValue());
            System.out.println(reflectiveSensor.rightValue());
        }
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        m_drive.arcadeDrive(0, 0);
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return Math.abs(m_drive.getAverageDistanceInch()) >= m_duration;
      }
}
