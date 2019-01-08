
The following are some notes taken by a user who set up the plugin for development in IntelliJ on a Windows machine.


* Import pom.xml using IntelliJ

* Point IntelliJ to the Maven version installed to the Atlassian plugin SDK: File -> Settings -> Build, Execution, Deployment -> Build Tools -> Maven -> Maven home directory. Default installation of the plugin SDK is in C:\Applications\Atlassian

* To run the built plugin in an instance of bamboo, run the bamboo:run maven task.

* The plugin can be configured with QuickReload in the codedx-bamboo-plugin POM file. If this is set to true, a developer only needs to run bamboo:run, and then run atlas-mvn package in a seperate console session to build an updated version of the plugin, and have the Bamboo instance automatically reload the plugin.

* When setting up bamboo, don't forget to configure your git install directory via the Server capabilities administration menu.

* To debug in Intellij: run bamboo:debug, then go to Run->Attach to local process... and select the Catalina process.
