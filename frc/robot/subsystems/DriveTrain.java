/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Teleop;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  public DriveTrain(){
    front_left.setInverted(true);
    back_left.setInverted(true);
    front_right.setInverted(false);
    back_right.setInverted(false);  
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /* The parameter of the instance is the port to which the motor controller connects */
  WPI_TalonSRX front_left  = new WPI_TalonSRX(3); 
  WPI_TalonSRX front_right = new WPI_TalonSRX(1);
  // WPI_TalonSRX is an API instance that is the motor control object from ctr-electronics

  WPI_TalonSRX back_left   = new WPI_TalonSRX(4);
  WPI_TalonSRX back_right  = new WPI_TalonSRX(2);
  SpeedControllerGroup left = new SpeedControllerGroup(front_left, back_left);
  SpeedControllerGroup right = new SpeedControllerGroup(front_right, back_right);
  // SpeedControllerGroup is a way of grouping together microcontrollers. These groups can be told to run as a group of operations

  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  // DIfferentialDrive is a collection of motor controls used to drive. 

  public void drive(double x_axis, double y_axis) {
    diffDrive.arcadeDrive​(x_axis, y_axis);
  }
  /* drive() is a method that takes in amounts to move by and moves the controls by those inputs */
  /* arcadeDrive is a method of controlling the motors */ 


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Teleop()); // Makes a command the default command file linked to the subsystem. Teleop takes joystick input, so it is linked to the subsystem. Adds this to the scheduler
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
