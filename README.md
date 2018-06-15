# Apache Felix Tutorials

An implementation of [Apache Felix tutorials](http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-osgi-tutorial.html).

It has been updated to include Maven based projects for each of the samples.

**Note** that Example 8 doesn't currently work with Maven after trying to bring it up to speed.

Tested with JDK 8 b144 and Felix framework 5.4.0

Once compiled, you can use start.bat to begin Felix and pass any parameters necessary.

## Manual Build ##

The build.bat file should perform all the builds required.  It requires that `javac` be on the PATH, and that `FELIX_HOME' has been set correctly.

Bundles can be installed by these commands once running Felix:
```
install file:/D:/tutorial/mavenised/local-maven-repo/org/apache/felix/org.apache.felix.servicebinder/0.9.0-SNAPSHOT/org.apache.felix.servicebinder-0.9.0-SNAPSHOT.jar
install file:/D:/tutorial/manual/build/example1.jar
install file:/D:/tutorial/manual/build/example2.jar
install file:/D:/tutorial/manual/build/example2b.jar
install file:/D:/tutorial/manual/build/example3.jar
install file:/D:/tutorial/manual/build/example4.jar
install file:/D:/tutorial/manual/build/example5.jar
install file:/D:/tutorial/manual/build/example6.jar
install file:/D:/tutorial/manual/build/example7.jar
install file:/D:/tutorial/manual/build/example8.jar
```


## Maven Build ##

You should be able to execute this with a pure 'mvn clean verify'

Bundles can be installed by these commands once running Felix:
```
install file:/D:/tutorial/mavenised/example1/target/example1-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example2/target/example2-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example2b/target/example2b-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example2.service/target/example2.service-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example3/target/example3-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example4/target/example4-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example5/target/example5-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example6/target/example6-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example6.service/target/example6.service-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example7/target/example7-1.0-SNAPSHOT.jar
install file:/D:/tutorial/mavenised/example9/target/example9-1.0-SNAPSHOT.jar
```
