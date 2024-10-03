package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.subsystems.Drivetrain;

public class DriveBalance extends Command {
    private final Drivetrain m_drive;
    private final double m_duration;
    private final double m_speed;
    private long m_startTime;

    /**
   * Creates a new DriveBalance. This command will drive your robot for a desired speed and time as a straight line.
   *
   * @param speed The speed which the robot will drive. Negative is in reverse.
   * @param time How much time to drive in seconds
   * @param drive The drivetrain subsystem on which this command will run
   */
  public DriveBalance(double speed, double time, Drivetrain drive) {
    m_speed = speed;
    m_duration = time * 1000;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        new PrintCommand("Right: " + m_drive.getRightReflectanceValue() + " , Left: " + m_drive.getLeftReflectanceValue());
        
        if(m_drive.getLeftReflectanceValue() > 4.1){
          // m_drive.arcadeDrive(-2, 0);
            m_drive.arcadeDrive(0, -0.6);
        }else if(m_drive.getRightReflectanceValue() > 4.1){
          // m_drive.arcadeDrive(-2, 0);
          m_drive.arcadeDrive(0,0.6);
        }else{
            m_drive.arcadeDrive(m_speed, 0);
        }
        // else if(m_drive.getRightReflectanceValue() <= 4.1 && m_drive.getLeftReflectanceValue() <= 4.1){
            // m_drive.arcadeDrive(m_speed, 0);
        // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
  }
}