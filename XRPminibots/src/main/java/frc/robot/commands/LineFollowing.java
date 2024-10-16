package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command {
    private Drivetrain m_drivetrain;
    private ReflectiveSensor m_sensor;

    public LineFollowing(Drivetrain drivetrain, ReflectiveSensor sensor) {
        m_drivetrain = drivetrain;
        m_sensor = sensor;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.resetEncoders();
    }
    
    @Override
    public void execute(){
        if (m_sensor.leftValue()<0.81){
            m_drivetrain.arcadeDrive(1, 0);
            if (m_sensor.rightValue()
        }
        if (m_sensor.rightValue()<0.81){
             
        }
        
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.resetEncoders();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}