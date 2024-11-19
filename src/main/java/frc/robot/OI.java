package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.event.EventLoop;

public final class OI {
  private static EventLoop eventLoop = new EventLoop();
  private static XboxController primaryController = new XboxController(Constants.OI.PRIMARY_CONTROLLER_PORT);

  public static XboxController getPrimaryController() {
    return primaryController;
  }
}
