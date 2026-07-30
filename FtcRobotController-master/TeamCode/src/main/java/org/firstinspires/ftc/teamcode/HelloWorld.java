package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@Autonomous
public class HelloWorld extends OpMode {
    // Says Hello World on control hub
    @Override
    public void init() {
        telemetry.addData("Hello", " Daksh!");
    }

    @Override
    public void loop() {

    }
    /*
    This is a multi-line comment
     */
}
