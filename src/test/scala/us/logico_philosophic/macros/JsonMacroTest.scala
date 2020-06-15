package us.logico_philosophic.macros

import utest._
import spray.json.{enrichAny, enrichString}
import spray.json.DefaultJsonProtocol._

object JsonMacroTests extends TestSuite { val tests = Tests {
  "one field" - {
    @json case class City(name: String)
    val city = City("San Francisco")
    val js = """{"name": "San Francisco"}""".parseJson
    city.toJson ==> js
    js.convertTo[City] ==> city}

  "two fields" - {
    @json case class Person(name: String, age: Int)
    val person = Person("Victor Hugo", 46)
    val js = """{"name": "Victor Hugo", "age": 46}""".parseJson
    person.toJson ==> js
    js.convertTo[Person] ==> person}

  "final class" - {
    @json final case class Geo(lat: Double, lon: Double)
    val geo = Geo(0, 0)
    val js = """{"lat": 0, "lon": 0}""".parseJson
    geo.toJson ==> js
    js.convertTo[Geo] ==> geo}
}}
