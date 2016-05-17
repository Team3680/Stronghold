package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ClampOpen extends Command {

    public ClampOpen() {
    	requires(Robot.clamp);
    }

    protected void initialize() {
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kOff);
    	System.out.println("ClampOpen Init");
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kReverse);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        Timer.delay(0.5);
        return true;
    }

    protected void end() {
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kOff);
    	
    }

    protected void interrupted() {
    	end();
    }
}
