// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Brazo extends SubsystemBase {
  CANSparkMax brazo;
  RelativeEncoder BrazoEncoder;
  /** Creates a new Brazo. */
  public Brazo() {
    brazo = new CANSparkMax(Constants.IDMS, MotorType.kBrushless);
    
    BrazoEncoder = brazo.getEncoder();
    BrazoEncoder.setPosition(0); 
  }


  public void MoveEncoder(double speed){
   
    brazo.set(speed);
  }
  
   
  public double Positionencoder(){
    return BrazoEncoder.getPosition();
  } 
  
  public void stop(){
    brazo.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
