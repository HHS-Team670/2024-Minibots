// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonPath extends SequentialCommandGroup {

  //Sequentially runs commands in an auton path
  //NOTE: You can also create parallel command groups which run commands simultaneously (these can also be put as a single command in a sequential command group)
  public AutonPath() {
    addCommands();
  }
}
