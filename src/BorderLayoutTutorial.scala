import javax.swing._
import java.awt._

object BorderLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new BorderLayoutTutorial
    })
  }
}

class BorderLayoutTutorial() {
  val frame = new JFrame("BorderLayout demo")
  val btn1 = new JButton("NORTH")
  val btn2 = new JButton("SOUTH")
  val btn3 = new JButton("CENTER")
  val btn4 = new JButton("WEST")
  val btn5 = new JButton("EAST")
  frame.setLayout(new BorderLayout)
  frame.add(btn1, BorderLayout.NORTH)
  frame.add(btn2, BorderLayout.SOUTH)
  frame.add(btn3, BorderLayout.CENTER)
  frame.add(btn4, BorderLayout.WEST)
  frame.add(btn5, BorderLayout.EAST)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}