// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.SetArmPosition;
import frc.robot.commands.drivetrain.TurnDegrees;
import frc.robot.subsystems.Arm.ArmPosition;

public class ParallelCommand extends ParallelCommandGroup {
  public ParallelCommand() {
    addCommands(
      new TurnDegrees(1, 90),
      new SetArmPosition(ArmPosition.UP)
    );
  }
}


//Sequentially runs commands in an auton path
  //NOTE: You can also create sequential command groups which run commands simultaneously (these are also treated like commands and can be nested within parallel command groups)