import javax.swing._
import java.awt._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

object CardLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new CardLayoutTutorial
    })
  }
}

class CardLayoutTutorial() {
  val frame = new JFrame("CardLayout demo")
  val panelCont = new JPanel
  val panelFirst = new JPanel
  val panelSecond = new JPanel
  val buttonOne = new JButton("Switch to second panel/workspace")
  val buttonSecond = new JButton("Switch to first panel/workspace")
  val cl = new CardLayout

  panelCont.setLayout(cl)
  panelFirst.add(buttonOne)
  panelSecond.add(buttonSecond)
  panelFirst.setBackground(Color.BLUE)
  panelSecond.setBackground(Color.GREEN)
  panelCont.add(panelFirst, "1")
  panelCont.add(panelSecond, "2")
  cl.show(panelCont, "1")
  buttonOne.addActionListener(new ActionListener() {
    override def actionPerformed(arg0: ActionEvent): Unit = {
      cl.show(panelCont, "2")
    }
  })
  buttonSecond.addActionListener(new ActionListener() {
    override def actionPerformed(arg0: ActionEvent): Unit = {
      cl.show(panelCont, "1")
    }
  })
  frame.add(panelCont)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
