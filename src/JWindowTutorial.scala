import javax.swing._
import java.awt._
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

object JWindowTutorial {
  def main(args: Array[String]): Unit = {
    val w = new JWindowTutorial
    w.setSize(640, 480)
    w.setVisible(true)
  }
}

class JWindowTutorial extends JWindow {
  val panel = new JPanel
  panel.setBackground(Color.BLUE)
  add(panel)
  addMouseListener(new MouseAdapter() {
    override def mouseClicked(e: MouseEvent): Unit = {
      if (e.getClickCount == 2) dispose()
    }
  })
}
