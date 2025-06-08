package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.ArmPosition;

public class SetArmPosition extends InstantCommand {
    private Arm mArm;
    private ArmPosition armPosition;

    public SetArmPosition(ArmPosition armPos) {
        this.mArm = Arm.getInstance();
        this.armPosition = armPos;
        addRequirements(mArm);
    }

    @Override
    public void initialize() {
        mArm.setAngle(armPosition);
    }
}