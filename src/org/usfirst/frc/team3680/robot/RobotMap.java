package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int driveVictor1 = 7;
    public static int driveVictor2 = 8;
    public static int intakeTalon = 3;
    public static int liftTalon = 5;
    public static int clampSolForward = 0;
    public static int clampSolBackward = 1;
    public static int shooterSol1 = 2;
    public static int shooterSol2 = 3;
    public static int shooterSol3 = 4;
    public static int shooterSol4 = 5;
    
    public static double liftMotorSpeed = 1;
    public static double intakeMotorSpeed = 1;
    public static double intakeMotorSpeedNegative = -1;
    public static int liftUpper = 1;
    public static int liftLower = 2;
    
    //Will change talons to victors in drive. 
    public static Talon drive1;
    public static Talon drive2;
    public static Talon intake;
    public static Victor lift;
    public static DigitalInput liftUpperSwitch;
    public static DigitalInput liftLowerSwitch;
    public static DigitalInput intakeInSwitch;
    public static DigitalInput intakeOutSwitch;
    
    public static DoubleSolenoid clampSol = new DoubleSolenoid(clampSolForward,clampSolBackward);
    public static DoubleSolenoid shooterSolMain = new DoubleSolenoid(shooterSol1,shooterSol2);
    public static DoubleSolenoid shooterSolSecondary = new DoubleSolenoid(shooterSol3,shooterSol4);
    public static Compressor comp = new Compressor(0);
    
    public static RobotDrive driveTrain;
    
    public static Joystick stick = new Joystick(0);

    public static Encoder encoderIntake = new Encoder(6, 7, true);
    public static Encoder encoderLift = new Encoder(8, 9, true);
    
    public static void init() {
    	drive1 = new Talon(driveVictor1);
        drive2 = new Talon(driveVictor2);
        intake = new Talon(intakeTalon);
        lift = new Victor(liftTalon);
        liftUpperSwitch = new DigitalInput(liftUpper);
        liftLowerSwitch = new DigitalInput(liftLower);
        intakeInSwitch = new DigitalInput(3);
        intakeOutSwitch = new DigitalInput(4);
        driveTrain = new RobotDrive(drive1, drive2);
    }
}
