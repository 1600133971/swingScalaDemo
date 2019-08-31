package app

import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextField
import javax.swing.border.EmptyBorder
import app.framework.View
import javax.swing.event.ListSelectionEvent

final class TestView(application: TestApp) extends View[TestModel, TestController](application) {
  // Initialize the model and controller of the view. The order in which these
  // are initialized does not matter as they will automagically be wired
  // together regardless.
  this.model(new TestModel(application))
  this.controller(new TestController(application))

  override def render: JPanel = {
    val viewPanel = new JPanel(new BorderLayout)
    viewPanel.setBorder(new EmptyBorder(10, 10, 10, 10))
    val inputPanel = new JPanel
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS))
    inputPanel.setBorder(new EmptyBorder(0, 0, 10, 0))
    viewPanel.add(inputPanel, BorderLayout.NORTH)
    // Create a 10-column text field for inputting descriptions.
    val todoInput = new JTextField(10)
    inputPanel.add(todoInput, BorderLayout.NORTH)
    todoInput.addActionListener((_: ActionEvent) => {
      try // Delegate creation of the item to the controller.
        this.controller.create(todoInput.getText)
      catch {
        case ex: IllegalArgumentException =>
          // Simply print out the error message to the error console whenever
          // the user enter invalid input. This should ideally be displayed in a
          // nice looking error dialog of sorts in a real application.
          System.err.println(ex.getMessage)
      }
      // Clear the text input field.
      todoInput.setText(null)
    })
    val todoSubmit = new JButton("Create")
    inputPanel.add(todoSubmit, BorderLayout.NORTH)
    // Trigger the action event of the text input field whenever the submit
    // button is pressed. This make pressing the button equivalent to hitting
    // enter when the text input field is focused.
    todoSubmit.addActionListener((_: ActionEvent) => todoInput.postActionEvent())
    val todosList = new JList[TestModel.TodoItem](this.model.todos1)
    this.model.on("todos:changed", (_: TestModel.TodoItem) => {
      todosList.setListData(this.model.todos1)
    })
    val todosPane = new JScrollPane(todosList)
    viewPanel.add(todosPane, BorderLayout.CENTER)
    val actionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0))
    actionsPanel.setBorder(new EmptyBorder(10, 0, 0, 0))
    viewPanel.add(actionsPanel, BorderLayout.SOUTH)
    val todoComplete = new JButton("Complete")
    todoComplete.setEnabled(!todosList.isSelectionEmpty)
    actionsPanel.add(todoComplete)
    todoComplete.addActionListener((_: ActionEvent) => {
      // Get the currently selected items.
      val selectedTodos = todosList.getSelectedValuesList
      // Delegate deletion of the item to the controller.
      this.controller.complete(selectedTodos)
    })
    todosList.addListSelectionListener((_: ListSelectionEvent) => {
      // Enable/disable the "Complete" button whenever the list of todos
      // goes in and out of focus.
      todoComplete.setEnabled(!todosList.isSelectionEmpty)
    })
    viewPanel
  }
}