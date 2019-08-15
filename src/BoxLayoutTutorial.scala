import javax.swing._
import java.awt._

object BoxLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new BoxLayoutTutorial
    })
  }
}

class BoxLayoutTutorial {
  val frame = new JFrame("BoxLayout tutorial")
  val panel = new JPanel
  val buttonFirst = new JButton("First")
  val buttonSecond = new JButton("Second")
  panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS))
  panel.add(buttonFirst)
  panel.add(Box.createHorizontalGlue)
  panel.add(Box.createRigidArea(new Dimension(5, 0)))
  panel.add(buttonSecond)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
