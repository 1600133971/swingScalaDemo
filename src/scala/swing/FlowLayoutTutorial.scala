import javax.swing._
import java.awt._

object FlowLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new FlowLayoutTutorial
    })
  }
}

class FlowLayoutTutorial {
  val frame = new JFrame("FlowLayout demo")
  val panel = new JPanel
  val btn1 = new JButton("First")
  val btn2 = new JButton("Second")
  val btn3 = new JButton("Third")

  panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3))
  panel.add(btn1)
  panel.add(btn2)
  panel.add(btn3)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}