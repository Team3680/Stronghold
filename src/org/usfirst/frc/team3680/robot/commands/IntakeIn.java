package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command {

    public IntakeIn() {
        requires(Robot.intake);
    }

    protected void initialize() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeIn Init");
    }

    protected void execute() {
    	RobotMap.intake.set(RobotMap.intakeMotorSpeed);
    }

    protected boolean isFinished() {
    	if(RobotMap.intakeInSwitch.get() == false) {
    		return true;
    	} else {
    		return false;
    	}
        
    }

    protected void end() {
    	RobotMap.intake.set(0);
    	System.out.println("IntakeIn End");
    }

    protected void interrupted() {
    	end();
    }
}
