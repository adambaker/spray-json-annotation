organization := "us.logico-philosophic"

name := "json-annotation"

description := "@json macro for case class spray-json formats."

version := "0.1.0"

scalaVersion := "2.11.12"
//scalaVersion := "2.12.11"

crossScalaVersions := Seq("2.11.12", "2.12.11")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/",
  "Secured Central Repository" at "https://repo1.maven.org/maven2")

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "io.spray" %%  "spray-json" % "1.3.5" % Test,
  "com.lihaoyi" %% "utest" % "0.6.7" % Test)

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value /
    (if (scalaBinaryVersion.value.startsWith("2.10"))
     "scala_2.10" else "scala_2.11")

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

pomExtra := (
  <url>https://github.com/adambaker/spray-json-annotation</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/adambaker/spray-json-annotation</url>
    <connection>scm:git:git@github.com:adambaker/spray-json-annotation.git</connection>
  </scm>
  <developers>
    <developer>
      <id>adambaker</id>
      <name>Adam Baker</name>
      <url>https://github.com/adambaker</url>
    </developer>
  </developers>)
// Forked from https://github.com/kifi/json-annotation. Thanks to Martin Raison.
