import java.awt._
import javax.swing._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener


object JRadioButtonTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JRadioButtonTutorial
      }
    })
  }
}

class JRadioButtonTutorial() {
  rdbGreen.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      val source = e.getSource.asInstanceOf[JRadioButton]
      if (source.isSelected) panel.setBackground(Color.GREEN)
      if (!source.isSelected) panel.setBackground(Color.WHITE)
      panel.repaint()
    }
  })
  rdbRed.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      val source = e.getSource.asInstanceOf[JRadioButton]
      if (source.isSelected) panel.setBackground(Color.RED)
      if (!source.isSelected) panel.setBackground(Color.WHITE)
      panel.repaint()
    }
  })
  buttonGroup.add(rdbGreen)
  buttonGroup.add(rdbRed)
  panel.add(rdbGreen)
  panel.add(rdbRed)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
  val frame = new JFrame
  val panel = new JPanel
  val rdbGreen = new JRadioButton("Green")
  val rdbRed = new JRadioButton("Red")
  val buttonGroup = new ButtonGroup
}
