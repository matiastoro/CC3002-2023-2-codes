package c08.suchai
import scala.collection.mutable.ListBuffer
class Photo

trait Satelite{
  def getAngle(): Double
  def setAngle(a: Double): Unit
  def takePicture(): Unit
  def getPhotosSize(): Int
  def doExecute(c: Command): Unit
}

class Suchai extends Satelite{
  private var angle: Double = 0
  private var photos: ListBuffer[Photo] = ListBuffer()

  def getAngle() = angle
  def setAngle(a: Double) = angle = a

  def takePicture() = photos += new Photo()
  def getPhotosSize() = photos.size

  def doExecute(c: Command) = {
    c.execute(this)
  }

}

class Suchoi extends Satelite{
  private var angle: Double = 0
  private var photos: ListBuffer[Photo] = ListBuffer()

  def getAngle() = angle

  def setAngle(a: Double) = angle = a

  def takePicture() = photos += new Photo()

  def getPhotosSize() = photos.size

  def doExecute(c: Command) = {
    c.execute(this)
  }
}
