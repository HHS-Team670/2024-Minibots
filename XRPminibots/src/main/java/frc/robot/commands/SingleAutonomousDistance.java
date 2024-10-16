package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class SingleAutonomousDistance extends SequentialCommandGroup{
  private double colorValue = 0.83;
  private double turnSpeed = 0.65;
  private double forwardSpeed = 0.65;
  public SingleAutonomousDistance(Drivetrain drivetrain, ReflectiveSensor sensor) {
    addCommands(
        new ForwardOnBlueTape(drivetrain, sensor, forwardSpeed, colorValue),
        new TurnRightUntilBlueTape(drivetrain, sensor, turnSpeed, colorValue),
        new TurnDegrees(-0.65, 15, drivetrain),
        new ForwardOnBlueTape(drivetrain, sensor, forwardSpeed, colorValue),
        new TurnRightUntilBlueTape(drivetrain, sensor, turnSpeed, colorValue),
        new TurnDegrees(-0.65, 15, drivetrain),
        new ForwardOnBlueTape(drivetrain, sensor, forwardSpeed, colorValue),
        new TurnLeftUntilBlueTape(drivetrain, sensor, turnSpeed, colorValue),
        new TurnDegrees(0.65, 15, drivetrain),
        new ForwardOnBlueTape(drivetrain, sensor, forwardSpeed, colorValue),
        new TurnLeftUntilBlueTape(drivetrain, sensor, turnSpeed, colorValue),
        new TurnDegrees(0.65, 15, drivetrain));
  }
}
