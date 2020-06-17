The __@json__ scala macro annotation is the quickest way to add a
`spray.json.RootJsonFormat` to your case classes.

# How it works
Just add `@json` in front of your case class definition:

```scala
import us.logico_philosophic.macros.json

@json case class Person(name: String, age: Int)
```

You can now serialize/deserialize your objects:

```scala
import spray.json.{enrichAny, enrichString}

val person = Person("Victor Hugo", 46)
val json = person.toJson
json.convertTo[Person]
```

# Installation

Add the following settings to your build:

```scala

libraryDependencies += "us.logico-philosophic" %% "spray-json-annotation" % "0.1.0"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
```

This library was tested with both Scala 2.11 and 2.12.
