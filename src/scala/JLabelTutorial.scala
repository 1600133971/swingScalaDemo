import javax.swing._

object JLabelTutorial {
  def main(args: Array[String]): Unit = {
    val frame = new JFrame("JLabel demo")
    val label = new JLabel
    label.setIcon(new ImageIcon("C:/Documents and Settings/All Users/Documents/My Pictures/Sample Pictures/Water lilies.jpg"))
    frame.add(label)
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
  }
}