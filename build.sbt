organization := "us.logico_philosophic"

name := "json-annotation"

version := "0.1.0"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.2", "2.10.3", "2.10.4", "2.11.0", "2.11.1")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/"
);

libraryDependencies ++= (if(scalaVersion.value.startsWith("2.10"))
    List("org.scalamacros" %% "quasiquotes" % "2.0.1") else Nil)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "io.spray" %%  "spray-json" % "1.3.5" % Test,
  "com.lihaoyi" %% "utest" % "0.6.8" % Test)

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value /
    (if (scalaBinaryVersion.value.startsWith("2.10")) "scala_2.10" else "scala_2.11")

testFrameworks += new TestFramework("utest.runner.Framework")

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }
