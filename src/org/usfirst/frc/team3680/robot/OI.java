package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3680.robot.commands.*;
import org.usfirst.frc.team3680.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public JoystickButton button6;
    public JoystickButton button7;
    public JoystickButton button8;
    public JoystickButton button11;
    public JoystickButton button10;
    public JoystickButton button1;
    public JoystickButton button2;
    public JoystickButton button3;
    public JoystickButton button4;
    public JoystickButton button5;
    public Joystick joystick1;
    public Joystick joystick2;
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public OI() {
		button1 = new JoystickButton(RobotMap.stick, 1);
		
		button1.whenPressed(new Launch());
		button3 = new JoystickButton(RobotMap.stick, 3);
		button3.whileHeld(new LiftHigher());
		button2 = new JoystickButton(RobotMap.stick, 2);
		button2.whileHeld(new LiftLower());
		button6 = new JoystickButton(RobotMap.stick, 6);
		button6.whileHeld(new IntakeIn());
		button7 = new JoystickButton(RobotMap.stick, 7);
		button7.whileHeld(new IntakeOut());
		button4 = new JoystickButton(RobotMap.stick, 4);
		button4.whenPressed(new ClampOpen());
		button5 = new JoystickButton(RobotMap.stick, 5);
		button5.whenPressed(new ClampClose());
		
	}
}


