import javax.swing.JTable
import javax.swing.table.AbstractTableModel

class STable(rowData: Array[Array[Any]], columnNames: Seq[_]) extends JTable (
  new AbstractTableModel {
    override def getColumnName(column: Int): String = columnNames(column).toString
    def getRowCount: Int = rowData.length
    def getColumnCount: Int = columnNames.length
    def getValueAt(row: Int, col: Int): AnyRef = rowData(row)(col).asInstanceOf[AnyRef]
    override def isCellEditable(row: Int, column: Int) = true
    override def setValueAt(value: Any, row: Int, col: Int): Unit = {
      rowData(row)(col) = value
      fireTableCellUpdated(row, col)
    }
  }) {
}
