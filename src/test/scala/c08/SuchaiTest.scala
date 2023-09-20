package c08
import c08.suchai._

class SuchaiTest extends munit.FunSuite {
  val suchai: Suchai = new Suchai()

  test("send a command") {
    suchai.doExecute(new RotateCommand(10.5))
    suchai.doExecute(new RotateCommand(2))
    assertEquals(suchai.getAngle(), 12.5)
  }

  test("take a picture") {
    suchai.doExecute(new TakePictureCommand())
    suchai.doExecute(new TakePictureCommand())
    suchai.doExecute(new TakePictureCommand())
    assertEquals(suchai.getPhotosSize(), 3)
  }

  test("reset angle") {
    suchai.doExecute(new RotateCommand(10.5))
    suchai.doExecute(new RotateCommand(2))
    suchai.doExecute(new ResetAngleCommand())
    assertEquals(suchai.getAngle(), 0.0)
  }

  test("Rotate and take a photo") {
    suchai.doExecute(new TakePictureCommand())
    suchai.doExecute(new RotateAndTakePhotoCommand(10.5))
    assertEquals(suchai.getAngle(), 10.5)
    assertEquals(suchai.getPhotosSize(), 2)
  }

  test("Composite command") {
    suchai.doExecute(new TakePictureCommand())
    suchai.doExecute(new RotateAndTake3PhotoCommand(10.5))
    assertEquals(suchai.getAngle(), 10.5)
    assertEquals(suchai.getPhotosSize(), 4)
  }

  test("Take n photos command") {
    suchai.doExecute(new TakeNPhotosCommand(100))
    suchai.doExecute(new TakeNPhotosCommand(9000))
    assertEquals(suchai.getPhotosSize(), 9100)
  }
}
