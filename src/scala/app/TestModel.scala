package app

import java.util

import app.framework.Model

object TestModel {
  final class TodoItem(description: String) {
    if (description == null) throw new NullPointerException
    def description(): String = this.description
    override def toString: String = this.description
  }
}

final class TestModel(application: TestApp) extends Model(application) {
  private val todos = new util.LinkedHashSet[TestModel.TodoItem]

  def todos1: Array[TestModel.TodoItem] = this.todos.toArray(new Array[TestModel.TodoItem](this.todos.size))

  def add(todo: TestModel.TodoItem): Unit = {
    if (todo == null) throw new NullPointerException
    this.todos.add(todo)
    this.emit("todos:changed", todo)
  }

  def remove(todo: TestModel.TodoItem): Unit = {
    if (todo == null) throw new NullPointerException
    this.todos.remove(todo)
    this.emit("todos:changed", todo)
  }

  def clear(): Unit = {
    if (this.todos.isEmpty) return
    this.todos.clear()
    this.emit("todos:changed")
  }
}
