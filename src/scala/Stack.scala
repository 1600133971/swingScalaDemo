
class Stack[A] {
  private var elements: List[A] = Nil
  //泛型方法
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

object Stack {
  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop())  // prints 2
    println(stack.pop())  // prints 1
  }
}

abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

object CovarianceTest extends App {
  //定义参数类型List[Animal]
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
  //传入参数类型为List[Cat]
  printAnimalNames(cats)
  // Whiskers
  // Tom
  //传入参数类型为List[Dog]
  printAnimalNames(dogs)
  // Fido
  // Rex
}