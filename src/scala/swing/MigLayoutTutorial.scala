import net.miginfocom.swing.MigLayout
import javax.swing._

object MigLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new MigLayoutTutorial
    })
  }
}

class MigLayoutTutorial {
  val frame = new JFrame("Employees")
  val panel = new JPanel
  val lblFirstName = new JLabel("First name:")
  val lblLastName = new JLabel("Last name:")
  val txtFirstName = new JTextField(20)
  val txtLastName = new JTextField(20)
  val btnCreate = new JButton("Create")
  val btnDelete = new JButton("Delete")
  val lblDsc = new JLabel("Description:")
  val txaDsc = new JTextArea(10, 10)

  panel.setLayout(new MigLayout)
  panel.add(lblFirstName)
  panel.add(txtFirstName, "wrap, pushx, growx")
  panel.add(lblLastName)
  panel.add(txtLastName, "wrap, pushx, growx")
  panel.add(btnCreate, "skip, split2")
  panel.add(btnDelete, "wrap")
  panel.add(lblDsc, "top")
  panel.add(new JScrollPane(txaDsc), "push, grow")
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
