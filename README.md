# Bitmasks utils for Java
![Maven Central](https://img.shields.io/badge/Maven%20Central-0.0.1-blue?style=flat)
![License](https://img.shields.io/badge/License-MIT%20License-green?style=flat)
![Status](https://img.shields.io/badge/Status-Active-lime?style=flat)

Utilities for working with bitmasks in Java. The minimum supported version of JDK is 1.8.

## Prerequisites
While working on a few libraries for my pet projects, I needed to develop additional supporting libs - including a library that would allow me to work with bitmask generation.

At the moment, the library supports only the generation of the simplest bitmasks, but the functionality will development as needed and community requests.

## Usage

> **Note**
> 
> The library uses local terms such as `TYPE_BACKWARD` and `TYPE_FORWARD` bitmask types. The backward type is characterized by the fact that the offset of the high bits is counted from the right, and for forward, the offset is counted from the left.

##### Example 1. Generate a simple backward bitmask.

```java
import com.sloppydobby.java.bitmask.BitmaskUtils;

public class MyClass {
    
    public void myMethod() {
        // Generate a simple backward bitmask without offset with 2 high bits
        BitmaskUtils.generateBackwardBitmask(2, 0); // 0b11
        
        // Generate a simple backward bitmask with 2 high bits and offset for 2 bits
        BitmaskUtils.generateBackwardBitmask(2, 2); // 0b1100
    }
    
}
```

##### Example 2. Generate a simple forward bitmask.

```java
import com.sloppydobby.java.bitmask.BitmaskUtils;

public class MyClass {
    
    public void myMethod() {
        // Generate a simple forward 16-bit bitmask without offset with 4 high bits
        BitmaskUtils.generateForwardBitmask(16, 4, 0); // 0b1111_0000_0000_0000
        
        // Generate a simple forward 16-bit bitmask with 4 high bits and 4 bits offset
        BitmaskUtils.generateForwardBitmask(16, 4, 4); // 0b0000_1111_0000_0000 or 0b1111_0000_0000
    }
    
}
```

##### Example 3. Generate a simple bitmask by given type parameter.

```java
import com.sloppydobby.java.bitmask.BitmaskUtils;

public class MyClass {
    
    public void myMethod() {
        // Generate a simple backward bitmask with 2 high bits without offset
        BitmaskUtils.generateBitmask(2, 2, 0, BitmaskUtils.TYPE_BACKWARD); // 0b11
        
        // Generate a simple backward bitmask with 2 high bits and 2 offset bits
        BitmaskUtils.generateBitmask(4, 2, 2, BitmaskUtils.TYPE_BACKWARD); // 0b1100
        
        // Generate a simple forward 16-bit bitmask with 4 high bits without offset
        BitmaskUtils.generateBitmask(16, 4, 0, BitmaskUtils.TYPE_FORWARD); // 0b1111_0000_0000_0000
        
        // Generate a simple forward 16-bit bitmask with 4 high bits and 4 offset bits
        BitmaskUtils.generateBitmask(16, 4, 4, BitmaskUtils.TYPE_FORWARD); // 0b0000_1111_0000_0000 or 0b1111_0000_0000
    }
    
}
```

## Maven
If you are using the Maven build system, then you can add the library to your project by adding dependency in to target module `pom.xml` file:

```xml
<dependency>
    <groupId>com.sloppydobby</groupId>
    <artifactId>java-bitmask-utils</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Gradle
If you are using the Gradle build system, then you can add the library to your project by adding dependency in to target module `build.gradle` file:

```groovy
implementation 'com.sloppydobby:java-bitmask-utils:0.0.1'
```

## Build
If for some reasons you can't add the library to your project as Maven Central dependency, you can build the library manually by following commamd:

```bash
mvn clean package
```
