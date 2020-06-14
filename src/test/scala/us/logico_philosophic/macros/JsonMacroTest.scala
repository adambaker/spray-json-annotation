package us.logico_philosophic.macros

import utest._
import spray.json.{enrichAny, enrichString, JsObject, JsString, JsNumber, DefaultJsonProtocol}
import DefaultJsonProtocol._

@json case class City(name: String)
@json case class Person(name: String, age: Int)

object JsonMacroTests extends TestSuite { val tests = Tests {
  "one field" - {
    val city = City("San Francisco")
    val js = """{"name": "San Francisco"}""".parseJson
    city.toJson ==> js
    js.convertTo[City] ==> city}

  "two fields" - {
      val person = Person("Victor Hugo", 46)
      val js = """{"name": "Victor Hugo", "age": 46}""".parseJson
      person.toJson ==> js
      js.convertTo[Person] ==> person}}}
