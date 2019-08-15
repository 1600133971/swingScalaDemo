import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets

import javax.swing.{JButton, JFrame, JPanel, SwingUtilities, WindowConstants}

object GridBagLayoutTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new GridBagLayoutTutorial
    })
  }
}

class GridBagLayoutTutorial {
  val frame = new JFrame
  val panel = new JPanel
  val btn1 = new JButton("One")
  val btn2 = new JButton("Two")
  val btn3 = new JButton("Three")

  panel.setLayout(new GridBagLayout)
  val gbc = new GridBagConstraints
  gbc.fill = GridBagConstraints.HORIZONTAL
  gbc.insets = new Insets(5, 5, 5, 5)
  gbc.gridx = 0
  gbc.gridy = 0
  panel.add(btn1, gbc)
  gbc.gridx = 1
  gbc.gridy = 0
  panel.add(btn2, gbc)
  gbc.gridwidth = 2
  gbc.gridx = 0
  gbc.gridy = 1
  panel.add(btn3, gbc)
  frame.add(panel)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}
