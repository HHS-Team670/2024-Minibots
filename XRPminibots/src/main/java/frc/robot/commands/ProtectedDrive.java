package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class ProtectedDrive extends Command {

    private ReflectiveSensor m_sensor;
    private Drivetrain m_drivetrain;
    private double m_distance;
    private double m_speed;
    private boolean m_done = false;
    
    
    public ProtectedDrive(Drivetrain drivetrain, ReflectiveSensor sensor, double speed ){
        m_sensor = sensor;
        m_drivetrain = drivetrain;
        // m_distance = distance;
        m_speed = speed;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.resetEncoders();
        m_drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute(){
        if(m_sensor.leftValue() < 0.8 && m_sensor.rightValue() < 0.8) {
            m_drivetrain.arcadeDrive(m_speed, 0);
        }
        if(m_sensor.leftValue() > 0.8) {
            while(m_sensor.leftValue() > 0.8){
                m_drivetrain.arcadeDrive(0, m_speed);
            }
        }
    
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.arcadeDrive(0, 0);    
    }

    @Override
    public boolean isFinished() {
        return m_done;
    }

}
