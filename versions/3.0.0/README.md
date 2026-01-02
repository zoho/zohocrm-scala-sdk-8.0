License
=======

    Copyright (c) 2021, ZOHO CORPORATION PRIVATE LIMITED 
    All rights reserved. 

    Licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 
    You may obtain a copy of the License at 
    
        http://www.apache.org/licenses/LICENSE-2.0 
    
    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

# ZOHO CRM SCALA SDK 8.0 for API version 8

## Table Of Contents

* [Overview](#overview)
* [Registering a Zoho Client](#registering-a-zoho-client)
* [Environmental Setup](#environmental-setup)
* [Including the SDK in your project](#including-the-sdk-in-your-project)
* [Persistence](#token-persistence)
  * [DataBase Persistence](#database-persistence)
  * [File Persistence](#file-persistence)
  * [Custom Persistence](#custom-persistence)
* [Configuration](#configuration)
* [Initialization](#initializing-the-application)
* [Class Hierarchy](#class-hierarchy)
* [Responses And Exceptions](#responses-and-exceptions)
* [Threading](#threading-in-the-scala-sdk)
  * [Multithreading in a Multi-User App](#multithreading-in-a-multi-user-app)
  * [Multi-threading in a Single User App](#multi-threading-in-a-single-user-app)
* [Sample Code](#sdk-sample-code)

## Overview

Zoho CRM Scala SDK offers a way to create client Scala applications that can be integrated with Zoho CRM.

## Registering a Zoho Client

Since Zoho CRM APIs are authenticated with OAuth2 standards, you should register your client app with Zoho. To register your app:

- Visit this page [https://api-console.zoho.com/](https://api-console.zoho.com)

- Click `ADD CLIENT`.

- Choose the `Client Type`.

- Enter **Client Name**, **Client Domain** or **Homepage URL** and **Authorized Redirect URIs**. Click `CREATE`.

- Your Client app will be created.

- Select the created OAuth client.

- Generate grant token by providing the necessary scopes, time duration (the duration for which the generated token is valid) and Scope Description.

## Environmental Setup

Scala SDK requires java (version 11 and above) and scala version 2.13 and above to be set up in your development environment.

## Including the SDK in your project

Scala SDK is available through Maven distribution. You can include the SDK to your project using:
1. Build.sbt
    ```
    libraryDependencies ++= Seq( "com.zoho.crm" % "zohocrmsdk-8-0" % "3.0.0")
    ```
2. Maven

    - pom.xml file.

    ```xml

    <dependencies>
        <dependency>
            <groupId>com.zoho.crm</groupId>
            <artifactId>zohocrmsdk-8-0</artifactId>
            <version>3.0.0</version>
        </dependency>
    </dependencies>
    ```

3. Gradle

    ```gradle
 
    dependencies{
        implementation 'com.zoho.crm:zohocrmsdk-8-0:3.0.0'
    }
     ```

### Dependency JARs

[httpcore5-5.4.jar](https://mvnrepository.com/artifact/org.apache.httpcomponents.core5/httpcore5/5.4)

[httpclient5-5.5.2.jar](https://mvnrepository.com/artifact/org.apache.httpcomponents.client5/httpclient5/5.5.2)

[json-20251224.jar](https://mvnrepository.com/artifact/org.json/json/20251224)

[mysql-connector-j-9.3.0.jar](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.3.0)

[commons-io-2.21.0.jar](https://mvnrepository.com/artifact/commons-io/commons-io/2.21.0)

[slf4j-api-2.0.17.jar](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/2.0.17)

[slf4j-simple-2.0.17.jar](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/2.0.17)

## Token Persistence

Token persistence refers to storing and utilizing the authentication tokens that are provided by Zoho. Token persistence enables the SDK to automatically refresh the access token after initialization using the refresh token without the need for user intervention. There are three ways provided by the SDK in which persistence can be utilized. They are DataBase Persistence, File Persistence, and Custom Persistence. Please note that the default method of token persistence provided by the Zoho CRM SDK is File persistence.

### Table of Contents

- [DataBase Persistence](#database-persistence)

- [File Persistence](#file-persistence)

- [Custom Persistence](#custom-persistence)

### Implementing OAuth Persistence

Once the application is authorized, OAuth access and refresh tokens can be used for subsequent user data requests to Zoho CRM. Hence, they need to be persisted by the client app.

The persistence is achieved by writing an implementation of the inbuilt **TokenStore interface**, which has the following callback methods.

- **findToken(Token token)** - invoked before firing a request to fetch the saved tokens. This method should return an implementation of **Token interface** object for the library to process it.

- **saveToken(Token token)** - invoked after fetching access and refresh tokens from Zoho.

- **deleteToken(String id)** - invoked before saving the latest tokens.

- **getTokens()** - The method to retrieve all the stored tokens.

- **deleteTokens()** - The method to delete all the stored tokens.

- **findTokenById(String id)** - The method to retrieve the user's token details based on unique ID.

### DataBase Persistence

Database persistence is a technique that involves storing and retrieving data from a database. In case the user prefers to use the default DataBase persistence, **MySQL** can be used.

- Create a table in your Database with required columns

  - id varchar(10)

  - user_name varchar(255)

  - client_id varchar(255)

  - client_secret varchar(255)

  - refresh_token varchar(255)

  - access_token varchar(255)

  - grant_token varchar(255)

  - expiry_time varchar(20)

  - redirect_url varchar(255)

  - api_domain varchar(255)
  
Note:
- Custom database name and table name can be set in DBStore instance.

#### MySQL Query

```sql
CREATE DATABASE zohooauth;
CREATE TABLE oauthtoken (
  id varchar(10) NOT NULL,
  user_name varchar(255),
  client_id varchar(255),
  client_secret varchar(255),
  refresh_token varchar(255),
  access_token varchar(255),
  grant_token varchar(255),
  expiry_time varchar(20),
  redirect_url varchar(255),
  api_domain varchar(255),
  primary key (id)
);
```

#### Create DBStore object

```scala
/*
* 1 -> DataBase host name. Default value "localhost"
* 2 -> DataBase name. Default  value "zohooauth"
* 3 -> DataBase user name. Default value "root"
* 4 -> DataBase password. Default value ""
* 5 -> DataBase port number. Default value "3306"
*/
//TokenStore interface
val tokenstore = new DBStore.Builder()
.host("hostName")
.databaseName("dataBaseName")
.tableName("tableName")
.userName("userName")
.password("password")
.portNumber("portNumber")
.build
```

### File Persistence

In case of default File Persistence, the user can persist tokens in the local drive, by providing the the absolute file path to the FileStore object.

- The File contains

  - id

  - user_name

  - client_id

  - client_secret

  - refresh_token

  - access_token

  - grant_token

  - expiry_time

  - redirect_url

  - api_domain

#### Create FileStore object

```scala
import com.zoho.api.authenticator.store.FileStore

//Parameter containing the absolute file path to store tokens
var  tokenstore = new FileStore("./scala_sdk_token.txt")
```

### Custom Persistence

Users can create their own logic for storing and retrieving authentication tokens using the custom persistence technique. To use Custom Persistence, you must implement **TokenStore interface**(**com.zoho.api.authenticator.store.TokenStore**) and override the methods.

```scala
import com.zoho.api.authenticator.Token
import com.zoho.api.authenticator.store.TokenStore
import com.zoho.crm.api.exception.SDKException

import scala.collection.mutable.ArrayBuffer

class CustomeStore extends TokenStore {

  @throws[SDKException]
  override def findToken(token: Token): Token = { null }

  @throws[SDKException]
  override def saveToken(token: Token): Unit = { }

  @throws[SDKException]
  override def deleteToken(id: String): Unit = { }

  @throws[SDKException]
  override def getTokens: ArrayBuffer[Token] = { null }

  @throws[SDKException]
  override def deleteTokens(): Unit = { }

  @throws[SDKException]
  override def findTokenById(id: String): Token = { null }
}
```

## Configuration

Before you get started with creating your Scala application, you need to register your client and authenticate the app with Zoho.

| Mandatory Keys    | Optional Keys |
| :---------------- | :------------ |
| environment       | logger        |
| token             | store         |
|                   | SDKConfig     |
|                   | resourcePath  |
-----

The **environment** key contains the domain information to make API calls. The **token** key represents the OAuth info, including the clientID, clientSecret, grantToken, redirectURL, refreshToken or accessToken depending on the flow that you use. Refer to ##create an instance of OAuthToken## for more details.

- Configure the API environment which decides the domain and the URL to make API calls.

    ```scala
    /*
        * Configure the environment
        * which is of the pattern Domain.Environment
        * Available Domains: USDataCenter, EUDataCenter, INDataCenter, CNDataCenter, AUDataCenter,JPDataCenter
        * Available Environments: PRODUCTION, DEVELOPER, SANDBOX
    */
    val env = USDataCenter.PRODUCTION
    ```

- Create an instance of **OAuthToken** with the information that you get after registering your Zoho client. In the context of token persistence, the grant token flow and refresh token flow involve storing and persisting the token. However, the access token flow does not involve token persistence and the access token is directly utilized for API calls. Depending on the tokens available with you, choose grantToken flow, refreshToken flow or accessToken flow.  
  - By default, the findUser key is set to true, to set userSignature. However, this requires the ***ZohoCRM.users.READ*** and ***ZohoCRM.org.READ*** scopes to be mandatory. If you do not want to set userSignature, you must set the findUser key to false.

  - Use the following method for **grantToken flow :**
    ```scala
      // if grant token is available
      var token = new OAuthToken.Builder()
      .clientID("clientId")
      .clientSecret("clientSecret")
      .grantToken("grantToken")
      .redirectURL("redirectURL")
      .findUser(false)// by default true
      .build()
    ```

    - Use the following method for **refreshToken flow :**
    ```scala
      var token = new OAuthToken.Builder()
      .clientID("clientId")
      .clientSecret("clientSecret")
      .refreshToken("refreshToken")
      .findUser(false)// by default true
      .build()
    ```

    - Use the following method for **accessToken flow :**
    ```scala
      var token = new OAuthToken.Builder()
      .accessToken("accessToken")
      .findUser(false)// by default true
      .build()
    ```

    - Use the following method for **Id flow :**
    ```scala
      var token = new OAuthToken.Builder()
      .id("id")
      .build()
    ```

- Create an instance of **Logger** Class to log exception and API information.

    ```scala
    
      import com.zoho.api.logger.Logger
      import com.zoho.api.logger.Logger.Levels
    /*
      * Create an instance of Logger Class that takes two parameters
      * level -> Level of the log messages to be logged. Can be configured by typing Levels "." and choose any level from the list displayed.
      * filePath -> Absolute file path, where messages need to be logged.
    */
    var logger = new Logger.Builder()
    .level(Logger.Levels.ALL)
    .filePath("./scala_sdk_log.log")
    .build
    ```

- Create an instance of **TokenStore** to persist tokens, used for authenticating all the requests. By default, the SDK creates the sdk_tokens.txt file in the project folder to persist the tokens.

  - Use the following method for DB Store
  ```scala
    /*
    * Create an instance of DBStore that requires the following
    * host -> DataBase host name. Default value "localhost"
    * databaseName -> DataBase name. Default  value "zohooauth"
    * userName -> DataBase user name. Default value "root"
    * password -> DataBase password. Default value ""
    * portNumber -> DataBase port number. Default value "3306"
    * tabletName -> DataBase table name. Default value "oauthtoken"
    */
    //var tokenstore = new DBStore.Builder().build

    var tokenstore = new DBStore.Builder()
    .host("hostName")
    .databaseName("databaseName")
    .tableName("tableName")
    .userName("userName")
    .password("password")
    .portNumber("portNumber")
    .build
  ```

  - Use the following method for File Store
  ```scala
    var tokenstore = new FileStore("./scala_sdk_token.txt")
  ```
  
  - Use the following method for Custom Store
  ```scala
    var tokenStore = new CustomStore()
  ```

- Create an instance of **SDKConfig** containing the SDK configuration.

    ```scala
    /*
    * autoRefreshFields
    * if true - all the modules' fields will be auto-refreshed in the background, every    hour.
    * if false - the fields will not be auto-refreshed in the background. The user can manually delete the file(s) or refresh the fields using methods from ModuleFieldsHandler(com.zoho.crm.api.util.ModuleFieldsHandler)
    *
    * pickListValidation
    * A boolean field that validates user input for a pick list field and allows or disallows the addition of a new value to the list.
    * True - the SDK validates the input. If the value does not exist in the pick list, the SDK throws an error.
    * False - the SDK does not validate the input and makes the API request with the user’s input to the pick list
    * 
    * connectionTimeout
    * A Integer field to set connection timeout 
    * 
    * requestTimeout
    * A Integer field to set request timeout 
    * 
    * socketTimeout
    * A Integer field to set socket timeout 
    */
    var sdkConfig = new SDKConfig.Builder().pickListValidation(false).autoRefreshFields(false).connectionTimeout(1000).requestTimeout(1000).socketTimeout(1000).build
    ```

- The path containing the absolute directory path to store user-specific files containing module fields information. By default, the SDK stores the user-specific files in a current working directory.

    ```scala
    var resourcePath = "./"
    ```

## Initializing the Application

Initialize the SDK using the following code.

```scala
import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.store.DBStore
import com.zoho.api.logger.Logger
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.{Initializer, SDKConfig}

object Initialize {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    initialize()
  }

  @throws[Exception]
  def initialize(): Unit = {
    val loggerInstance = new Logger.Builder().level(Logger.Levels.ALL).filePath("./scala_sdk_log.log").build
    val env = USDataCenter.PRODUCTION
    val token = new OAuthToken.Builder().clientID("clientId").clientSecret("clientSecret").refreshToken("refreshToken").build()
    val tokenstore = new DBStore.Builder().host(Option("hostName")).databaseName(Option("databaseName")).tableName(Option("tableName")).userName(Option("userName")).password(Option("password")).portNumber(Option("portNumber")).build
    val config: SDKConfig = new SDKConfig.Builder().pickListValidation(false).autoRefreshFields(false).build
    val resourcePath = "./"
    new Initializer.Builder().environment(env).token(token).store(tokenstore).SDKConfig(config).resourcePath(resourcePath).logger(loggerInstance).initialize()
  }
}
```

- You can now access the functionalities of the SDK. Refer to the sample codes to make various API calls through the SDK.

## Class Hierarchy

![classdiagram](class_hierarchy.png)

## Responses and Exceptions

All SDK method calls return an instance of the **APIResponse** class.

Use the **getObject()** method in the returned **APIResponse** object to obtain the response handler interface depending on the type of request (**GET, POST,PUT,DELETE**).

**APIResponse&lt;ResponseHandler&gt;** and **APIResponse&lt;ActionHandler&gt;** are the common wrapper objects for Zoho CRM APIs’ responses.

Whenever the API returns an error response, the response will be an instance of **APIException** class.

All other exceptions such as SDK anomalies and other unexpected behaviours are thrown under the **SDKException** class.

### GET Requests

- The **getObject()** of the returned APIResponse instance returns the response as follows.

- Most of the APIs follows the **Common** Structure as below.

  - The **ResponseHandler interface** encompasses the following
    - **ResponseWrapper class** (for **application/json** responses)
    - **FileBodyWrapper class** (for File download responses)
    - **APIException class**



- Some of the APIs follow the **Particular** Structure as below.

  - The **ResponseHandler interface** encompasses the following
    - **HistoryWrapper class** (for **application/json** responses in **backup** API, holds the list of instances of **History class** and instance of **Info class**)
    - **UrlsWrapper class** (for **application/json** responses in **backup** API, holds the instance of **Urls class**)
    - **SourcesCountWrapper class** (for **application/json** responses in **UserGroups** API, holds the List of instances of **SourceCount class**)
    - **SourcesWrapper class** (for **application/json** responses in **Usergroups** APi, holds the List of instances of **Sources class** and instance of **Info class**)


  - The **ResponseWrapper interface** in **BulkWrite** API encompasses the following
    - **BulkWriteResponse class** (for **application/json** responses)
    - **APIException class**

  - The **CountHandler interface** encompasses the following
    - **CountWrapper class** (for **application/json** responses in **Record** API, holds the Long **count**)
    - **APIException class**

  - The **DeletedRecordsHandler interface** encompasses the following
    - **DeletedRecordsWrapper class** (for **application/json** responses in **Record** API, holds the list of instances of **DeletedRecord class** and instance of **Info class**)
    - **APIException class**

  - The **DownloadHandler interface** encompasses the following
    - **FileBodyWrapper class** (for File download responses)
    - **APIException class**

  - The **MassUpdateResponseHandler interface** encompasses the following
    - **MassUpdateResponseWrapper class** (for **application/json** responses in **Record** API, holds the list of instances of **MassUpdateResponse interface**)
    - **APIException class**

  - The **MassUpdateResponse interface** encompasses of following
    - **MassUpdate class** (for **application/json** responses)
    - **APIException class**

  - The **ValidationHandler interface** in **UserTerritories** API encomposses the following
    - **ValidationWrapper class** (for **application/json** responses, holds the list of instances of **ValidationGroup interface**)
    - **APIException class**

  - The **ValidationGroup interface** in **UserTerritories** API encompasses the following
    - **Validation class**
    - **BulkValidation class**

### POST, PUT, DELETE Requests

- The **getObject()** of the returned APIResponse instance returns the response as follows.

- Most of the APIs follows the **Common** Structure as.

  - The **ActionHandler interface** encompasses the following
    - **ActionWrapper class** (for **application/json** responses)
    - **APIException class**

  - The **ActionWrapper class** contains **Property/Properties** that may contain one/list of **ActionResponse interfaces**.

  - The **ActionResponse interface** encompasses the following
    - **SuccessResponse class** (for **application/json** responses)
    - **APIException class**

- Some of the APIs follow the **Particular** Structure as.

  - The **ActionHandler interface** encompasses the following
    - **ActionWrapper class** (for **application/json** responses)
    - **APIException class**

  - The **ActionWrapper class** contains **Property/Properties** that may contain one/list of **ActionResponse interface**.

  - The **RecordActionHandler interface** encompasses the following
    - **RecordActionWrapper class** (for **application/json** responses in **Tags** API, holds the list of instance of **RecordActionResponse interface**, Boolean **wfScheduler**, String **successCount** and Boolean **lockedCount**)
    - **APIException class**

  - **RecordActionResponse interface** encompasses the following
    - **RecordSuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **ActionHandler interface** in **Currencies** API encompasses the following
    - **BaseCurrencyActionWrapper class** (for **application/json** responses)
    - **APIException class**

  - The **BaseCurrencyActionWrapper class** contains **Property/Properties** that contain **BaseCurrencyActionResponse interface**.

  - The **BaseCurrencyActionResponse interface** encompasses the following
    - **SuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **MassUpdateActionHandler interface** encompasses the following
    - **MassUpdateActionWrapper class** (for **application/json** responses in **Record** API, holds the list of instances of **MassUpdateActionResponse interface**)
    - **APIException class**

  - The **MassUpdateActionResponse interface** encompasses of following
    - **MassUpdateSuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **FileHandler interface** in **Record** API encompasses the following
    - **SuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **SignActionHandler interface** in **MailMerge** API encompasses the following
    - **SignActionWrapper class** (for **application/json** responses)
    - **APIException class**
    
  - The **DeleteActionHandler interface** encompasses the following
    - **DeleteActionWrapper class** (for **application/json** responses in **ShareRecords** API, holds the instance of **DeleteActionResponse interface**)
    - **APIException class**
    
  - The **DeleteActionResponse interface** encompasses the following
    - **SuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **TransferActionHandler interface** in **UserTerritories** API encompasses the following
    - **TransferActionWrapper class** (fro **application/json** responses , holds the list of instances of **TransferActionResponse interface**)

  - The **TransferActionResponse interface** encompasses the following
    - **SuccessResponse class** (for **application/json** responses)
    - **APIException class**

  - The **ActionResponse interface** in **Territories** API encompasses the following
    - **Success class** (for **application/json** responses)
    - **APIException class**

  - The **TransferPipelineActionHandler interface** in **Pipeline** API encompasses the following
    - **TransferPipelineActionWrapper class** (for **application/json** responses, holds the list of insatnces of **TransferPipelineActionResponse interface**)
    - **APIException class**

  - The **TransferPipelineActionResponse interface** in **Pipeline** API encompasses the following
    - **TransferPipelineSuccessResponse class** (for **application/json** responses)
    - **APIException class**

## Threading in the scala SDK

Threads in a Scala program help you achieve parallelism. By using multiple threads, you can make a scala program run faster and do multiple things simultaneously.

The **Scala SDK** supports both single-threading and multi-threading irrespective of a single-user or a multi-user app.

### Multithreading in a Multi-user App

Multi-threading for multi-users is achieved using Initializer's static **switchUser()**.

```scala
new Initializer.Builder()
  .environment(environment)
  .token(token)
  .SDKConfig(sdkConfig)
  .switchUser()
```

Here is a sample code to depict multi-threading for a multi-user app.

```scala
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.api.authenticator.store.FileStore
import com.zoho.api.logger.Logger
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.record.RecordOperations
import com.zoho.crm.api.record.RecordOperations.GetRecordsParam
import com.zoho.crm.api.{Initializer, ParameterMap, SDKConfig}

object MultiThread {
  @throws[SDKException]
  def main(args: Array[String]): Unit = {
    val loggerInstance = new Logger.Builder().level(Logger.Levels.ALL).filePath("./scala-sdk-logs.log").build
    val env = USDataCenter.PRODUCTION
    val tokenstore = new FileStore("./scala_sdk_token.txt")
    val token1 = new OAuthToken.Builder().clientID("clientID").clientSecret("xxxxx").refreshToken("refreshToken").build()
    val resourcePath = "./"
    val user1Config = new SDKConfig.Builder().autoRefreshFields(false).pickListValidation(true).build
    new Initializer.Builder().environment(env).token(token1).store(tokenstore).SDKConfig(user1Config).resourcePath(resourcePath).logger(loggerInstance).initialize()
    var multiThread = new MultiThread(env, token1, "Deals", user1Config)
    multiThread.start()
    val environment = USDataCenter.PRODUCTION
    val resourcePath = "./"
    val token2 = new OAuthToken.Builder().clientID("clientID").clientSecret("xxxxx").refreshToken("refreshToken").build()
    val user2Config = new SDKConfig.Builder().autoRefreshFields(true).pickListValidation(false).build
    multiThread = new MultiThread(environment, token2, "Leads", user2Config)
    multiThread.start()
  }
}

class MultiThread(var environment: DataCenter.Environment, var token: Token, var moduleAPIName: String, var sdkConfig: SDKConfig) extends Thread {
  override def run(): Unit = {
    try {
      new Initializer.Builder().environment(environment).token(token).SDKConfig(sdkConfig).switchUser()
      val cro = new RecordOperations(this.moduleAPIName)
      val paramInstance = new ParameterMap
      val fieldNames = List("Company", "Email")
      paramInstance.add(new GetRecordsParam().fields, fieldNames.mkString(","))
      val getResponse = cro.getRecords(None, None)
      println(getResponse.get.getObject)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
```

- The program execution starts from main().

- The details of **"user1"** are given in the variables user1, token1, environment1.

- Similarly, the details of another user **"user2"** are given in the variables user2, token2, environment2.

- For each user, an instance of **MultiThread class** is created.

- When **start()** is called which in-turn invokes the **run()**,  the details of user1 are passed to the **switchUser** function through the **MultiThread object**. Therefore, this creates a thread for user1.

- Similarly, When the **start()** is invoked again,  the details of user2 are passed to the switchUser function through the **MultiThread object**. Therefore, this creates a thread for user2.

### Multi-threading in a Single User App

```scala
import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.store.FileStore
import com.zoho.crm.api.{Initializer, ParameterMap, SDKConfig}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.api.logger.Logger
import com.zoho.crm.api.record.RecordOperations
import com.zoho.crm.api.record.RecordOperations.GetRecordsParam

object MultiThread {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val loggerInstance = new Logger.Builder().level(Logger.Levels.ALL).filePath("./scala-sdk-logs.log").build
    val env = USDataCenter.PRODUCTION
    val tokenstore = new FileStore("./scala_sdk_token.txt")
    val token = new OAuthToken.Builder().clientID("clientID").clientSecret("xxxxx").refreshToken("refreshToken").build()
    val resourcePath = "./"
    val sdkConfig = new SDKConfig.Builder().autoRefreshFields(false).pickListValidation(true).build
    new Initializer.Builder().environment(env).token(token).store(tokenstore).SDKConfig(sdkConfig).resourcePath(resourcePath).logger(loggerInstance).initialize()
    var mtsu = new MultiThread("Deals")
    mtsu.start()
    mtsu = new MultiThread("Leads")
    mtsu.start()
  }
}

class MultiThread(var moduleAPIName: String) extends Thread {
  override def run(): Unit = {
    try {
      val cro = new RecordOperations(this.moduleAPIName)
      val paramInstance = new ParameterMap
      val fieldNames = List("Company", "Email")
      paramInstance.add(new GetRecordsParam().fields, fieldNames.mkString(","))
      @SuppressWarnings(Array("rawtypes")) val getResponse = cro.getRecords(Option(paramInstance), None)
      println(getResponse.get.getObject)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
```

- The program execution starts from **main()** where the SDK is initialized with the details of user and an instance of **MultiThread class** is created .

- When the **start()** is called which in-turn invokes the **run()**,  the moduleAPIName is switched through the **MultiThread** object. Therefore, this creates a thread for the particular **MultiThread** instance.

- The **MultiThread** object is reinitialized with a different moduleAPIName.

- Similarly, When the **start()** is invoked again,  the moduleAPIName is switched through the **MultiThread** object. Therefore, this creates a thread for the particular **MultiThread** instance.

## SDK Sample code

```scala
import com.zoho.api.authenticator.OAuthToken
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.record._
import com.zoho.crm.api.tags.Tag
import com.zoho.crm.api.{HeaderMap, Initializer}
import scala.collection.mutable.ArrayBuffer

object CreateRecord {
  @throws[SDKException]
  def main(args: Array[String]): Unit = {
    val environment = USDataCenter.PRODUCTION
    val token = new OAuthToken.Builder().clientID("Client ID").clientSecret("Client Secret").refreshToken("Refresh Token").build()
    new Initializer.Builder().environment(environment).token(token).initialize()
    val recordOperations = new RecordOperations("Leads")
    val bodyWrapper = new BodyWrapper
    val record1 = new Record
    record1.addFieldValue(new Field.Leads().City, "City")
    record1.addFieldValue(new Field.Leads().LastName, "Last Name")
    record1.addFieldValue(new Field.Leads().FirstName, "First Name")
    record1.addFieldValue(new Field.Leads().Company, "Zoho")
    val tag = new Tag
    tag.setName(Option("Testtask"))
    record1.setTag(ArrayBuffer[Tag](tag))
    bodyWrapper.setData(ArrayBuffer[Record](record1))
    val headerInstance = new HeaderMap
    val responseOption = recordOperations.createRecords(bodyWrapper, Option(headerInstance))
    if (responseOption.isDefined) {
      val response = responseOption.get
      println("Status Code: " + response.getStatusCode)
      if (response.isExpected) {
        val actionHandler = response.getObject
        actionHandler match {
          case actionWrapper: ActionWrapper =>
            val actionResponses = actionWrapper.getData()
            for (actionResponse <- actionResponses) {
              actionResponse match {
                case successResponse: SuccessResponse =>
                  println("Status: " + successResponse.getStatus().getValue)
                  println("Code: " + successResponse.getCode().getValue)
                  println("Details: ")
                  successResponse.getDetails().foreach(entry => { println(entry._1 + ": " + entry._2) })
                  println("Message: " + successResponse.getMessage().getValue)
                case exception: APIException =>
                  println("Status: " + exception.getStatus().getValue)
                  println("Code: " + exception.getCode().getValue)
                  println("Details: ")
                  exception.getDetails().foreach(entry => { println(entry._1 + ": " + entry._2) })
                  println("Message: " + exception.getMessage().getValue)
                case _ =>
              }
            }
          case exception: APIException =>
            println("Status: " + exception.getStatus().getValue)
            println("Code: " + exception.getCode().getValue)
            println("Details: ")
            exception.getDetails().foreach(entry => { println(entry._1 + ": " + entry._2) })
            println("Message: " + exception.getMessage().getValue)
          case _ =>
        }
      }
      else {
        val responseObject = response.getModel
        val clas = responseObject.getClass
        val fields = clas.getDeclaredFields
        for (field <- fields) { println(field.getName + ":" + field.get(responseObject)) }
      }
    }
  }
}

class CreateRecord {}
```
