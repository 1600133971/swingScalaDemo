import javax.swing._
import javax.swing.event.ChangeEvent
import java.awt.event.ActionEvent

object JMenuBarTest {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val jf = new JFrame("JMenuBarTest测试窗口")
    jf.setSize(300, 300)
    jf.setLocationRelativeTo(null)
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    /*
     * 创建一个菜单栏
     */
    val menuBar = new JMenuBar
    /*
     * 创建一级菜单
     */
    val fileMenu = new JMenu("文件")
    val editMenu = new JMenu("编辑")
    val viewMenu = new JMenu("视图")
    val aboutMenu = new JMenu("关于")
    // 一级菜单添加到菜单栏
    menuBar.add(fileMenu)
    menuBar.add(editMenu)
    menuBar.add(viewMenu)
    menuBar.add(aboutMenu)
    /*
     * 创建 "文件" 一级菜单的子菜单
     */
    val newMenuItem = new JMenuItem("新建")
    val openMenuItem = new JMenuItem("打开")
    val exitMenuItem = new JMenuItem("退出")
    // 子菜单添加到一级菜单
    fileMenu.add(newMenuItem)
    fileMenu.add(openMenuItem)
    fileMenu.addSeparator() // 添加一条分割线

    fileMenu.add(exitMenuItem)
    /*
     * 创建 "编辑" 一级菜单的子菜单
     */
    val copyMenuItem = new JMenuItem("复制")
    val pasteMenuItem = new JMenuItem("粘贴")
    editMenu.add(copyMenuItem)
    editMenu.add(pasteMenuItem)
    /*
     * 创建 "视图" 一级菜单的子菜单
     */
    val checkBoxMenuItem = new JCheckBoxMenuItem("复选框子菜单")
    val radioButtonMenuItem01 = new JRadioButtonMenuItem("单选按钮子菜单01")
    val radioButtonMenuItem02 = new JRadioButtonMenuItem("单选按钮子菜单02")
    viewMenu.add(checkBoxMenuItem)
    viewMenu.addSeparator() // 添加一个分割线

    viewMenu.add(radioButtonMenuItem01)
    viewMenu.add(radioButtonMenuItem02)
    // 其中两个 单选按钮子菜单，要实现单选按钮的效果，需要将它们放到一个按钮组中
    val btnGroup = new ButtonGroup
    btnGroup.add(radioButtonMenuItem01)
    btnGroup.add(radioButtonMenuItem02)
    // 默认第一个单选按钮子菜单选中
    radioButtonMenuItem01.setSelected(true)
    /*
     * 菜单项的点击/状态改变事件监听，事件监听可以直接设置在具体的子菜单上（这里只设置其中几个）
     */
    // 设置 "新建" 子菜单被点击的监听器
    newMenuItem.addActionListener((_: ActionEvent)  => {
      System.out.println("新建  被点击")
    })
    // 设置 "打开" 子菜单被点击的监听器
    openMenuItem.addActionListener((_: ActionEvent) => {
      System.out.println("打开  被点击")
    })
    // 设置 "退出" 子菜单被点击的监听器
    exitMenuItem.addActionListener((_: ActionEvent) => {
      System.out.println("退出  被点击")
    })
    // 设置 复选框子菜单 状态改变 监听器
    checkBoxMenuItem.addChangeListener((_: ChangeEvent) => {
      System.out.println("复选框是否被选中: " + checkBoxMenuItem.isSelected)
    })
    // 设置 单选按钮子菜单 状态改变 监听器
    radioButtonMenuItem01.addChangeListener((_: ChangeEvent) => {
      System.out.println("单选按钮01 是否被选中: " + radioButtonMenuItem01.isSelected)
    })
    /*
     * 最后 把菜单栏设置到窗口
     */
    jf.setJMenuBar(menuBar)
    jf.setVisible(true)
  }
}
