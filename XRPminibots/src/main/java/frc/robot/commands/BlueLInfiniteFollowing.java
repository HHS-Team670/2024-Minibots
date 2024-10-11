package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class BlueLInfiniteFollowing extends Command {
  private Drivetrain m_drive;
  private ReflectiveSensor m_sensor;

  public BlueLInfiniteFollowing(Drivetrain drivetrain, ReflectiveSensor sensor) {
    m_drive = drivetrain;
    m_sensor = sensor;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  @Override
  public void execute(){
    new BlueLineFollowingOneIteration(m_drive, m_sensor);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
