package horus;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name="Horus", group="HorusHardware")
public class Horus extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareHorus robot = new HardwareHorus(); // Using Horus' hardware

    //Variables
    double drive;
    double strafe;
    double spin;
    double lift;
    double liftrotate;
    double grabmove;

    @Override
    public void runOpMode() throws InterruptedException

    {
        telemetry.addData("Status", "Initialize Hardware");
        telemetry.update();
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Hello! Waiting For Start"); 
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            /** DRIVE CONTROLS
             * GAMEPAD 1
             * Drive with right stick and spin with left trigger and left stick x
             * Intake with right trigger and left stick
             * Control auto arm with button x
             * GAMEPAD 2
             * Lift up with right stick y and lift rotate with right stick x
             * Move grabber with left stick x
             * Grab with button a
             */

            //Define Variables

            //Gamepad 1
            drive= -gamepad1.left_stick_y;
            strafe= gamepad1.left_stick_x;
            spin= -gamepad1.right_stick_x;
            
            //Gamepad 2
            lift=-gamepad2.right_stick_y;
            grabmove=-gamepad2.left_stick_x;

            liftrotate=gamepad2.right_stick_y;
            

            //TELEOP

            //***Wheel Movement***
            
            robot.rightFront.setPower(drive-strafe+spin);
            robot.rightBack.setPower(drive+strafe+spin);
            robot.leftFront.setPower(-drive-strafe+spin);
            robot.leftBack.setPower(-drive+strafe+spin);


            //***Intake Motors***
            
            //INTAKE IN 
            if (gamepad1.dpad_down)
            {
                robot.intakeRight.setPower(robot.INTAKE_IN);
                robot.intakeLeft.setPower(-robot.INTAKE_IN);
            }
            
            //INTAKE OUT 
            if (gamepad1.dpad_up)
            {
                robot.intakeRight.setPower(robot.INTAKE_OUT);
                robot.intakeLeft.setPower(-robot.INTAKE_OUT);
            }
            
            //STOP INTAKE MOTORS
            if (gamepad1.dpad_left)
            {
                robot.intakeRight.setPower(0.0);
                robot.intakeLeft.setPower(0.0);
            }
            
            //***Block Holder***
            
            //Push the Block INSIDE
            if (gamepad2.left_stick_y > 0.5)
            {
                robot.Holder.setPosition(0.75);
            }
            
            //Open Access for Block
            if (gamepad2.left_stick_y < -0.5)
            {
                robot.Holder.setPosition(0.25);
            }
            
            //Stop Holder Servo
            if (gamepad2.left_stick_y >= -0.5 && gamepad2.left_stick_y <= 0.5)
            {
                robot.Holder.setPosition(0.50);
            }
            
            //***ARM LIFT***
            
            //Arm Up 
            if (gamepad2.right_stick_y < -0.5)
            {
                robot.Arm.setPower(robot.ARM_UP_POWER);
            }
            
            //Arm Down
            if (gamepad2.right_stick_y > 0.5)
            {
                robot.Arm.setPower(robot.ARM_DOWN_POWER);
            }
            
            //Stop Arm Motor
            if (gamepad2.right_stick_y >= -0.5 && gamepad2.right_stick_y <= 0.5)
            {
                robot.Arm.setPower(0.0);
            }
            
            //***BLOCK TURNER***
            
            //TURNER INSIDE
            if (gamepad2.right_bumper)
            {
                robot.Turner.setPosition(robot.TURNER_IN);
            }
            
            //TURNER OUTSIDE
            if (gamepad2.left_bumper)
            {
                robot.Turner.setPosition(robot.TURNER_OUT);
            }
            
            //***BLOCK HOOK***
            
            //Hook Up 
            if (gamepad2.b)
            {
                robot.Hook.setPosition(robot.HOOK_UP);
            }
            
            //Hook Down
            if (gamepad2.a)
            {
                robot.Hook.setPosition(robot.HOOK_DOWN);
            }
            
            //***PLATE GRAB***
            
            //Grabbing Plate
            if (gamepad1.right_bumper)
            {
                robot.plateLeft.setPosition(1.0);
                robot.plateRight.setPosition(0.0);
            }
            
            //Releasing Plate
            if (gamepad1.left_bumper)
            {
                robot.plateLeft.setPosition(0.6);
                robot.plateRight.setPosition(0.5);
            }
            
            //***Autonomous Hook (For Emergency)***
            
            //Hook Up  
            if (gamepad1.y)
            {
                robot.AutoHook.setPosition(0.0);
            }
            
            //Hook Down
            if (gamepad1.x)
            {
                robot.AutoHook.setPosition(0.5);
            }

        }
    }
}
