package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo clawServo;

    // Set your open and close position values
    public double openPosition = 0.5;
    public double closedPosition = 0.0;

    public void init(HardwareMap hwMap) {
        clawServo = hwMap.get(Servo.class, "clawServo");
    }

    public void open() {
        clawServo.setPosition(openPosition);
    }

    public void close() {
        clawServo.setPosition(closedPosition);
    }
}
