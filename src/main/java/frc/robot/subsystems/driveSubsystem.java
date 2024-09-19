// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.turnleft;
import frc.robot.commands.turnright;

public class driveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
private WPI_TalonSRX right1 = new WPI_TalonSRX(12);
private WPI_TalonSRX right2 = new WPI_TalonSRX(52);
private WPI_TalonSRX left1 = new WPI_TalonSRX(40);
private WPI_TalonSRX leht2 = new WPI_TalonSRX(33); 
 
private CANcoder canCoder = new CANcoder(14);

  public DifferentialDrive drive = new DifferentialDrive(left1, right1);
  
  

  public static enum states{
    telop,
    move1m,
    turnleft,
    turnright
  }
  public states state;

  private XboxController js1 = new XboxController(0);

  public void Drivesubsystem() {
    right1.setInverted(true);
    right2.follow(right1);
    left1.setInverted(false);
    leht2.follow(left1);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public double getPosistion(){
    return canCoder.getPosition().getValueAsDouble();
  }

  public void stop(){
    right1.set(0);
    left1.set(0);
  }

  public void setZero(){
    canCoder.setPosition(0);
  }

  public void setState(states state){
    // this.state = state;
  }

  public void updateStates(){}
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("speed",right1.getSelectedSensorVelocity());
    SmartDashboard.putNumber("posistion", getPosistion());
    updateStates();
    drive.setSafetyEnabled(false);
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
