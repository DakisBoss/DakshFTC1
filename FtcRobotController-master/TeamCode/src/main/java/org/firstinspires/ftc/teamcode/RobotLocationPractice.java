package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {
    double angle;
    double x;
    double y;

    //constructor method
    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        // this method normalizes robot headings between -180 and 180
        // this is useful for calculating turn angles, especially whenever crossing over 0,360 degree boundary

        double angle = this.angle; // copy the raw angle of imu
        while (angle > 180) {
            angle -= 360; // subtract till target range
        }
        while (angle <= -180) {
            angle += 360; // add till target range
        }
        return angle;
    }

    public void turnRobot(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    public void changeX(double changeAmount){
        x += changeAmount;
    }

    public void setX(double x){
        this.x= x ;
    }

    public double getx() {
        return this.x;
    }

    public void changeY(double changeAmount){
        y += changeAmount;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getY(){
        return this.y;
    }

}
