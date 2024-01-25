// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  CANSparkMax MotorA;
  CANSparkMax MotorB;
  MotorControllerGroup Garra;
  /** Creates a new Intake. */
  public Intake() {
    MotorA = new CANSparkMax(Constants.MotorAID, MotorType.kBrushless);
    MotorB = new CANSparkMax(Constants.MotorBID, MotorType.kBrushless);
    MotorB.setInverted(true);

    Garra = new MotorControllerGroup(MotorA, MotorB);
  }

  public void llantas(double Vel){
    Garra.set(Vel);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void stop(){
    Garra.set(0);
  }
}
