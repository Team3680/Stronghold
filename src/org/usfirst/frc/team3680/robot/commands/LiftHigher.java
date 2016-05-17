package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LiftHigher extends Command {

    public LiftHigher() {
    	requires(Robot.lift);
    }

    protected void initialize() {
    	RobotMap.lift.set(0);
    	System.out.println("LiftHigher Init");
    }

    protected void execute() {
    	RobotMap.lift.set(RobotMap.liftMotorSpeed);
    }

    protected boolean isFinished() {
        if(RobotMap.liftUpperSwitch.get() == false){
        	return true;
        } else {
        	return false;
        }
    }

    protected void end() {
    	RobotMap.lift.set(0);
    }

    protected void interrupted() {
    	end();
    }
}
