package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3680.robot.commands.Autonomous;
import org.usfirst.frc.team3680.robot.subsystems.Clamp;
import org.usfirst.frc.team3680.robot.subsystems.Drive;
import org.usfirst.frc.team3680.robot.subsystems.Intake;
import org.usfirst.frc.team3680.robot.subsystems.Launch;
import org.usfirst.frc.team3680.robot.subsystems.Lift;

public class Robot extends IterativeRobot {
    public boolean spinDirection;
    public boolean spinEnabled;

	public static Clamp clamp = new Clamp();
	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	public static Launch launch = new Launch();
	public static Lift lift = new Lift();
	
	public static OI oi;
	
	CameraServer server;

    Command autonomousCommand;
    public JoystickButton button11;
    public JoystickButton button10;
    public JoystickButton button8;
    public JoystickButton button9;
    public JoystickButton button10left;
    
    public boolean driveStatus;
    public boolean compDisable;
    
    public boolean pressureSwitch;
    public DigitalInput pSwitch;
    
    public void robotInit() {
    	pSwitch = new DigitalInput(5);
    	autonomousCommand = new Autonomous();
    	RobotMap.init();
		oi = new OI();

        clamp = new Clamp();
        launch = new Launch();
        intake = new Intake();
        lift = new Lift();
        drive = new Drive();

        button11 = new JoystickButton(RobotMap.stick, 11);
        button10 = new JoystickButton(RobotMap.stick, 10);
        button9 = new JoystickButton(RobotMap.stick, 9);
        button10left = new JoystickButton(RobotMap.otherstick, 10);
        System.out.println("Robot Initiailized");
    }
	
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        driveStatus = true;
    }
    
    /* 
     * The majority of the following things in the teleopPeriodic method could have been
     * completed in a different class, which would have improved the efficiency of the
     * robot, expecially when connected to the FMS.
     */
    
    public int timeSinceCompCut;
    public boolean button10Last;
    public boolean button11Last;
    public boolean button9Last;
    public boolean button10LeftLast;

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
    	RobotMap.driveTrain.arcadeDrive(RobotMap.stick.getY(), -RobotMap.stick.getX());

    	if(button10left.get() == true && button10LeftLast == false) {
    		button10LeftLast = true;
    		if(compDisable == true) {
    			compDisable = false;
    		} else {
    			compDisable = true;
    		}
    		
    	}
    	
    	/*
    	 * The following method for doing compressors is completely unrecommended. We had to
    	 * do this in the heat of competition due to a PCM error.
    	 */
        
        if(pSwitch.get() == true || compDisable == true) {
        	RobotMap.comp.stop();
        	timeSinceCompCut = 0;
        } else {
        	timeSinceCompCut++;
        	if(timeSinceCompCut > 200 || compDisable == false) {
        		RobotMap.comp.start();
        	}
        }
        
        if(RobotMap.liftLowerSwitch.get() == false) {
        	RobotMap.encoderLift.reset();
        }
        if(RobotMap.intakeInSwitch.get() == false) {
        	RobotMap.encoderIntake.reset();
        }
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
