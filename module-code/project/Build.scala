import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "securesocial"
    val appVersion      = "master"

    val appDependencies = Seq(
      // not available yet for Scala 2.10? (as of December 19, 2012 - and certainly not in October 2012.)
      // So, for now, the actual code has been copy-pasted to app/com/typesafe/plugin/package.scala.
      // "com.typesafe" %% "play-plugins-util" % "2.0.3",
      // Is mailer version "2.1-RC1", for Scala 2.10, available anywhere? Right now the code throws
      // an UnsupportedOperationException if you try to use the mailer.
      // "com.typesafe" %% "play-plugins-mailer" % "2.0.4"
      // -- Instead of the mailer:---------------
      // "play" %% "play" % playVersion,
      "org.apache.commons" % "commons-email" % "1.2",
      // "com.typesafe" %% "play-plugins-util" % "2.1-SNAPSHOT" // already included above
      // ----------------------------------------
      "org.mindrot" % "jbcrypt" % "0.3m"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers ++= Seq(
        "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
      )
    )

}
