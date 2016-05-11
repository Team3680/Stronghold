package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CompressorToggle extends Command {

    public CompressorToggle() {
       requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.comp.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("CompressorToggle", "COMPRESSOR DISABLED");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Timer.delay(1);
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
