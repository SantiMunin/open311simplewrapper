open311simplewrapper
====================

This is an example of a possible GSoC project related to the [Open311 API](http://open311.org/).

It contains a basic functionallity which allows the wrapper user to get services from a city he wants.

Configuration
-------------

In order to test this project you should have [Maven](http://maven.apache.org/) installed in your system. You can find it in any repository you use (brew, apt...).

**IMPORTANT**: Before you start using the library you need to add some certificates to your java keystore (those certificates are in `/certificates`). Your keystore probably is in `$JAVA_HOME/lib/security/cacerts` or `$JAVA_HOME/jre/lib/security/cacerts`.

```bash

sudo sh add_certificates.sh <path/to/your/key/store>

``` 

```bash

# Compile the project (and download dependencies)
mvn compile

# Execute tests
mvn test
```

Usage
--------------

If you compile the project you will find the .jar in `/target/jreport-*.jar`. Just import it in your application and start hacking!

To start using the library you need to use is the `Jreport` class.
```java

// Get the JReport single instance
JReport jreport = JReport.getInstance();

// Get all supported cities (this will return a String[] containing {"San Francisco, CA", "Chicago, IL, ..."})
jreport.getCities();

// Get a city wrapper
JWrapper sfWrapper = jreport.getCityWrapper(City.SAN_FRANCISCO);

// Get a list of services
List<Service> sfWrapper.getServices();
```

**IMPORTANT**: This is just a quick approach to the problem, the whole idea can be found [here](https://gist.github.com/SantiMunin/5484519). 