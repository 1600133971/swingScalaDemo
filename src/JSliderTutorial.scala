import javax.swing._
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener
import java.awt._


object JSliderTutorial {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new JSliderTutorial
      }
    })
  }
}

class JSliderTutorial {
  label.setOpaque(true)
  slider.setMajorTickSpacing(10)
  slider.setMinorTickSpacing(1)
  slider.setPaintLabels(true)
  slider.setPaintTicks(true)
  slider.addChangeListener(new ChangeListener() {
    override def stateChanged(e: ChangeEvent): Unit = {
      val source = e.getSource.asInstanceOf[JSlider]
      label.setBackground(new Color(0, 0, source.getValue))
    }
  })
  frame.add(label, BorderLayout.CENTER)
  frame.add(slider, BorderLayout.SOUTH)
  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
  val frame = new JFrame
  val label = new JLabel
  val slider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0)
}
