package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench1;

@TeleOp
public class ArmMovement extends LinearOpMode {

    int arm0Position = 0;
    int armGetPosition = 500; // Update with tick value from FindArmTicks
    int armPutPosition = 400; // Update with tick value from FindArmTicks

    TestBench1 bench = new TestBench1();

    @Override
    public void runOpMode() {
        bench.init(hardwareMap);

        bench.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bench.motor.setTargetPosition(arm0Position);
        bench.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bench.setMotorSpeed(0.6);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.y) {
                bench.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                bench.motor.setTargetPosition(arm0Position);
                bench.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                bench.setMotorSpeed(0.6);
            }
            else if (gamepad1.right_bumper) {
                bench.motor.setTargetPosition(armGetPosition);
                bench.setMotorSpeed(0.6);
            }
            else if (gamepad1.left_bumper) {
                bench.motor.setTargetPosition(armPutPosition);
                bench.setMotorSpeed(0.6);
            }

            telemetry.addData("Position", bench.motor.getCurrentPosition());
            telemetry.update();
        }
    }
}
