package c08.suchai

trait Command {
  def execute(s: Satelite): Unit
}
class RotateCommand(val angle: Double) extends Command {
  def execute(s: Satelite) = {
    s.setAngle(s.getAngle() + angle)
  }
}
class TakePictureCommand() extends Command {
  def execute(s: Satelite) = {
    s.takePicture()
  }
}

class ResetAngleCommand() extends Command {
  def execute(s: Satelite): Unit = s.setAngle(0)
}

class CompositeCommand(commands: List[Command]) extends Command {
  def execute(s: Satelite): Unit = {
    for (c <- commands) {
      c.execute(s)
    }
  }
}
class RotateAndTakePhotoCommand(angle: Double)
    extends CompositeCommand(
      List(new RotateCommand(angle), new TakePictureCommand())
    ) {}

class RotateAndTake3PhotoCommand(angle: Double)
    extends CompositeCommand(
      List(
        new RotateCommand(angle),
        new TakePictureCommand(),
        new TakePictureCommand(),
        new TakePictureCommand()
      )
    ) {}

class TakeNPhotosCommand(n: Int) extends Command {
  def execute(s: Satelite) = {
    (1 to n).foreach(_ => s.takePicture())
  }
}
