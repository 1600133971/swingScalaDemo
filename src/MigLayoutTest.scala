import javax.swing._
import net.miginfocom.swing.MigLayout

object MigLayoutTest {
  private def createPanel = {
    val panel = new JPanel(new MigLayout)
    panel.add(new JLabel("First Name"))
    panel.add(new JTextField(10))
    panel.add(new JLabel("Surname"), "gap unrelated") // Unrelated size is resolved per platform
    panel.add(new JTextField(10), "wrap") // Wraps to the next row
    panel.add(new JLabel("Address"))
    panel.add(new JTextField, "span, grow") // Spans cells in row and grows to fit that
    panel
  }

  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      try UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
      catch {
        case ex: Exception =>
          ex.printStackTrace()
      }
      val frame = new JFrame("Example 01")
      frame.getContentPane.add(createPanel)
      frame.pack()
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
      frame.setVisible(true)
    })
  }
}
