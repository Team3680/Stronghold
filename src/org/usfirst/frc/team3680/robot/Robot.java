
package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3680.robot.commands.Autonomous;
import org.usfirst.frc.team3680.robot.commands.ExampleCommand;
import org.usfirst.frc.team3680.robot.subsystems.Clamp;
import org.usfirst.frc.team3680.robot.subsystems.Drive;
import org.usfirst.frc.team3680.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.Intake;
import org.usfirst.frc.team3680.robot.subsystems.Launch;
import org.usfirst.frc.team3680.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static Clamp clamp = new Clamp();
	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	public static Launch launch = new Launch();
	public static Lift lift = new Lift();
	public static OI oi;
	
	CameraServer server;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
    	autonomousCommand = new Autonomous();
    	RobotMap.init();
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        RobotMap.comp.setClosedLoopControl(true);
        /**
        server = CameraServer.getInstance();
        server.setQuality(45);
        server.startAutomaticCapture("cam0"); **/
        RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kReverse);
        clamp = new Clamp();
        launch = new Launch();
        intake = new Intake();
        lift = new Lift();
        drive = new Drive();
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
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
        SmartDashboard.putNumber("Lift Position", RobotMap.encoderLift.get());
        SmartDashboard.putNumber("Intake Position", RobotMap.encoderIntake.get());
        
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        RobotMap.driveTrain.arcadeDrive(RobotMap.stick.getY(), RobotMap.stick.getX());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
