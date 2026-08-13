package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
    public class DriveTrain extends LinearOpMode {

        @Override
        public void runOpMode() {
            DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            DcMotor backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            DcMotor backRight = hardwareMap.get(DcMotor.class, "backRight");


            frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
            backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

            waitForStart();

            while (opModeIsActive()) {
                double forward = -gamepad1.left_stick_y;
                double strafe = gamepad1.left_stick_x;
                double turn = gamepad1.right_stick_x;


                double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1.0);


                double leftFrontPower = (forward + strafe + turn) / denominator;
                double leftBackPower = (forward - strafe + turn) / denominator;
                double rightFrontPower = (forward - strafe - turn) / denominator;
                double rightBackPower = (forward + strafe - turn) / denominator;

                // Apply power to hardware
                frontLeft.setPower(leftFrontPower);
                backLeft.setPower(leftBackPower);
                frontRight.setPower(rightFrontPower);
                backRight.setPower(rightBackPower);
            }
        }
    }
