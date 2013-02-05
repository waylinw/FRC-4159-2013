/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team4159.frc2013;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.HiTechnicColorSensor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Talon;
import org.team4159.support.CombinedMotor;

/**
 *
 * @author gavin
 */
public class IO
{
	public static final double DRIVE_KP = 0.5;
	public static final double DRIVE_KI = 0.1;
	public static final double DRIVE_KD = 0.0;
	
	// To avoid changes, make sure all declarations are "public static final".
	
	/****************************************
	 * JOYSTICKS                            *
	 ****************************************/
	public static final Joystick joystick1 = new Joystick (1);
	public static final Joystick joystick2 = new Joystick (2);
	
	/****************************************
	 * SENSORS                              *
	 ****************************************/
	public static final Encoder driveEncoderLeft = new Encoder (1, 2);
	public static final Encoder driveEncoderRight = new Encoder (3, 4);
	static {
		final double distancePerPulse = 0.0001; // FIX ME!!!!!!
		driveEncoderLeft.setDistancePerPulse (distancePerPulse);
		driveEncoderRight.setDistancePerPulse (distancePerPulse);
		driveEncoderLeft.start ();
		driveEncoderRight.start ();
	}
	
	public static final DigitalInput pressureSwitch = new DigitalInput (5);
	
	public static final HiTechnicColorSensor frisbeeColorSensor =
		new HiTechnicColorSensor (SensorBase.getDefaultDigitalModule ());
	
	/****************************************
	 * MOTORS                               *
	 ****************************************/
	public static final Talon driveMotorLeftFront = new Talon (1);
	public static final Talon driveMotorLeftRear = new Talon (2);
	public static final Talon driveMotorRightFront = new Talon (3);
	public static final Talon driveMotorRightRear = new Talon (4);
	
	public static final CombinedMotor driveMotorLeft =
		new CombinedMotor (driveMotorLeftFront, driveMotorLeftRear);
	public static final CombinedMotor driveMotorRight =
		new CombinedMotor (driveMotorRightFront, driveMotorRightRear);
	
	public static final PIDController drivePIDLeft =
		new PIDController (DRIVE_KP, DRIVE_KI, DRIVE_KD, driveEncoderLeft, driveMotorLeft);
	public static final PIDController drivePIDRight = 
		new PIDController (DRIVE_KP, DRIVE_KI, DRIVE_KD, driveEncoderRight, driveMotorRight);
	
	/****************************************
	 * RELAYS                               *
	 ****************************************/
	public static final Relay pneumaticPump = new Relay (1, Relay.Direction.kForward);
	
	/****************************************
	 * SOLENOIDS                            *
	 ****************************************/
	public static final DoubleSolenoid driveGearboxLeft = new DoubleSolenoid (1, 2);
	public static final DoubleSolenoid driveGearboxRight = new DoubleSolenoid (3, 4);
	
	// private constructor to prevent instantiation
	private IO () {}
}