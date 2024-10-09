// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain, ReflectiveSensor reflectanceSensor) {
    addCommands(
      new BalanceDrive(1, 20, drivetrain, reflectanceSensor)
        // new DriveDistance(-2, 20, drivetrain),
        // new TurnDegrees(-1, 90, drivetrain),
        // new DriveDistance(2, 15, drivetrain),
        // new TurnDegrees(5, 45, drivetrain),
        // new DriveDistance(1, 10, drivetrain)
    );
        
  }
}
