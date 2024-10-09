package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class TurnLeftUntilBlueTape extends Command {
  private Drivetrain m_drive;
  private ReflectiveSensor m_sensor;
  private double m_speed;
  private double colorValue;

  public TurnLeftUntilBlueTape(Drivetrain drivetrain, ReflectiveSensor sensor, double speed, double color) {
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
    m_drive.arcadeDrive(0, m_speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return m_sensor.rightValue() < colorValue;
  }
}
