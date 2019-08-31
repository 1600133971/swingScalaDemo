package app

import java.util
import app.framework.Controller

final class TestController(application: TestApp) extends Controller[TestModel, TestView](application) {
  // Whenever another component requests that the list of todos be cleared,
  // clear it. This event can be emitted by both views and/or controllers; we
  // don't really care.
  this.on("todos:clear", (_: Any) => this.clear())

  def create(description: String): Unit = {
    if (description == null) throw new NullPointerException
    // Trim the description for trailing whitespace.
    val trimmedDescription = description.trim
    // Check that the trimmed description isn't empty. If the description is
    // indeed empty, throw an exception for the callers to act upon. If the
    // caller is a view, then a suitable error message could be displayed.
    if (trimmedDescription.isEmpty) throw new IllegalArgumentException("Todo descriptions cannot be empty.")
    // Create a new item using the now sanitized description.
    val todo = new TestModel.TodoItem(trimmedDescription)
    // Update the model with the newly created item.
    this.model.add(todo)
  }

  def complete(todo: TestModel.TodoItem): Unit = {
    if (todo == null) throw new NullPointerException
    // Remove the item from the model.
    this.model.remove(todo)
  }

  def complete(todos: util.List[TestModel.TodoItem]): Unit = {
    if (todos == null) throw new NullPointerException
    //import scala.collection.JavaConversions._
    todos.forEach(x => this.complete(x))
  }

  def clear(): Unit = {
    this.model.clear()
  }
}
