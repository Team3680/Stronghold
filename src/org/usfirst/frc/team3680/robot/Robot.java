
package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3680.robot.commands.Autonomous;
import org.usfirst.frc.team3680.robot.commands.ExampleCommand;
import org.usfirst.frc.team3680.robot.subsystems.Clamp;
import org.usfirst.frc.team3680.robot.subsystems.Compressor;
import org.usfirst.frc.team3680.robot.subsystems.Drive;
import org.usfirst.frc.team3680.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.Intake;
import org.usfirst.frc.team3680.robot.subsystems.Launch;
import org.usfirst.frc.team3680.robot.subsystems.Lift;
import org.usfirst.frc.team3680.robot.subsystems.Spin;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Robot extends IterativeRobot {
    public boolean spinDirection;
    public boolean spinEnabled;
	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static Clamp clamp = new Clamp();
	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	public static Launch launch = new Launch();
	public static Lift lift = new Lift();
	public static Spin spin = new Spin();
	public static OI oi;
	public static Compressor compressor = new Compressor();
	
	CameraServer server;

    Command autonomousCommand;
    SendableChooser chooser;
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

        //RobotMap.comp.setClosedLoopControl(false);
        SmartDashboard.putBoolean("Compressor Status", RobotMap.comp.enabled());

        // RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kReverse);
        clamp = new Clamp();
        launch = new Launch();
        intake = new Intake();
        lift = new Lift();
        drive = new Drive();
        spin = new Spin();
        compressor = new Compressor();
        spinEnabled = false;
        spinDirection = false;
        System.out.println("Robot Initiailized");
        button11 = new JoystickButton(RobotMap.stick, 11);
        button10 = new JoystickButton(RobotMap.stick, 10);
        button9 = new JoystickButton(RobotMap.stick, 9);
        button10left = new JoystickButton(RobotMap.otherstick, 10);
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
public int timeSinceCompCut;
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
        //SmartDashboard.putNumber("Lift Position", RobotMap.encoderLift.get());
        //SmartDashboard.putNumber("Intake Position", RobotMap.encoderIntake.get());
        //RobotMap.comp.start();
        //SmartDashboard.putString("CompressorToggle", "COMPRESSOR ENABLED");
        driveStatus = true;
    }
    public boolean button10Last;
    public boolean button11Last;
    public boolean button9Last;
    public boolean button10LeftLast;
    public double xaxis;
    public double yaxis;
    public double xdrive;
    public double ydrive;

    public void teleopPeriodic() {
    	//SmartDashboard.putBoolean("Compressor Status", RobotMap.comp.enabled());
    	//SmartDashboard.putBoolean("pSwitch", pSwitch.get());
    	boolean switchValue = RobotMap.comp.getPressureSwitchValue();
    	
    	//SmartDashboard.putInt("LiftEncoder", RobotMap.encoderLift.get());
    	//SmartDashboard.putInt("WheelLiftEncoder", RobotMap.encoderIntake.get());
    	Scheduler.getInstance().run();
    	// RobotMap.driveTrain.arcadeDrive(RobotMap.stick.getY(), -RobotMap.stick.getX());
    	//SmartDashboard.putBoolean("WheelLift Upper", RobotMap.intakeInSwitch.get());
        //SmartDashboard.putBoolean("WheelLift Lower", RobotMap.intakeOutSwitch.get()); 
        //SmartDashboard.putBoolean("PressureSwitchValue", switchValue);
        //SmartDashboard.putBoolean("Lift Upper", RobotMap.liftUpperSwitch.get());
        //SmartDashboard.putBoolean("Lift Lower", RobotMap.liftLowerSwitch.get());

    	if(button10left.get() == true && button10LeftLast == false) {
    		button10LeftLast = true;
    		if(compDisable == true) {
    			compDisable = false;
    		} else {
    			compDisable = true;
    		}
    		
    	}
       /* if(button9.get() == true && button9Last == false) {
        	button9Last = true;
        	if(driveStatus == true) {
        		driveStatus = false;
        	} else {
        		driveStatus = true;
        	}
        } else if(button9.get() == false) {
        	button9Last = false;

        }

        
        if(button11.get() == true && button11Last == false) {
        	button11Last = true;
        	if(spinEnabled == true) {
        		spinEnabled = false;
        	} else {
        		spinEnabled = true;
        	}
        } else if (button11.get() == false) {
        	button11Last = false;
        }
        
        if(button10.get() == true && button10Last == false) {
        	button10Last = true;
        	if(spinDirection == true) {
        		spinDirection = false;
        	} else {
        		spinDirection = true;
        	}
        } else if (button10.get() == false) {
        	button10Last = false;
        }
        
        if(spinEnabled == true) {
        	if (spinDirection == true ) {
        		RobotMap.spin.set(1);
        		SmartDashboard.putString("SpinnerDirection", "backward");
        	} else {
        		RobotMap.spin.set(-1);
        		SmartDashboard.putString("SpinnerDirection", "forward");
        	}
        } else {
        	RobotMap.spin.set(0);
        }*/
        
        if(pSwitch.get() == true || compDisable == true) {
        	RobotMap.comp.stop();
        	timeSinceCompCut = 0;
        } else {
        	timeSinceCompCut++;
        	if(timeSinceCompCut > 2000000 || compDisable == false) {
        		RobotMap.comp.start();
        	}
        }
        
        /*if(driveStatus == true) {
    		RobotMap.driveTrain.arcadeDrive(RobotMap.stick.getY(), -RobotMap.stick.getX());
        	//xaxis = RobotMap.stick.getX();
        	//yaxis = RobotMap.stick.getY();
        	//RobotMap.driveTrain.arcadeDrive(RobotMap.stick);
        	//RobotMap.drive1.set(xaxis);
        	//RobotMap.drive2.set
        	SmartDashboard.putString("Drive Status", "ORIGINAL DIRECTIONS");
    	} else { 
    		RobotMap.driveTrain.arcadeDrive(-RobotMap.stick.getY(), RobotMap.stick.getX());
    		SmartDashboard.putString("Drive Status", "OPPOSITE DIRECTIONS");
        }*/
        
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
