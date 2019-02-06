## Foreword

 * This project makes use of a generated swagger client in order to communicate with Code Dx.  Regenerating the swagger client should not be needed in theory.  If the plug-in is communicating correctly with Code Dx, ignore this document.  Regenerating the client would only be needed if the Code Dx server "swagger.json" file changed endpoints used in this project in such a way that is not backwards compatible.

 * The generated swagger client code has been moved to "com.codedx.client" to avoid requiring the user to install it into their local maven repository.

 * Ideally, the swagger client would be kept up to date in a public maven repository.  For now we avoid that because the Bamboo swagger client needs to be generated with a special argument to use the `jersey2` library.  This makes us currently unable to share the same swagger library as the other Code Dx plug-ins.

### Generating the Swagger Client

 * The swagger client that has been integrated into this project was generated with the `swagger-codegen` command on a mac.  It was generated using the swagger.json file from Code Dx repository commit SHA `9cf4f4ab413a98c87db441d43349819e2767eb0f`.


 1. If needed, remove the folder `swagger-codegen-codedx-api` in the root of this repository.

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

 * Currently, the swagger code is incorporated into the Bamboo plug-in under "com.codedx.client".  After generating the new client code, upgrading should be possibly by replacing that folder and resolve any "pom.xml" issues.

 * Alternatively, the swagger client can be added to your local maven repository.  Navigate to the *swagger-codegen-codedx-api* folder in a command line and run the following...  The folder should be in the root of this repository if it was generated correctly.

 ```sh
 atlas-mvn install
 ```

 If going this route, be sure to add the following in your "pom.xml" file under the "dependencies" tag

 ```sh
 <dependency>
     <groupId>com.codedx</groupId>
     <artifactId>swagger-codegen-codedx-api-client</artifactId>
     <version>1.0.0</version>
     <scope>compile</scope>
 </dependency>
 ```
 