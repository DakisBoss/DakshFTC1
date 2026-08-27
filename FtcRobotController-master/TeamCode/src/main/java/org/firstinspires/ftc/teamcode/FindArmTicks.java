package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "FindArmTicks", group = "Tools")
public class FindArmTicks extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        // Reset encoder so 0 starts at current position
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Instructions", "Use triggers to move arm and read encoder ticks");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Manual arm control using triggers
            double power = gamepad1.right_trigger - gamepad1.left_trigger;
            armMotor.setPower(power * 0.5); // 50% max speed for calibration safety

            // Display current position to write down
            telemetry.addData("Arm Position (Ticks)", armMotor.getCurrentPosition());
            telemetry.addData("Motor Power", power * 0.5);
            telemetry.update();
        }

        armMotor.setPower(0.0);
    }
}
