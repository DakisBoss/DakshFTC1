package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.mechanisms.Arm;
import org.firstinspires.ftc.teamcode.mechanisms.Claw;

@TeleOp(name = "MainTeleOp", group = "TeleOp")
public class MainTeleOp extends LinearOpMode {

    // Create instances of your helper classes
    Arm arm = new Arm();
    Claw claw = new Claw();

    @Override
    public void runOpMode() {
        // Initialize drive motors
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        // Initialize helper mechanism classes
        arm.init(hardwareMap);
        claw.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //  DRIVETRAIN
            double forward = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1.0);

            frontLeft.setPower((forward + strafe + turn) / denominator);
            backLeft.setPower((forward - strafe + turn) / denominator);
            frontRight.setPower((forward - strafe - turn) / denominator);
            backRight.setPower((forward + strafe - turn) / denominator);

            //  ARM
            if (gamepad1.y) {
                arm.goHome();
            }
            else if (gamepad1.right_bumper) {
                arm.goToGetPosition();
            }
            else if (gamepad1.left_bumper) {
                arm.goToPutPosition();
            }

            //  CLAW
            if (gamepad1.a) {
                claw.open();
            }
            else if (gamepad1.b) {
                claw.close();
            }

            // Telemetry Output
            telemetry.addData("Arm Position", arm.getCurrentPosition());
            telemetry.update();
        }

        arm.stop();
    }
}
