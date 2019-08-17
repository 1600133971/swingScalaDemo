import javax.swing.{JFrame, JScrollPane, JTextArea, SwingUtilities, WindowConstants}

object JTextAreaTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JTextAreaTutorial
      }
    })
  }
}

class JTextAreaTutorial {
  val frame = new JFrame("JTextArea demo")
  val textarea = new JTextArea("Hello", 10, 30)
  val scrollPane = new JScrollPane(textarea)
  //setEditable();
  //setEnabled();
  //setText(); getText();
  textarea.append(" from JTextArea\n")
  textarea.append(" frge\n")
  frame.add(scrollPane)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
