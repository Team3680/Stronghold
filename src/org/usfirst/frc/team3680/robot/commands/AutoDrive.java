package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

    public AutoDrive() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrain.arcadeDrive(0.8, 0);
    	Timer.delay(2);
    	RobotMap.driveTrain.arcadeDrive(0,0);
    	Timer.delay(0.5);
    	RobotMap.driveTrain.arcadeDrive(0, 0.5);
    	Timer.delay(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Timer.delay(4);
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveTrain.arcadeDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
