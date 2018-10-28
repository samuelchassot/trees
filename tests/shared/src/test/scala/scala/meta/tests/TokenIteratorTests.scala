package scala.meta.tests

import org.scalameta.tests.typecheckError
import org.scalatest._

import scala.meta._

class TokenIteratorTests extends FunSuite {
  test("my first test") {
    println("hi")
    assert(typecheckError("""
      import scala.meta._
      import scala.meta.dialects.Scala211
      q"package foo {}; package bar {}"
    """).replace("\r", "") === """
                                 |<macro>:4: these statements can't be mixed together, try source"..." instead
                                 |      q"package foo {}; package bar {}"
                                 |        ^
                               """.trim.stripMargin.replace("\r", ""))
  }

}
