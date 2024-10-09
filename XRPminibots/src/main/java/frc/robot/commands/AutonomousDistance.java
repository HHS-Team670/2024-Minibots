// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain, ReflectiveSensor sensor) {
    
    addCommands(
        // new DriveAutoAlign(39, 2, 180, drivetrain),
        // new TurnDegrees(-2, 90, drivetrain) );
        // new DriveDistance(-3, 2.0, drivetrain),
        // new TurnDegrees(3, 50, drivetrain),
        // new DriveDistance(-3, 2.0, drivetrain),
        // new TurnDegrees(3, 90, drivetrain),
        new ProtectedDrive(drivetrain, sensor, 2)
        

        );
  }
}
