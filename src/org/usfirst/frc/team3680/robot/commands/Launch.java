package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Launch extends Command {

    public Launch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.launch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kOff);
    	Timer.delay(0.5);
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kForward);
    	Timer.delay(2);
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kReverse);
    	Timer.delay(2);
    	RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kForward);
    	System.out.println("Launch Init");
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kOff);
    	*/
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kForward);
    	Timer.delay(3);
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kReverse);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Timer.delay(1.5);
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Launch isFinished");
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kOff);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
