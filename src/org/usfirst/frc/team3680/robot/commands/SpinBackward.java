package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinBackward extends Command {

    public SpinBackward() {
        requires(Robot.spin);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.spin.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.spin.set(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.spin.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
