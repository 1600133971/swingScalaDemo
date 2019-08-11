import java.awt.{Color, Font, Frame, KeyEventDispatcher, KeyboardFocusManager, LayoutManager}
import java.awt.event.{ActionEvent, ActionListener, KeyAdapter, KeyEvent, MouseAdapter, MouseEvent, MouseMotionAdapter}

import javax.swing._
import java.beans.PropertyVetoException
import javax.swing.border.EtchedBorder
import net.miginfocom.swing.MigLayout

object Demo {
  def main(args: Array[String]): Unit = {
    val jf = new JFrame("Demo测试窗口")
    jf.setExtendedState(Frame.MAXIMIZED_BOTH);
    jf.setLocationRelativeTo(null)
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    // 创建 桌面面板
    val desktopPane = new JDesktopPane

    val menuBar = new JMenuBar
    val fileMenu = new JMenu("文件")
    menuBar.add(fileMenu)

    val openMenuItem = new JMenuItem("打开")
    val exitMenuItem = new JMenuItem("退出")

    fileMenu.add(openMenuItem)
    fileMenu.addSeparator() // 添加一条分割线
    fileMenu.add(exitMenuItem)

    // 设置 "打开" 子菜单被点击的监听器
    openMenuItem.addActionListener((_: ActionEvent) => {
      System.out.println("打开  被点击")
      // 创建 内部窗口
      val internalFrame = createInternalFrame
      // 添加 内部窗口 到 桌面面板
      desktopPane.add(internalFrame)
      try // 设置 内部窗口 被选中
        internalFrame.setSelected(true)
      catch {
        case e: PropertyVetoException =>
          e.printStackTrace()
      }
    })
    // 设置 "退出" 子菜单被点击的监听器
    exitMenuItem.addActionListener((_: ActionEvent) => {
      System.out.println("退出  被点击")
      System.exit(0)
    })

    // 把 桌面面板 作为 内容面板 设置到窗口并显示
    jf.setJMenuBar(menuBar)
    jf.setContentPane(desktopPane)
    jf.setVisible(true)
  }

  val OPAQUE = false
  var benchRuns = 0
  def createTabPanel(lm: LayoutManager) = {
    val panel = new JPanel(lm)
    //configureActiveComponet(panel)
    panel.setOpaque(OPAQUE)
    panel
  }

  def createPanel(s: String) = {
    val panel = new JLabel(s, SwingConstants.CENTER) {
      override def addNotify(): Unit = {
        super.addNotify()
        if (benchRuns == 0) { // Since this does not exist in the SWT version
          if (getText.length == 0) {
            val lText = getParent.getLayout.asInstanceOf[MigLayout].getComponentConstraints(this).asInstanceOf[String]
            setText(if (lText != null && lText.length > 0) lText
            else "<Empty>")
          }
        }
      }
    }
    panel.setBorder(new EtchedBorder)
    panel.setOpaque(true)
    //configureActiveComponet(panel)
    panel
  }

  def getData: Array[Array[Any]] = {
    val data = Array.ofDim[Any](20, 6)
    var r = 0
    while (r < data.length) {
      data(r) = new Array[Any](6)
      var c = 0
      while (c < data(r).length) {
      data(r)(c) = "Cell " + (r + 1) + ", " + (c + 1)
      c += 1
    }
      r += 1
    }
    data
  }

  def createInternalFrame: JInternalFrame = {
    val internalFrame = new JInternalFrame(
      "内部窗口", // title
      true, // resizable
      true, // closable
      true, // maximizable
      true // iconifiable
    )
    // 设置窗口的宽高
    internalFrame.setSize(800, 600)

    // 设置窗口的显示位置
    internalFrame.setLocation(50, 50)

    // 内部窗口的关闭按钮动作默认就是销毁窗口，所有不用设置
    internalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    val p1 = createTabPanel(new MigLayout("fill"))
    p1.add(createPanel("1. North"), "north")
    p1.add(createPanel("2. West"), "west")
    p1.add(new JScrollPane(new STable(getData, Array[String]("Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6"))), "grow")
    p1.add(createPanel("3. South"), "grow")

    val tabbedPane = new JTabbedPane
    tabbedPane.addTab("Docking 1 (fill)", p1)

    // 设置内部窗口的内容面板
    internalFrame.setContentPane(tabbedPane)

    // 显示内部窗口
    internalFrame.setVisible(true)
    internalFrame
  }
}
