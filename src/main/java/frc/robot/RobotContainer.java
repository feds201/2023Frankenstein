package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.constants.PowerConstants;
import frc.robot.constants.SwerveConstants;
import frc.robot.constants.OIConstants;
import frc.robot.commands.BoxGrabber.ExtendBoxGrabber;
import frc.robot.commands.BoxGrabber.RetractBoxGrabber;
import frc.robot.commands.Intake.RunIntake;
import frc.robot.commands.auton.BossDriveChallenge;
import frc.robot.commands.claw.ExtendClawPiston;
import frc.robot.commands.claw.RetractClawPiston;
import frc.robot.commands.claw.UnwindClawPulley;
import frc.robot.commands.claw.WindClawPulley;
import frc.robot.commands.exampleCommands.LockWheels;
import frc.robot.commands.pigeon.ReportingCommand;
import frc.robot.commands.shooter.ReverseShootBalls;
import frc.robot.commands.shooter.ShootBalls;
import frc.robot.commands.swerve.TeleopSwerve;
import frc.robot.subsystems.BoxGrabber.BoxGrabber;
import frc.robot.subsystems.Claw.Claw;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Swerve.SwerveSubsystem;
import frc.robot.subsystems.pigeon.Pigeon2Subsystem;
import frc.robot.subsystems.pigeon.ReportingSubsystem;

public class RobotContainer {
    private final SwerveSubsystem s_swerve;

    private final Intake i_intake;
    private final BoxGrabber b_boxGrabber;
    private final Shooter s_shooter;
    private final Claw s_claw;

    public static final Pigeon2Subsystem s_pigeon2 = new Pigeon2Subsystem(SwerveConstants.pigeonID);
    private final ReportingSubsystem s_reportingSubsystem;
    private final SlewRateLimiter slewRateLimiterX = new SlewRateLimiter(15);
    private final SlewRateLimiter slewRateLimiterY = new SlewRateLimiter(15);
    public final static PowerDistribution m_PowerDistribution = new PowerDistribution(PowerConstants.kPCMChannel,
            ModuleType.kRev);

    CommandXboxController m_driveController = new CommandXboxController(OIConstants.kDriveControllerPort);
    CommandXboxController m_operatorController = new CommandXboxController(OIConstants.kOperatorControllerPort);

    SendableChooser<Command> m_autonChooser = new SendableChooser<>();

    public RobotContainer() {
        s_swerve = new SwerveSubsystem();

        i_intake = new Intake();
        b_boxGrabber = new BoxGrabber();
        s_shooter = new Shooter();
        s_claw = new Claw();

        s_reportingSubsystem = new ReportingSubsystem();
        m_autonChooser.addOption("Boss Drive Challenge", new BossDriveChallenge(s_swerve));
        Shuffleboard.getTab("Autons").add(m_autonChooser);

        s_swerve.setDefaultCommand(
                new TeleopSwerve(
                        s_swerve,
                        () -> -slewRateLimiterY.calculate(m_driveController.getLeftY()),
                        () -> -slewRateLimiterX.calculate(m_driveController.getLeftX()),
                        () -> -m_driveController.getRightX(),
                        () -> SwerveConstants.fieldCentric)); // always field for now!

        s_reportingSubsystem.setDefaultCommand(new ReportingCommand(s_reportingSubsystem, s_pigeon2));
        configureDriverButtonBindings();
        configureOperatorButtonBindings();
        SwerveSubsystem.refreshRollOffset();
    }

    private void configureDriverButtonBindings() {
        // Reset Gyro / LockWheels
        m_driveController.y().onTrue(
                new InstantCommand(() -> s_swerve.zeroGyro()));

        m_driveController.b().onTrue(
                new InstantCommand(() -> s_swerve.zeroGyro180()));

        m_driveController.start().onTrue(new LockWheels(s_swerve));

        // INTAKE
        m_driveController.rightTrigger().whileTrue(new RunIntake(i_intake));
        
        // BOX GRABBER
        m_driveController.leftTrigger().onTrue(new ExtendBoxGrabber(b_boxGrabber));
        m_driveController.leftBumper().onTrue(new RetractBoxGrabber(b_boxGrabber));
    }

    private void configureOperatorButtonBindings() {
        // SHOOTER
        m_operatorController.leftTrigger().whileTrue(new ShootBalls(s_shooter));
        m_operatorController.leftBumper().whileTrue(new ReverseShootBalls(s_shooter));

        // CLAW
        m_operatorController.axisGreaterThan(0, 0.3).whileTrue(new WindClawPulley(s_claw));
        m_operatorController.axisLessThan(0, -0.3).whileTrue(new UnwindClawPulley(s_claw));

        m_operatorController.a().onTrue(new ExtendClawPiston(s_claw));
        m_operatorController.b().onTrue(new RetractClawPiston(s_claw));
    }

    public Command getAutonomousCommand() {
        return m_autonChooser.getSelected();
    }
}
