package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeOut extends Command {

    public IntakeOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("IntakeOut Init");
    	RobotMap.intake.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.intake.set(RobotMap.intakeMotorSpeedNegative);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(RobotMap.intakeOutSwitch.get() == false) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeOut End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
