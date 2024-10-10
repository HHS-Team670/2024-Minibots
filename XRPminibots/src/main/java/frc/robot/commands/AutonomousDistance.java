// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  private double colorValue = 0.83;
  private double turnSpeed = 0.65;
  private double forwardSpeed = 0.65;

  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a
   * specified distance,
   * turn around and drive back
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain, ReflectiveSensor sensor) {
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
// initialize to reset distance sensor
// for (int i = 0; i <= 33; i++){
// addCommands(
// new DriveDistance(0.75, 1, drivetrain),
// new TurnDegrees(-2,drivetrain.m_gyro.getAngleZ(),drivetrain));
// System.out.println(drivetrain.m_gyro.getAngleZ());
// }
// addCommands(
// new TurnDegrees(-0.6, 45, drivetrain));
// for (int i = 0; i <= 27; i++){
// addCommands(
// new DriveDistance(0.75, 1, drivetrain),
// new TurnDegrees(-2,drivetrain.m_gyro.getAngleZ(),drivetrain));
// System.out.println(drivetrain.m_gyro.getAngleZ());
// }
// addCommands(
// new TurnDegrees(0.6, 45, drivetrain));

// }
