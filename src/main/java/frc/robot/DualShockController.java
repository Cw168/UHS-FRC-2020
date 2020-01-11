/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * Handle input from a Dualshock controller connected to the Driver Station.
 */
public class DualShockController extends GenericHID {
  /**
   * Represents a digital button on a DualShockController.
   */
  public enum Button {
    kRect(1),
    kCross(2),
    kDisk(3),
    kTrig(4),
    kBumperLeft(5),
    kBumperRight(6),
    kTriggerLeft(7),
    kTriggerRight(8),
    kShare(9),
    kOption(10),
    kStickLeft(11),
    kStickRight(12),
    kPad(14);


    @SuppressWarnings({"MemberName", "PMD.SingularField"})
    public final int value;

    Button(int value) {
      this.value = value;
    }
  }

  /**
   * Construct an instance of a joystick. The joystick index is the USB port on the drivers
   * station.
   *
   * @param port The port on the Driver Station that the joystick is plugged into.
   */
  public DualShockController(final int port) {
    super(port);
  }

  /**
   * Get the X axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The X axis value of the controller.
   */
  @Override
  public double getX(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(0);
    } else {
      return getRawAxis(2);
    }
  }

  /**
   * Get the Y axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The Y axis value of the controller.
   */
  @Override
  public double getY(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(1);
    } else {
      return getRawAxis(5);
    }
  }

  /**
   * Get the trigger axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The trigger axis value of the controller.
   */
  public double getTriggerAxis(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(3);
    } else {
      return getRawAxis(4);
    }
  }

  /**
   * Read the value of the bumper button on the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The state of the button.
   */
  public boolean getBumper(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawButton(Button.kBumperLeft.value);
    } else {
      return getRawButton(Button.kBumperRight.value);
    }
  }

  /**
   * Whether the bumper was pressed since the last check.
   *
   * @param hand Side of controller whose value should be returned.
   * @return Whether the button was pressed since the last check.
   */
  public boolean getBumperPressed(Hand hand) {
    if (hand == Hand.kLeft) {
      return getRawButtonPressed(Button.kBumperLeft.value);
    } else {
      return getRawButtonPressed(Button.kBumperRight.value);
    }
  }

  /**
   * Whether the bumper was released since the last check.
   *
   * @param hand Side of controller whose value should be returned.
   * @return Whether the button was released since the last check.
   */
  public boolean getBumperReleased(Hand hand) {
    if (hand == Hand.kLeft) {
      return getRawButtonReleased(Button.kBumperLeft.value);
    } else {
      return getRawButtonReleased(Button.kBumperRight.value);
    }
  }

  /**
   * Read the value of the stick button on the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The state of the button.
   */
  public boolean getStickButton(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawButton(Button.kStickLeft.value);
    } else {
      return getRawButton(Button.kStickRight.value);
    }
  }

  /**
   * Whether the stick button was pressed since the last check.
   *
   * @param hand Side of controller whose value should be returned.
   * @return Whether the button was pressed since the last check.
   */
  public boolean getStickButtonPressed(Hand hand) {
    if (hand == Hand.kLeft) {
      return getRawButtonPressed(Button.kStickLeft.value);
    } else {
      return getRawButtonPressed(Button.kStickRight.value);
    }
  }

  /**
   * Whether the stick button was released since the last check.
   *
   * @param hand Side of controller whose value should be returned.
   * @return Whether the button was released since the last check.
   */
  public boolean getStickButtonReleased(Hand hand) {
    if (hand == Hand.kLeft) {
      return getRawButtonReleased(Button.kStickLeft.value);
    } else {
      return getRawButtonReleased(Button.kStickRight.value);
    }
  }

  /**
   * Read the value of the square button on the controller.
   *
   * @return The state of the square button.
   */
  public boolean getRectButton() {
    return getRawButton(Button.kRect.value);
  }

  /**
   * Whether the square button was pressed since the last check.
   *
   * @return Whether the square button was pressed since the last check.
   */
  public boolean getRectButtonPressed() {
    return getRawButtonPressed(Button.kRect.value);
  }

  /**
   * Whether the square button was released since the last check.
   *
   * @return Whether the square button was released since the last check.
   */
  public boolean getRectButtonReleased() {
    return getRawButtonReleased(Button.kRect.value);
  }

  /**
   * Read the value of the cross button on the controller.
   *
   * @return The state of the cross button.
   */
  public boolean getCrossButton() {
    return getRawButton(Button.kCross.value);
  }

  /**
   * Whether the cross button was pressed since the last check.
   *
   * @return Whether the cross button was pressed since the last check.
   */
  public boolean getCrossButtonPressed() {
    return getRawButtonPressed(Button.kCross.value);
  }

  /**
   * Whether the cross button was released since the last check.
   *
   * @return Whether the cross button was released since the last check.
   */
  public boolean getCrossButtonReleased() {
    return getRawButtonReleased(Button.kCross.value);
  }

  /**
   * Read the value of the circle button on the controller.
   *
   * @return The state of the circle button.
   */
  public boolean getDiskButton() {
    return getRawButton(Button.kDisk.value);
  }

  /**
   * Whether the circle button was pressed since the last check.
   *
   * @return Whether the circle button was pressed since the last check.
   */
  public boolean getDiskButtonPressed() {
    return getRawButtonPressed(Button.kDisk.value);
  }

  /**
   * Whether the circle button was released since the last check.
   *
   * @return Whether the circle button was released since the last check.
   */
  public boolean getDiskButtonReleased() {
    return getRawButtonReleased(Button.kDisk.value);
  }

  /**
   * Read the value of the triangle button on the controller.
   *
   * @return The state of the triangle button.
   */
  public boolean getTrigButton() {
    return getRawButton(Button.kTrig.value);
  }

  /**
   * Whether the triangle button was pressed since the last check.
   *
   * @return Whether the triangle button was pressed since the last check.
   */
  public boolean getTrigButtonPressed() {
    return getRawButtonPressed(Button.kTrig.value);
  }

  /**
   * Whether the triangle button was released since the last check.
   *
   * @return Whether the triangle button was released since the last check.
   */
  public boolean getTrigButtonReleased() {
    return getRawButtonReleased(Button.kTrig.value);
  }

  /**
   * Read the value of the share button on the controller.
   *
   * @return The state of the share button.
   */
  public boolean getShareButton() {
    return getRawButton(Button.kShare.value);
  }

  /**
   * Whether the share button was pressed since the last check.
   *
   * @return Whether the share button was pressed since the last check.
   */
  public boolean getShareButtonPressed() {
    return getRawButtonPressed(Button.kShare.value);
  }

  /**
   * Whether the share button was released since the last check.
   *
   * @return Whether the share button was released since the last check.
   */
  public boolean getShareButtonReleased() {
    return getRawButtonReleased(Button.kShare.value);
  }

  /**
   * Read the value of the option button on the controller.
   *
   * @return The state of the option button.
   */
  public boolean getOptionButton() {
    return getRawButton(Button.kOption.value);
  }

  /**
   * Whether the option button was pressed since the last check.
   *
   * @return Whether the option button was pressed since the last check.
   */
  public boolean getOptionButtonPressed() {
    return getRawButtonPressed(Button.kOption.value);
  }

  /**
   * Whether the option button was released since the last check.
   *
   * @return Whether the option button was released since the last check.
   */
  public boolean getOptionButtonReleased() {
    return getRawButtonReleased(Button.kOption.value);
  }
}
