package app

import java.awt.Toolkit
import java.awt.event.{ActionEvent, KeyEvent}
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import javax.swing.KeyStroke
import app.framework.View

final class TestMenuView(application: TestApp) extends View(application) {
  override def render: JMenuBar = {
    val menuBar = new JMenuBar
    val fileMenu = new JMenu("File")
    menuBar.add(fileMenu)
    val clearTodos = new JMenuItem("Clear")
    fileMenu.add(clearTodos)
    // Enabled triggering the "Clear Todos" menu item using a keyboard shortcut
    // consisting of the default shortcut key mask (CTRL on Windows, CMD on Mac)
    // and the back space key.
    clearTodos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, Toolkit.getDefaultToolkit.getMenuShortcutKeyMaskEx))
    // Emit an event signalling to controllers and/or views that we wish for the
    // list of todos to be cleared. We're not interested in which component
    // actually takes care of clearing the list of todos; just as long as
    // somebody does it. This ensures that we don't unnecessarily couple
    // components that we otherwise could have avoided coupling.
    clearTodos.addActionListener((_: ActionEvent) => this.emit("todos:clear"))
    menuBar
  }
}