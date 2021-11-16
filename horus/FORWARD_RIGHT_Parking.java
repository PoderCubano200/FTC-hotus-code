package horus;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.util.List;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="FORWARD RIGHT Parking", group="HorusHardware")
@Disabled

public class FORWARD_RIGHT_Parking extends LinearOpMode {

    //This Autonomous Will make Horus move forward a bit, then Strafe Right 
    //and Stay in the Parking Zone of the Bridge
    HardwareHorus robot = new HardwareHorus(); // Using Horus' hardware

    @Override 
    public void runOpMode(){
    
    telemetry.addData("Status", "Initialize Hardware");
    telemetry.update();
    robot.init(hardwareMap);
    
    double max = robot.maxpow; // 1.00
    double mid = robot.midpow; // 0.75
    double min = robot.minpow; // 0.50

    // Send telemetry message to signify robot waiting;
    telemetry.addData("Status", "Hello! Waiting For Start"); 
    telemetry.update();

    // Wait for the game to start (driver presses PLAY)
    waitForStart();
    
    /*
    List of Autonomous Commands located in HardwareHorus.java
    
    DriveForward(power)                  StrafeLeft(power)
    DriveBackwards(power)                StrafeRight(power)
    TurnLeft(power)                      AutoHookDown()
    TurnRight(power)                     AutoHookUp()
    GrabPlate()                          ReleasePlate()
    StopAllWheelMotors()
    */
    
    robot.Arm.setPower(mid);
    sleep(1000);
    robot.Arm.setPower(0.0);
    sleep(50);
    
    //Horus Will Wait 15 Seconds to allow other teams to perform their Code 
    robot.StopAllWheelMotors();
    sleep(15000);
    
    //Horus will move Forward towards the center of the field 
    robot.DriveForward(mid);
    sleep(900);
    robot.StopAllWheelMotors();
    sleep(50);
    
    //Horus will Strafe Right towards under the Alliance Bridge
    robot.StrafeRight(mid);
    sleep(1700);
    robot.StopAllWheelMotors();
    sleep(50);
    
    }
    
}
