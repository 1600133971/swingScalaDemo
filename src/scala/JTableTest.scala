import javax.swing._
import java.awt._

object JTableTest {
  def main(args: Array[String]): Unit = {
    val jf = new JFrame("测试窗口")
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    // 创建内容面板，使用边界布局
    val panel = new JPanel(new BorderLayout)

    // 表头（列名）
    val columnNames = Array("姓名", "语文", "数学", "英语", "总分")

    // 表格所有行数据
    val rowData = Array(
      Array("张三", 80, 80, 80, 240),
      Array("John", 70, 80, 90, 240),
      Array("Sue", 70, 70, 70, 210),
      Array("Jane", 80, 70, 60, 210),
      Array("Joe", 80, 70, 60, 210))

    // 创建一个表格，指定 所有行数据 和 表头
    val table = new STable(rowData, columnNames)
    import org.oxbow.swingbits.table.filter.TableRowFilterSupport
    TableRowFilterSupport.forTable(table).searchable(true).apply

    // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
    panel.add(table.getTableHeader, BorderLayout.NORTH)

    // 把 表格内容 添加到容器中心
    panel.add(table, BorderLayout.CENTER)
    jf.setContentPane(panel)
    jf.pack()
    jf.setLocationRelativeTo(null)
    jf.setVisible(true)
  }
}
