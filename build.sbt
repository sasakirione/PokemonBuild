name := "PokemonBuild"

version := "1.0"

lazy val `pokemonbuild` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.3.3",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.3",
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  ehcache,
  ws,
  specs2 % Test,
  guice)
