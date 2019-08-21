import javax.swing.{ImageIcon, JButton, JFrame, SwingUtilities, WindowConstants}

object JButtonTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      val frame = new JFrame
      val button = new JButton("Accept")
      frame.add(button)
      /*
       * By calling setIcon method you are setting com on JButton by
       * passing ImageIcon instance
       */
      button.setIcon(new ImageIcon(getClass.getResource("com/icon/Accept.png")))
      frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
      frame.pack()
      frame.setVisible(true)
    })
  }
}
