// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.driveSubsystem.states;

public class Teleopstates extends Command {
  private final driveSubsystem m_drive;
  private final XboxController js1 = new XboxController(0);
  /** Creates a new Teleopstates. */
  public Teleopstates(driveSubsystem m_drive) {
    this.m_drive = new driveSubsystem();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
