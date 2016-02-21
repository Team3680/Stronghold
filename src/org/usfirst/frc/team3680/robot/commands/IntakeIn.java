package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIn extends Command {

    public IntakeIn() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeIn Init");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.intake.set(RobotMap.intakeMotorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(RobotMap.intakeInSwitch.get() == false) {
    		return true;
    	} else {
    		return false;
    	}
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeIn End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
