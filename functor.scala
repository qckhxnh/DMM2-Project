trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object FunctorInstances {
  // Implementing Functor for Option
  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  // Implementing Functor for List
  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }
}

object FunctorUsage {
  // Example usage with Option
  def addOne(x: Int): Int = x + 1

  import FunctorInstances.optionFunctor

  val optionValue: Option[Int] = Some(5)
  val resultOption: Option[Int] = Functor[Option].map(optionValue)(addOne)
  println(resultOption) // Output: Some(6)

  // Example usage with List
  def square(x: Int): Int = x * x

  import FunctorInstances.listFunctor

  val listValue: List[Int] = List(1, 2, 3, 4, 5)
  val resultList: List[Int] = Functor[List].map(listValue)(square)
  println(resultList) // Output: List(1, 4, 9, 16, 25)
}

/**In this implementation:

- We define a Functor trait with a map method. This trait is parameterized with a type constructor F[_], representing a higher-kinded type.
- We provide instances of Functor for different data types like Option and List in the FunctorInstances object. Each instance implements the map method for the corresponding data type.
- In the FunctorUsage object, we demonstrate how to use the functor instances by mapping functions over values of Option and List.
- For example, we define addOne and square functions and map them over Option and List values to transform their contents.

This implementation showcases the use of type classes and higher-kinded types in Scala to define and use functors.**/
