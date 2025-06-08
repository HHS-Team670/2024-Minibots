package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.MustangController.XboxButtons;
import frc.robot.commands.LineFollowing;
import frc.robot.commands.SetArmPosition;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm.ArmPosition;

public final class OI {
  // Controllers
  private static MustangController mController = new MustangController(0);

  public static MustangController getController() {
    return mController;
  }

  public static void configureButtonBindings() {
    // Set the default drive command of the drivebase to the teleop drive command
    Drivetrain mDrivetrain = Drivetrain.getInstance();
    mDrivetrain.setDefaultCommand(getTeleopDriveCommand());

    JoystickButton joystickAButton = new JoystickButton(mController, XboxButtons.A);
    joystickAButton.onTrue(new SetArmPosition(ArmPosition.STOW));

    JoystickButton joystickYButton = new JoystickButton(mController, XboxButtons.Y);
    joystickYButton.onTrue(new SetArmPosition(ArmPosition.UP));

    JoystickButton joystickBButton = new JoystickButton(mController, XboxButtons.B);
    joystickBButton.onTrue(new LineFollowing(0.65, 0.83));

    // Example of how to use a trigger button on the joystick
    Trigger rightTrigger = mController.rightTrigger();

    // Example of how to use the dpad on the joystick
    // Angle is 0 at the top dpad button and increments 45 degrees clockwise up
    // until 315
    POVButton dpadUp = new POVButton(mController, 0);
  }

  // Returns the command that will be set as the drive command during tele-op
  public static Command getTeleopDriveCommand() {
    return new ArcadeDrive(
        () -> -mController.getRawAxis(1), () -> -mController.getRawAxis(2));

    // return new ArcadeDrive(mDrivetrain, () -> -mController.getLeftStickY(), () ->
    // -mController.getRightStickX());
  }
}
