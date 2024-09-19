// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.RobotConstants;
import frc.robot.subsystems.driveSubsystem;
public class move1m extends Command {
  /** Creates a new move1m. */
  private driveSubsystem m_drive = new driveSubsystem();
  private Timer timer = new Timer();
  //private PIDController pid = new PIDController(0.7, 0, 0);
  public move1m(driveSubsystem m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    //m_drive.setZero();
    //m_drive.drive.arcadeDrive(0.5, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   //double output = pid.calculate(1/RobotConstants.wheelcircumfrenece - m_drive.getPosistion());
   m_drive.drive.arcadeDrive(0.7, 0.65);
   if(timer.get()>=0.7){
    m_drive.stop();
  } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
