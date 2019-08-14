import javax.swing.{JButton, JFrame, JPanel, JTextField, SwingUtilities, WindowConstants}
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener


object TextFieldEvent {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new TextFieldEvent
    })
  }
}

class TextFieldEvent() {
  val frame = new JFrame("JTextField demo")
  val panel = new JPanel
  val textfield = new JTextField("", 20)
  val button = new JButton("Ok")
  textfield.getDocument.addDocumentListener(new DocumentListener() {
    override def changedUpdate(arg0: DocumentEvent): Unit = {
      warn()
    }

    override

    def insertUpdate(arg0: DocumentEvent): Unit = {
      warn()
    }

    override

    def removeUpdate(arg0: DocumentEvent): Unit = {
      warn()
    }

    def warn(): Unit = {
      button.setText(textfield.getText)
    }
  })
  panel.add(textfield)
  panel.add(button)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
