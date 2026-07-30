package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class driveTrainPractice extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Initialize motors
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Push stick forward to go forward
            double x = gamepad1.left_stick_x;  // Push stick right to strafe right
            double rx = gamepad1.right_stick_x; // Push stick right to turn right

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all powers maintain the same ratio, but only when at least one is out of range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            
            // Omni wheel power
            double leftFrontPower = (y + x + rx) / denominator;
            double leftBackPower = (y - x + rx) / denominator;
            double rightFrontPower = (y - x - rx) / denominator;
            double rightBackPower = (y + x - rx) / denominator;

            leftFront.setPower(leftFrontPower);
            leftBack.setPower(leftBackPower);
            rightFront.setPower(rightFrontPower);
            rightBack.setPower(rightBackPower);
        }
    }
}
