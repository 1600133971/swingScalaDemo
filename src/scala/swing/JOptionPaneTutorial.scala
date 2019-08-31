import javax.swing._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener


object JOptionPaneTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JOptionPaneTutorial
      }
    })
  }
}

class JOptionPaneTutorial {
  button.addActionListener(new ActionListener() {
    override def actionPerformed(arg0: ActionEvent): Unit = { // JOptionPane.showMessageDialog(null, new
      // JScrollPane(textarea),
      // "Message dialog", JOptionPane.PLAIN_MESSAGE);
      val title = JOptionPane.showInputDialog(null, "Enter title for JFrame:")
      frame.setTitle(title)
      // int result = JOptionPane.showConfirmDialog(null,
      // "Are you sure you want to close a JFrame",
      // "Select an option", JOptionPane.OK_CANCEL_OPTION);
      //
      // if (result == JOptionPane.OK_OPTION) {
      // frame.dispose();
      // }
    }
  })
  panel.add(button)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  // frame.setBounds(100, 100, 790, 400);
  frame.pack()
  frame.setResizable(false)
  frame.setVisible(true)
  val frame = new JFrame("JOptionPane demo")
  val panel = new JPanel
  val button = new JButton("Call dialog")
  val textarea = new JTextArea(10, 10)
}
