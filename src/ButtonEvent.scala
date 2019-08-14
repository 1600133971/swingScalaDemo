import java.awt.Color
import java.awt.event.ActionEvent

import javax.swing.{JButton, JFrame, SwingUtilities, WindowConstants}

object ButtonEvent {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      new ButtonEvent
    })
  }
}

class ButtonEvent() {
  val frame = new JFrame("Button event")
  val button = new JButton("Click me")
  button.addActionListener((_: ActionEvent) => {
    button.setBackground(Color.RED)
  })
  frame.add(button)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}

