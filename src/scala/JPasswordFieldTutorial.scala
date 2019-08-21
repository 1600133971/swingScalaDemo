import javax.swing._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util

object JPasswordFieldTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JPasswordFieldTutorial
      }
    })
  }
}

class JPasswordFieldTutorial {
  button.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      val input = passwordField.getPassword
      if (checkIfCorrect(input)) JOptionPane.showMessageDialog(null, "Password is correct!")
      else JOptionPane.showMessageDialog(null, "Password is incorrect!")
    }
  })
  passwordField.setEchoChar('*')
  panel.add(passwordField)
  panel.add(button)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
  val frame = new JFrame
  val panel = new JPanel
  val passwordField = new JPasswordField(20)
  val button = new JButton("Perform check")

  private def checkIfCorrect(input: Array[Char]) = {
    var isCorrect = false
    val correctPass = Array('1', '2', '3')
    if (input.length != correctPass.length) isCorrect = false
    else isCorrect = util.Arrays.equals(input, correctPass)
    util.Arrays.fill(correctPass, '0')
    isCorrect
  }
}
