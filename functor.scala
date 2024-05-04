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
