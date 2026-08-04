package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench1;

@Disabled
@TeleOp
public class DcMotorPractice extends OpMode {

    TestBench1 bench = new TestBench1();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
       double MotorSpeed = gamepad1.left_stick_y;
        bench.setMotorSpeed(MotorSpeed);

       if (gamepad1.a) {
           bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       }
       else if (gamepad1.b) {
           bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        telemetry.addData("Motor Revs", bench.getMotorRevs());
        telemetry.update();

    }
}
