import javax.swing._


object JSplitPaneTutorial {
  def main(args: Array[String]): Unit = {
    val sp = new JSplitPaneTutorial
    sp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    sp.setSize(1024, 600)
    sp.setVisible(true)
  }
}

class JSplitPaneTutorial extends JFrame {
  leftLabel.setIcon(new ImageIcon("C:/Documents and Settings/All Users/Documents/My Pictures/Sample Pictures/Water lilies.jpg"))
  rightLabel.setIcon(new ImageIcon("C:/Documents and Settings/All Users/Documents/My Pictures/Sample Pictures/Winter.jpg"))
  add(splitPane)
  val leftLabel = new JLabel
  val rightLabel = new JLabel
  val splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftLabel), new JScrollPane(rightLabel))
}
