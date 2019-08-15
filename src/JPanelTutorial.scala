import javax.imageio.ImageIO
import javax.swing._
import java.awt._
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException

object JPanelTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      val frame = new JFrame
      frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
      frame.add(new JPanelTutorial)
      frame.setExtendedState(Frame.MAXIMIZED_BOTH)
      frame.setVisible(true)
    })
  }
}

class JPanelTutorial extends JPanel {
  var image: BufferedImage = _
  try image = ImageIO.read(new File("C:/Documents and Settings/All Users/Documents/My Pictures/Sample Pictures/Winter.jpg"))
  catch {
    case e: IOException =>
      e.printStackTrace()
  }

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponents(g)
    g.drawImage(image, 0, 0, null)
    g.setColor(Color.RED)
    g.fillRect(10, 10, 100, 50)
  }
}
