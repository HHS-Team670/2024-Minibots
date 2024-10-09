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
    private int m_type;
    int counter = 0;
    
    
    public ProtectedDrive(Drivetrain drivetrain, ReflectiveSensor sensor){
        m_sensor = sensor;
        m_drivetrain = drivetrain;
        // m_distance = distance;
        // m_speed = speed;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.resetEncoders();
        m_drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {

        // if(!leftSensorGrey && !rightSensorGrey) {
        //     m_drivetrain.arcadeDrive(m_speed, 0);
        // }

       
        
        if (m_sensor.leftValue() < 0.81 && m_sensor.rightValue() < 0.81) {
            m_drivetrain.arcadeDrive(0.65, 0);
            m_type = 1;
        }
        else if (m_sensor.leftValue() > 0.81 && m_sensor.rightValue() > 0.81) { // change this one
            double value;
            if (m_type != 2){
                counter++;
                System.out.println(counter);
            }
            m_type =2;
            value = -0.65;
            if (counter % 4 == 2){
                value = 0.65;
            }
            m_drivetrain.arcadeDrive(0, value);
            
        }
        else if (m_sensor.leftValue() > 0.81) {
            m_drivetrain.arcadeDrive(0, -0.65); 
            m_type = 3;
        }
        else if (m_sensor.rightValue() > 0.81) {
            m_drivetrain.arcadeDrive(0, 0.65);
            m_type = 4;
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
