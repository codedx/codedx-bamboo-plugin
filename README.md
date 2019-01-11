codedx-bamboo-plugin
=====================

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A Code Dx plugin for Bamboo

## Prerequisite Setup

 1. Install Atlassian Plugin SDK: (Windows url) - https://developer.atlassian.com/server/framework/atlassian-sdk/install-the-atlassian-sdk-on-a-windows-system/
 Additional information about the SDK can be found here - https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK

 2. Set up the Swagger client following the instructions in the **Swagger Setup** section.

 3. For development, IntelliJ is recommended.  If stuck setting up IntelliJ, [some notes are included here](IntelliJNotes.md) from a user who set up the plugin for development in IntelliJ on Windows.

## Swagger Setup

 * This project makes use of a local swagger client sub-project in order to communicate with Code Dx.  In order to build this plugin, a Code Dx swagger project must be in the root directory of this plugin, and must be installed into your local maven repository.

 * *NOTE: The local swagger client needs to be generated with a special argument to use the `jersey2` library.  Keep this in mind when considering migrating to use a remote swagger client library.*

### Generating the Swagger Client

 * A swagger client has already been added to the root of this repository.  It was generated with the `swagger-codegen` command on a mac, using the swagger.json file from Code Dx repository commit SHA `9cf4f4ab413a98c87db441d43349819e2767eb0f`.  You may opt to use this instead of generating a new client.  The following instructions are for generating a new swagger client.


 1. Remove the folder `swagger-codegen-codedx-api` in the root of this repository.

 2. Navigate to the root of this repository in a command prompt or terminal.

 3. Generate the swagger client using one of the following two methods.

#### Using Java (Windows or Mac)

 * *NOTE: This was tested with Java 1.8 on a Mac.*


 1. Install java if needed.  Add to PATH on Windows or JAVA_HOME on Mac.

 2. Obtain a swagger jar or opt to use the included `swagger-codegen-cli-2.3.1.jar` in the root of this repository.

 3. Run the following... Be sure to change the Code Dx repository path as well as the swagger-codegen filename if you chose to get a different version jar.

 ```sh
 java -jar swagger-codegen-cli-2.3.1.jar generate -i /PATH_TO_CODEDX_REPO/codedx/dev/lift-project/swaggerUI/src/static/swagger.json --api-package com.codedx.client.api --model-package com.codedx.client.api --group-id com.codedx --artifact-id swagger-codegen-codedx-api-client -l java -o swagger-codegen-codedx-api --library jersey2
 ```

#### Using HomeBrew on Mac

 * *NOTE: This was tested with swagger-codegen version 2.3.1*


 1. Run the following to get the **swagger-codegen** package.

 ```sh
 brew install swagger-codegen
 ```

 2. Run the following to generate the client... Be sure to change the Code Dx repository path.

 ```sh
 swagger-codegen generate -i /PATH_TO_CODEDX_REPO/codedx/dev/lift-project/swaggerUI/src/static/swagger.json --api-package com.codedx.client.api --model-package com.codedx.client.api --group-id com.codedx --artifact-id swagger-codegen-codedx-api-client -l java -o swagger-codegen-codedx-api --library jersey2
 ```

### Installing the Swagger Client

 * The swagger client needs to be added to your local maven repository.  Navigate to the *swagger-codegen-codedx-api* folder in a command line and run the following...  The folder should be in the root of this repository if it was generated correctly.

 ```sh
 atlas-mvn install
 ```

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

 * TBD
