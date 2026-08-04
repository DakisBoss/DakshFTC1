package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Disabled
public class TestBench1 {
    private DcMotor motor;
    private double ticksPerRev;
    private DigitalChannel touchSensor;


    public void init(HardwareMap hwMap){
        //DC Motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotor.Direction.REVERSE);

        ticksPerRev = motor.getMotorType().getTicksPerRev();

        // Touch Sensor
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

    }

    public boolean isTouchSensorPressed(){
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased(){
        return touchSensor.getState();
    }

    public void setMotorSpeed(double speed){
        // gets values form -1.0 to 1.0
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;
    }

    public void setMotorZeroBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
            motor.setZeroPowerBehavior(zeroBehavior);
        }

}
