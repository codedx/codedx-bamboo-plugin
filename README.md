codedx-bamboo-plugin
=====================

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A Code Dx plugin for Bamboo

## Prerequisite Setup

 1. Install Atlassian Plugin SDK: (Windows url) - https://developer.atlassian.com/server/framework/atlassian-sdk/install-the-atlassian-sdk-on-a-windows-system/
 Additional information about the SDK can be found here - https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK

 2. For development, IntelliJ is recommended.  If stuck setting up IntelliJ, [some notes are included here](IntelliJNotes.md) from a user who set up the plugin for development in IntelliJ on Windows.

 3. If needed, update the Swagger client [following the instructions here](SwaggerSetup.md).  This shouldn't be needed but may be necessary if there is a version mismatch with the Code Dx server.

## Running the Plugin

 * It is recommended to run and debug the plugin from IntelliJ.  Alternatively, it can be done from the command line.

### Running and Debugging from IntelliJ

 * First, open the Maven window on the right side of IntelliJ.  If the window doesn't show any commands, use the `Reimport all Maven Projects` button and the `Generate Source and Update Folders for All Projects` button to populate the list.

 * To clean the project, run the `codedx-bamboo-plugin/Lifecycle/clean` maven command.

 * To run the project, run the `codedx-bamboo-plugin/Plugins/bamboo/bamboo:run` maven command.

 * To debug the project, run the `codedx-bamboo-plugin/Plugins/bamboo/bamboo:debug` maven command.

 * *NOTE: The debug command does not attach the debugger.  It merely allows for a debugger to connect on port 5005.  For breakpoints to be hit, a "remote" debug configuration must be set up and run.  It can be set up in the "Edit Configurations..." window (dropdown next to the debug button on the top bar of Mac client).*

### Running and Debugging from Command Line

 * The following commands can be used to run and debug the plugin from the root of this repository.  Only the run command was tested (briefly), and it didn't work consistently.

 `atlas-run`
 `atlas-debug`

 * *NOTE: Based on how it works in IntelliJ, I'm guessing the debug command allows remote debuggers to attached through port 5005.*

## Deploying the Plugin

See https://confluence.atlassian.com/bamboo/installing-a-plugin-289277265.html for details on plugin installation.
