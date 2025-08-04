// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auton.AutonPath;
import frc.robot.joystickUtils.XboxJoysticButtons;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The container for the robot. Contains subsystems, input/output devices
  public RobotContainer() {
    // Configure the button bindings
    XboxJoysticButtons.configureJoysticks(OI.getDriverController());
    OI.configureDefaultDriveCommand();
    OI.configureDriverControls();
  }

  // Returns the command to be run during the autonomous period
  public Command getAutonomousCommand() {
    return new AutonPath();
  }
}
