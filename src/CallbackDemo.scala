import net.miginfocom.layout.BoundSize
import net.miginfocom.layout.ComponentWrapper
import net.miginfocom.layout.LayoutCallback
import net.miginfocom.layout.UnitValue
import net.miginfocom.swing.MigLayout
import javax.swing._
import java.awt._
import java.awt.event._
import java.util

object CallbackDemo {
  def main(args: Array[String]): Unit = {
    try UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
    catch {
      case _: Exception =>
    }
    val demoFrame = new CallbackDemo
    demoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    demoFrame.setSize(970, 500)
    demoFrame.setLocationRelativeTo(null)
    demoFrame.setVisible(true)
  }
}

class CallbackDemo() extends JFrame("MiG Layout Callback Demo") with ActionListener with MouseMotionListener with MouseListener {
  val FONTS = new Array[Font](120)
  val migLayout = new MigLayout("align center bottom, insets 30")
  val pressMap = new util.IdentityHashMap[Any, Long]
  var mousePos: Point = _
  val panel: JPanel = new JPanel(migLayout) {
    override protected def paintComponent(g: Graphics): Unit = {
      g.asInstanceOf[Graphics2D].setPaint(new GradientPaint(0, getHeight / 2, Color.WHITE, 0, getHeight, new Color(240, 238, 235)))
      g.fillRect(0, 0, getWidth, getHeight)
    }
  }
  setContentPane(panel)

  // This callback methods will be called for every layout cycle and let you make correction before and after the calculations.
  migLayout.addLayoutCallback(new LayoutCallback() {
    // This is the size change part
    override def getSize(comp: ComponentWrapper): Array[BoundSize] = {
      if (comp.getComponent.isInstanceOf[JButton]) {
        val c = comp.getComponent.asInstanceOf[Component]
        val p = if (mousePos != null) SwingUtilities.convertPoint(panel, mousePos, c)
        else new Point(-1000, -1000)
        var fact = Math.sqrt(Math.pow(Math.abs(p.x - c.getWidth / 2f), 2) + Math.pow(Math.abs(p.y - c.getHeight / 2f), 2)).toFloat
        fact = Math.max(2 - (fact / 200), 1)
        return Array[BoundSize](new BoundSize(new UnitValue(70 * fact), ""), new BoundSize(new UnitValue(70 * fact), ""))
      }
      null
    }

    // This is the jumping part
    override def correctBounds(c: ComponentWrapper): Unit = {
      val pressedNanos = pressMap.get(c.getComponent)
      if (pressedNanos != null) {
        val duration = System.nanoTime - pressedNanos
        val maxHeight = 100.0 - (duration / 100000000.0)
        val deltaY = Math.abs(Math.sin(duration / 300000000.0) * maxHeight).round.toInt
        c.setBounds(c.getX, c.getY - deltaY, c.getWidth, c.getHeight)
        if (maxHeight < 0.5) {
          pressMap.remove(c.getComponent)
          if (pressMap.size == 0) repaintTimer.stop()
        }
      }
    }
  })
  var j = 0
  while (j < 10) {
    panel.add(createButton(j), "aligny 0.8al")
    j += 1
  }
  val label = new JLabel("Press one of those Swing JButtons!")
  label.setFont(new Font("verdana", Font.PLAIN, 24))
  label.setForeground(new Color(150, 150, 150))
  panel.add(label, "pos 0.5al 0.2al")
  panel.addMouseMotionListener(this)
  panel.addMouseListener(this)
  final val repaintTimer = new Timer(20, (_: ActionEvent) => {
    getContentPane.asInstanceOf[JPanel].revalidate()
  })

  def createButton(i: Int): JButton = {
    val button = new JButton(String.valueOf("MIG LAYOUT".charAt(i))) {
      override def getFont: Font = {
        if (FONTS(0) == null) {
          var i = 0
          while (i < FONTS.length) {
            FONTS(i) = new Font("tahoma", Font.PLAIN, i)
            i += 1
          }
        }
        FONTS(getWidth >> 1)
      }
    }
    button.setForeground(new Color(100, 100, 100))
    button.setFocusPainted(false)
    button.addMouseMotionListener(this)
    button.addActionListener(this)
    button.setMargin(new Insets(0, 0, 0, 0))
    button
  }

  override def mouseDragged(e: MouseEvent): Unit = {  }
  override def mouseMoved(e: MouseEvent): Unit = {
    if (e.getSource.isInstanceOf[JButton])
      mousePos = SwingUtilities.convertPoint(e.getSource.asInstanceOf[Component], e.getPoint, getContentPane)
    else
      mousePos = e.getPoint
    getContentPane.asInstanceOf[JPanel].revalidate()
  }
  override def mousePressed(e: MouseEvent): Unit = {  }
  override def mouseReleased(e: MouseEvent): Unit = {  }
  override def mouseClicked(e: MouseEvent): Unit = {  }
  override def mouseEntered(e: MouseEvent): Unit = {  }
  override def mouseExited(e: MouseEvent): Unit = {
    mousePos = null
    getContentPane.asInstanceOf[JPanel].revalidate()
  }
  override def actionPerformed(e: ActionEvent): Unit = {
    pressMap.put(e.getSource, System.nanoTime)
    repaintTimer.start()
  }
}
