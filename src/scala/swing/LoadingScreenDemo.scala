import javax.swing._
import java.awt._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

@SerialVersionUID(1L)
object LoadingScreenDemo {
  def main(args: Array[String]): Unit = {
    try UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel")
    catch {
      case e: ClassNotFoundException =>
        e.printStackTrace()
      case e: InstantiationException =>
        e.printStackTrace()
      case e: IllegalAccessException =>
        e.printStackTrace()
      case e: UnsupportedLookAndFeelException =>
        e.printStackTrace()
    }
    SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        val w = new LoadingScreenDemo
        w.setSize(640, 480)
        w.setLocationRelativeTo(null)
        w.setVisible(true)
      }
    })
  }
}

@SerialVersionUID(1L)
class LoadingScreenDemo extends JWindow {
  val panel = new JPanel
  val progressBar = new JProgressBar
  panel.setBackground(Color.YELLOW)
  panel.setLayout(new BorderLayout)
  panel.add(progressBar, BorderLayout.SOUTH)
  panel.setFocusable(true)
  progressBar.setStringPainted(true)
  add(panel)
  val timer = new Timer(100, new ActionListener() {
    var i = 0
    override

    def actionPerformed(evt: ActionEvent): Unit = {
      progressBar.setValue(i)
      i += 1
      panel.repaint()
      if (i == 100) {
        evt.getSource.asInstanceOf[Timer].stop()
        dispose()
      }
    }
  })
  timer.start()
}
