package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class TurnRight extends Command{
    
    private ReflectiveSensor reflectiveSensor;
    private final Drivetrain m_drive;
    private final double m_duration;
    private final double m_speed;
    private long m_startTime;
    private final double angle;
    
    public TurnRight(double speed, double distance, Drivetrain drive, ReflectiveSensor reflectiveSensor) {
        m_speed = speed;
        m_duration = distance;
        m_drive = drive;
        this.reflectiveSensor = reflectiveSensor;
        this.angle = 90;
        addRequirements(drive);
      }

    public void initialize() {
        m_drive.resetEncoders();
        m_drive.arcadeDrive(0, 0);
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        //if both sensors detect blue
        //arcade drive forward
        //if left sensor detects blue but right doesn't
        //arcade drive left
        //if right sensor detects blue but left doesnt
        //arcade drive right
        m_drive.arcadeDrive(0, -0.65);
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        m_drive.arcadeDrive(0, 0);
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return reflectiveSensor.rightValue() <= 0.83 && reflectiveSensor.leftValue() <= 0.83;
        
      }

}
