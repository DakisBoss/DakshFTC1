package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench1;

@TeleOp
public class FindArmTicks extends LinearOpMode {

    TestBench1 bench = new TestBench1();

    @Override
    public void runOpMode() {
        bench.init(hardwareMap);

        bench.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bench.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            bench.setMotorSpeed(-gamepad1.right_stick_y * 0.5);

            telemetry.addData("Current Ticks", bench.motor.getCurrentPosition());
            telemetry.addData("Revolutions", bench.getMotorRevs());
            telemetry.update();
        }
    }
}
