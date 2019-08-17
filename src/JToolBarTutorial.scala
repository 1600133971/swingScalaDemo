import javax.swing._
import java.awt._

object JToolBarTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JToolBarTutorial
      }
    })
  }
}

class JToolBarTutorial {
  val frame = new JFrame
  val textField = new JTextField(15)
  val btnAdd = new JButton("Add")
  val btnDelete = new JButton("Delete")
  val toolBar = new JToolBar
  toolBar.add(textField)
  toolBar.add(btnAdd)
  toolBar.addSeparator()
  toolBar.add(btnDelete)
  toolBar.setFloatable(false)
  frame.add(toolBar, BorderLayout.NORTH)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
