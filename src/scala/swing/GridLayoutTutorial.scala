import java.awt.GridLayout
import javax.swing.{JButton, JFrame, JPanel, SwingUtilities, WindowConstants}

object GridLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new GridLayoutTutorial
    })
  }
}

class GridLayoutTutorial {
  val frame = new JFrame("GridLayout demo")
  val panel = new JPanel
  val btn1 = new JButton("First")
  val btn2 = new JButton("Second")
  val btn3 = new JButton("Third")
  val btn4 = new JButton("Fourth")

  panel.setLayout(new GridLayout(2, 2, 3, 3))
  panel.add(btn1)
  panel.add(btn2)
  panel.add(btn3)
  panel.add(btn4)
  //btn1.setPreferredSize(new Dimension(100,100));
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  //frame.setSize(200,200);
  frame.setVisible(true)
}
