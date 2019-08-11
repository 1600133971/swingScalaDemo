import javax.swing.{JDesktopPane, JFrame, JInternalFrame, SwingUtilities, WindowConstants}

object JInternalFrameTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        val desktopPane = new JDesktopPane
        val intFrame = new JInternalFrame("JInternalFrame demo")
        intFrame.setMaximizable(true)
        intFrame.setIconifiable(true)
        intFrame.setResizable(true)
        intFrame.setClosable(true)
        intFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
        intFrame.setSize(320, 240)
        // intFrame.pack();
        intFrame.setVisible(true)
        desktopPane.add(intFrame)
        val frame = new JFrame
        frame.add(desktopPane)
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
        frame.setSize(640, 480)
        // frame.pack();
        frame.setVisible(true)
      }
    })
  }
}

