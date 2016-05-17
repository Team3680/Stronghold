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
    public Joystick joystick1;
    public Joystick joystick2;
    
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
    public JoystickButton button9;

	public OI() {
		button1 = new JoystickButton(RobotMap.stick, 1);
		button1.whenPressed(new Launch());
		button3 = new JoystickButton(RobotMap.stick, 3);
		button3.whileHeld(new LiftLower());
		button2 = new JoystickButton(RobotMap.stick, 2);
		button2.whileHeld(new LiftHigher());
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


