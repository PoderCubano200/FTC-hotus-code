package horus;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class HardwareHorus
{
    /* Public OpMode members. */
    public DcMotor  rightFront  =null;
    public DcMotor  rightBack   =null;
    public DcMotor  leftFront   =null;
    public DcMotor  leftBack    =null;
    public DcMotor  intakeRight =null;
    public DcMotor  intakeLeft  =null;
    public DcMotor  Arm         =null;
    
    public Servo    Holder      =null;
    public Servo    Hook        =null;
    public Servo    Turner      =null;
    public Servo    plateRight  =null;
    public Servo    plateLeft   =null;
    public Servo    AutoHook    =null;

    public static final double ARM_UP_POWER    = -0.75 ;
    public static final double ARM_DOWN_POWER  =  0.75 ;
    public static final double INTAKE_IN       = -0.50 ;         
    public static final double INTAKE_OUT      =  0.50 ;
    public static final double TURNER_IN       =  0.00 ;
    public static final double TURNER_OUT      =  1.00 ;
    public static final double HOOK_UP         =  0.50 ;
    public static final double HOOK_DOWN       =  0.00 ;
    public static final double maxpow          =  1.00 ;
    public static final double midpow          =  0.75 ;
    public static final double minpow          =  0.50 ;
 
    /* local OpMode members. */
   
    private ElapsedTime period  = new ElapsedTime();
    
        HardwareMap hwMap = null;


    /* Constructor */
    public HardwareHorus(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        
        rightFront  = hwMap.get(DcMotor.class, "rightFront");
        rightBack   = hwMap.get(DcMotor.class, "rightBack");
        leftFront   = hwMap.get(DcMotor.class, "leftFront");
        leftBack    = hwMap.get(DcMotor.class, "leftBack");
        intakeRight = hwMap.get(DcMotor.class, "intakeRight");
        intakeLeft  = hwMap.get(DcMotor.class, "intakeLeft");
        Arm         = hwMap.get(DcMotor.class, "Arm");
        
        Holder      =hwMap.get(Servo.class, "Holder");
        Hook        =hwMap.get(Servo.class, "Hook");
        Turner      =hwMap.get(Servo.class, "Turner");
        plateRight  =hwMap.get(Servo.class, "plateRight");
        plateLeft   =hwMap.get(Servo.class, "plateLeft");
        AutoHook    =hwMap.get(Servo.class, "AutoHook");
     
    }
    
    //All Methods and Functions Used in future Autonomous Codes
    
    public void StopAllWheelMotors (){
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
    }
    
    public void DriveForward (double pow){
        //NEEDS FIXING
        //THIS MAY NOT BE CORRECT
        rightFront.setPower(pow);
        rightBack.setPower(pow);
        leftFront.setPower(pow);
        leftBack.setPower(pow);
    }
    
    public void DriveBackwards(double pow){
        
    }
    
    public void StrafeRight(double pow){
        
    }
    
    public void StrafeLeft(double pow){
        
    }
    
    public void TurnRight(double pow){
        
    }
    
    public void TurnLeft(double pow){
        
    }
    
    public void AutoHookDown(){
        
    }
    
    public void AutoHookUp(){
        
    }
    
    public void GrabPlate(){
        
    }
    
    public void ReleasePlate(){
        
    }
    
 }

