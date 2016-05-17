package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ClampClose extends Command {

    public ClampClose() {
    	requires(Robot.clamp);
    }

    protected void initialize() {
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kOff);
    	System.out.println("ClampClose Init");
    	RobotMap.clampSol.set(DoubleSolenoid.Value.kForward);
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
    }
}
