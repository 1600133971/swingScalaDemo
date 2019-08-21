import javax.swing._


object JScrollPaneTutorial {
  def main(args: Array[String]): Unit = {
    val sp = new JScrollPaneTutorial
    sp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    //sp.setSize(1024,800);
    sp.pack
    sp.setVisible(true)
  }
}

class JScrollPaneTutorial extends JFrame {
  label.setIcon(new ImageIcon("C:/Documents and Settings/All Users/Documents/My Pictures/Sample Pictures/Image.jpg"))
  scrollPane.setViewportView(label)
  add(scrollPane)
  val label = new JLabel
  val scrollPane = new JScrollPane
}
