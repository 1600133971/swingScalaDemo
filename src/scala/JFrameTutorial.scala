import javax.swing.{JFrame, WindowConstants}

object JFrameTutorial {
  def main(args: Array[String]): Unit = {
    val frame = new JFrame("JFrame demo")
    val panel = new JPanelTutorial
    frame.add(panel)
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    frame.setSize(320, 240)
    frame.setVisible(true)
  }
}
