package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

    public AutoDrive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	setTimeout(2.5);
    	
    }

    protected void execute() {
    	RobotMap.driveTrain.arcadeDrive(.9,0);
    	RobotMap.spin.set(-1);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	RobotMap.driveTrain.arcadeDrive(0,0);
    	RobotMap.spin.set(0);
    }

    protected void interrupted() {
    	end();
    }
}
