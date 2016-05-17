package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command {

    public IntakeOut() {
    	requires(Robot.intake);
    }
    
    protected void initialize() {
    	System.out.println("IntakeOut Init");
    	RobotMap.intake.set(0);
    }

    protected void execute() {
    	RobotMap.intake.set(RobotMap.intakeMotorSpeedNegative);
    }

    protected boolean isFinished() {
        if(RobotMap.intakeOutSwitch.get() == false) {
        	return true;
        } else {
        	return false;
        }
    }

    protected void end() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeOut End");
    }

    protected void interrupted() {
    	end();
    }
}
