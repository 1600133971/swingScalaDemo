import javax.swing._
import java.awt.event.ActionEvent
import java.awt.event.ItemEvent

object JComboBoxTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new JComboBoxTutorial
    })
  }
}

class JComboBoxTutorial {
  val frame = new JFrame
  val panel = new JPanel
  val comboBox = new JComboBox[String]
  val model = new DefaultComboBoxModel[String]
  val txtAdd = new JTextField(15)
  val btnAdd = new JButton("Add")
  val btnRemove = new JButton("Remove")
  var selectedValue: String = _

  comboBox.setModel(model)
  comboBox.addItemListener((e: ItemEvent) => {
    if (e.getStateChange == ItemEvent.SELECTED) selectedValue = model.getSelectedItem.toString
  })
  btnRemove.addActionListener((_: ActionEvent) => {
    model.removeElement(selectedValue)
  })
  btnAdd.addActionListener((_: ActionEvent) => {
    model.addElement(txtAdd.getText)
  })
  panel.add(txtAdd)
  panel.add(btnAdd)
  panel.add(comboBox)
  panel.add(btnRemove)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
