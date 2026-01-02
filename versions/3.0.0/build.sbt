import sbt.Keys.versionScheme

// --- Build Global Settings ---
ThisBuild / organization := "com.zoho.crm"
ThisBuild / organizationName := "zoho"
ThisBuild / organizationHomepage := Some(url("https://www.zoho.com/crm/"))
ThisBuild / scalaVersion := "3.3.7"
ThisBuild / version := "3.0.0"
ThisBuild / versionScheme := Some("semver-spec")

// --- Project Definition ---
lazy val root = (project in file("."))
  .settings(
    name := "zohocrmsdk-8-0",
    description := "An API client for CRM customers, with which they can call ZOHO CRM APIs with ease",

    // Dependencies (Updated to Latest Stable 2025)
    libraryDependencies ++= Seq(
      "com.mysql"                         % "mysql-connector-j" % "9.3.0",
      "org.json"                          % "json"              % "20251224",
      "org.apache.httpcomponents.core5"   % "httpcore5"         % "5.4",
      "org.apache.httpcomponents.client5" % "httpclient5"       % "5.5.2",
      "commons-io"                        % "commons-io"        % "2.21.0",
      "org.slf4j"                         % "slf4j-api"         % "2.0.17",
      "org.slf4j"                         % "slf4j-simple"      % "2.0.17"
    ),

    // Publishing Settings (Sonatype Central Portal / S01)
    publishMavenStyle := true,
    pomIncludeRepository := { _ => false },
    sonatypeProfileName := "com.zoho",
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    publishTo := sonatypePublishToBundle.value,

    // Credentials using Env Vars
    credentials += Credentials(
      "Sonatype Nexus Repository Manager",
      "s01.oss.sonatype.org",
      sys.env.getOrElse("OSSRH_USER", ""),
      sys.env.getOrElse("OSSRH_PASSWORD", "")
    ),

    // POM Metadata for Maven Central
    homepage := Some(url("https://github.com/zoho/zohocrm-scala-sdk-8.0")),
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/zoho/zohocrm-scala-sdk-8.0"),
        "scm:git@github.com:zoho/zohocrm-scala-sdk-8.0.git"
      )
    ),
    developers := List(
      Developer(
        id    = "ZOHO CRM API TEAM",
        name  = "ZOHO CRM API TEAM",
        email = "support@zohocrm.com",
        url   = url("https://www.zoho.com/crm/")
      )
    ),

    // Misc Settings
    crossPaths := false // Disables _3 suffix in artifact name for Java-like naming
  )