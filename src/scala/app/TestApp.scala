package app

import javax.swing.JFrame
import app.framework.Application

object TestApp {
  def main(args: Array[String]): Unit = {
    new TestApp
  }
}

final class TestApp extends Application {
  override protected def start(frame: JFrame): Unit = {
    frame.setTitle("Test")
    frame.setJMenuBar(new TestMenuView(this).render)
    frame.getContentPane.add(new TestView(this).render)
  }
}
