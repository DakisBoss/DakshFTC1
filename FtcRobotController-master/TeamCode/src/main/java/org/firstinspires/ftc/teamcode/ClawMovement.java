package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench1;

@TeleOp
public class ClawMovement extends LinearOpMode {

    TestBench1 bench = new TestBench1();

    double OPEN_POSITION = 0;
    double CLOSED_POSITION = 1;

    @Override
    public void runOpMode() {
        bench.init(hardwareMap);

        // Start claw open
        bench.setClawPosition(OPEN_POSITION);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.x) {
                bench.setClawPosition(CLOSED_POSITION);
            }
            else if (gamepad1.b) {
                bench.setClawPosition(OPEN_POSITION);
            }

            telemetry.addData("Claw Target Position", bench.clawServo.getPosition());
            telemetry.update();
        }
    }
}
