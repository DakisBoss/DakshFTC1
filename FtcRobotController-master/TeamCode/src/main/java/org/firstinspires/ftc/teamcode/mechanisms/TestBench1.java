package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBench1 {
    public DcMotor motor;
    public Servo clawServo;
    public double ticksPerRev;

    public int ticks;

    public void init(HardwareMap hwMap) {
        // Arm Motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotor.Direction.REVERSE);

        ticksPerRev = motor.getMotorType().getTicksPerRev();
        ticks = motor.getCurrentPosition();

        // Claw Servo
        clawServo = hwMap.get(Servo.class, "claw_servo");
    }

    public void setClawPosition(double position) {
        clawServo.setPosition(position);
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;
    }

    public void setZeroBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }
}
