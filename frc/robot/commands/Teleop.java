/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot; 


/** Teleop is a command file. Teleop means 'remotely operated', for this file manages taking input 
from the joystick remotely and passing it on to the rest of the program */

public class Teleop extends Command {
  public Teleop() { // Teleop is a constructor so it can be called elsewhere, for this is a command
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive_train); // Because this command is being passed in DriveTrain.java, requires drive_train, the Robot.java instance of it
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drive_train.drive(0.2, 0.2); //move forewad at startup lol dont unmcomment
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { // runs when the function is executed
    Robot.drive_train.drive(Robot.m_oi.get_x(), Robot.m_oi.get_y()); // calls the drive() function from the drive_train instance of DriveTrain
    // m_oi is the Robot.java instance of OI.java, get_x and y is a method in OI.java 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
