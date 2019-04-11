[Run](#run) | [Generate AES-256 Key](#generate) | [Split AES-256 Key](#split) | [Merge AES-256 Keys](#merge)

Overview:
===================
This is a sample utility to split/merge 3 AES-256 keys.

**NOTE:** This example is built using **JDK7**, ultimate strength JCE (JDK7) and [Maven 3.x](http://maven.apache.org "Maven Documentation")

 - [Unlimited Strength Policy JDK7](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html "Unlimited Strength Policy for JDK7")
 - JDK must have the unlimited strength policy for the JDK version


<a name="run"></a>To Run:
====================

    mvn clean test

[Run](#run) | [Generate AES-256 Key](#generate) | [Split AES-256 Key](#split) | [Merge AES-256 Keys](#merge)

<a name="generate"></a>Generate an AES-256 Key
======================

	mvn clean package // generate executable JAR file
    java -jar key-split-merge-util.jar generateKey
    // or optionally with Maven (using the above defaults)
    mvn exec:java

[Run](#run) | [Generate AES-256 Key](#generate) | [Split AES-256 Key](#split) | [Merge AES-256 Keys](#merge)

<a name="split"></a>Split AES-256 Key from command line to create 3 keys
======================

    mvn clean package // generate executable JAR file
    java -jar key-split-merge-util.jar splitKey <hex AES-256 key>
    // or optionally with Maven (using the above defaults)
    mvn exec:java
    
[Run](#run) | [Generate AES-256 Key](#generate) | [Split AES-256 Key](#split) | [Merge AES-256 Keys](#merge)

<a name="merge"></a>Merge 3 AES-256 Key from command line
======================

    mvn clean package // generate executable JAR file
    java -jar key-split-merge-util.jar mergeKeys <hex AES-256 key1> <hex AES-256 key2> <hex AES-256 key3> 
    // or optionally with Maven (using the above defaults)
    mvn exec:java

[Run](#run) | [Generate AES-256 Key](#generate) | [Split AES-256 Key](#split) | [Merge AES-256 Keys](#merge)

Copywrite &copy;2019 - Use of this code and it's concepts are considered a Proof-of-concept and should not be used directly in any environment
