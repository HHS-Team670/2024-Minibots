// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;

public class AutonPath extends SequentialCommandGroup {
  //Sequentially runs commands in an auton path
  //NOTE: You can also create parallel command groups which run commands simultaneously (these are also treated like commands and can be nested within sequential command groups)
  
  public AutonPath() {
    addCommands(
      new DriveForward(1, 10),
      new TurnDegrees(1, -60),
      new DriveForward(1, 7),
      new TurnDegrees(1, 30),
      new ParallelCommand()
    );
  }
}
