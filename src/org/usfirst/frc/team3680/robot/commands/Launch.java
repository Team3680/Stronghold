package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;
import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Launch extends Command {

    public Launch() {
    	requires(Robot.launch);
    }

    protected void initialize() {
    	/*
    	 * The following is our legacy method for launching.
    	 * 
    	 * RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kOff);
    	 * Timer.delay(0.5);
    	 * RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kForward);
    	 * Timer.delay(2);
    	 * RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kReverse);
    	 * Timer.delay(2);
    	 * RobotMap.shooterSolSecondary.set(DoubleSolenoid.Value.kForward);
    	 * System.out.println("Launch Init");
    	 * RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kOff);
    	*/
    	
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kForward);
    	Timer.delay(3);
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kReverse);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        Timer.delay(1.5);
        return true;
    }

    protected void end() {
    	System.out.println("Launch isFinished");
    	RobotMap.shooterSolMain.set(DoubleSolenoid.Value.kOff);
    	
    }

    protected void interrupted() {
    }
}
