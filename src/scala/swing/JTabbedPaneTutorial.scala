import javax.swing._

object JTabbedPaneTutorial {
  def main(args: Array[String]): Unit = {
    try UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
    catch {
      case e@(_: ClassNotFoundException | _: InstantiationException | _: IllegalAccessException | _: UnsupportedLookAndFeelException) =>
        e.printStackTrace()
    }
    val tp = new JTabbedPaneTutorial
    tp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    tp.setSize(600, 400)
    tp.setVisible(true)
  }
}

class JTabbedPaneTutorial extends JFrame {
  val firstPanel = new JPanel
  val secondPanel = new JPanel
  val firstLabel = new JLabel("First!")
  val secondLabel = new JLabel("Second!")
  val tabbedPane = new JTabbedPane
  firstPanel.add(firstLabel)
  secondPanel.add(secondLabel)
  tabbedPane.add("First panel", firstPanel)
  tabbedPane.add("Second panel", secondPanel)
  add(tabbedPane)
}
