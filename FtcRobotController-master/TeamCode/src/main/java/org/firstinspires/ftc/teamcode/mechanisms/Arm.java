package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private DcMotor armMotor;

    // Encoder target positions (adjust these values after running FindArmTicks)
    public int homePosition = 0;
    public int getPosition = 500;
    public int putPosition = 400;

    public void init(HardwareMap hwMap) {
        armMotor = hwMap.get(DcMotor.class, "armMotor");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setDirection(DcMotor.Direction.REVERSE);

        armMotor.setTargetPosition(homePosition);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.6);
    }

    public void goHome() {
        armMotor.setTargetPosition(homePosition);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.6);
    }

    public void goToGetPosition() {
        armMotor.setTargetPosition(getPosition);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.6);
    }

    public void goToPutPosition() {
        armMotor.setTargetPosition(putPosition);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.6);
    }

    public int getCurrentPosition() {
        return armMotor.getCurrentPosition();
    }

    public void stop() {
        armMotor.setPower(0.0);
    }
}
