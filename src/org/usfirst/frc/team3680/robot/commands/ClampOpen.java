package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClampOpen extends Command {

    public ClampOpen() {
    	requires(Robot.clamp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kOff);
    	System.out.println("ClampOpen Init");
    	Timer.delay(2);
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kReverse);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Timer.delay(2);
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
