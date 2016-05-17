package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
    	requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.driveTrain.arcadeDrive(RobotMap.stick.getY(), RobotMap.stick.getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
