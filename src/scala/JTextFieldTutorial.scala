import javax.swing.{JFrame, JTextField, SwingUtilities, WindowConstants}

object JTextFieldTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JTextFieldTutorial
      }
    })
  }
}

class JTextFieldTutorial {
  val frame = new JFrame("JTextField demo")
  val textfield = new JTextField("Hello from JTextField", 10)
  frame.add(textfield)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
