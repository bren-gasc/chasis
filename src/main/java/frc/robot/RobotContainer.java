// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveJoysticks;
import frc.robot.commands.MoveEncoder;
import frc.robot.commands.llantas;
import frc.robot.subsystems.Brazo;
import frc.robot.subsystems.DriveTrainPrueba;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {


  private final Intake intake;
  private final llantas Llantas;
  public static XboxController ControlGarra;
  /*
  private final llantas ComerCubos;
  private final llantas ExpulsarCubos;
  private final llantas ComerConos;
  private final llantas ExpulsarConos;
  public static XboxController ControlGarra;
  */


  
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public final DriveTrainPrueba drivetrainPrueba;
  public final DriveJoysticks driveJoysticks;

  public static XboxController Joy1;

//brazo cosas
public final Brazo brazo;
public final MoveEncoder moveEncoder;


  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    drivetrainPrueba = new DriveTrainPrueba();
    driveJoysticks = new DriveJoysticks(drivetrainPrueba);
    driveJoysticks.addRequirements(drivetrainPrueba);
    drivetrainPrueba.setDefaultCommand(driveJoysticks);

    brazo = new Brazo();


    moveEncoder = new MoveEncoder();
    moveEncoder.addRequirements(brazo);

    Joy1 = new XboxController(Constants.XBOXID);

    intake = new Intake();
    Llantas = new llantas(intake, 0);
    Llantas.addRequirements(intake);

    ControlGarra = new XboxController(Constants.ControlGarraID);

    /*
    ComerCubos = new llantas(intake, 0.4);
    ComerCubos.addRequirements(intake);

    ExpulsarCubos = new llantas(intake, -0.2);
    ExpulsarCubos.addRequirements(intake);

    ComerConos = new llantas(intake, 0.6);
    ComerConos.addRequirements(intake);

    ExpulsarConos = new llantas(intake, -0.3);
    ExpulsarConos.addRequirements(intake);
    */

    UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(18, 14);



    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    //Extensión Garra
    JoystickButton sButton = new JoystickButton(ControlGarra, XboxController.Button.kRightBumper.value);
    sButton.whileTrue(new MoveEncoder(brazo));

    
    
    JoystickButton Y = new JoystickButton(ControlGarra, XboxController.Button.kY.value);
    Y.whileTrue(new llantas(intake, 0.7));
    
    JoystickButton B = new JoystickButton(ControlGarra, XboxController.Button.kB.value);
    B.whileTrue(new llantas(intake, -0.6));

    JoystickButton X = new JoystickButton(ControlGarra, XboxController.Button.kX.value);
    X.whileTrue(new llantas(intake, 0.7));

    JoystickButton A = new JoystickButton(ControlGarra, XboxController.Button.kA.value);
    A.whileTrue(new llantas(intake, -0.6));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
    // An example command will be run in autonomous
  
}
