package horus;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.util.List;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="Arm Up", group="HorusHardware")
@Disabled

public class Arm_Up extends LinearOpMode {

    
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
    
    //Arm Up
    robot.Arm.setPower(-mid);
    sleep(1250);
    robot.Arm.setPower(0.0);
    sleep(50);
    
    }
    
}
