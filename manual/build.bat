@echo off
mkdir build 2> NUL

echo Building Example 1...
javac -cp %FELIX_HOME%\bin\felix.jar -d build src\tutorial\example1\Activator.java
jar cfm build\example1.jar src\tutorial\example1\manifest.mf -C build tutorial\example1\Activator.class

echo Building Example 2...
javac -cp %FELIX_HOME%\bin\felix.jar -d build src\tutorial\example2\Activator.java src\tutorial\example2\DictionaryImpl.java src\tutorial\example2\service\DictionaryService.java
jar cfm build\example2.jar src\tutorial\example2\manifest.mf -C build tutorial\example2\

echo Building Example 2b...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example2.jar -d build src\tutorial\example2b\Activator.java src\tutorial\example2b\DictionaryImpl.java
jar cfm build\example2b.jar src\tutorial\example2b\manifest.mf -C build tutorial\example2b\

echo Building Example 3...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example2.jar -d build src\tutorial\example3\Activator.java
jar cfm build\example3.jar src\tutorial\example3\manifest.mf -C build tutorial\example3\

echo Building Example 4...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example2.jar -d build src\tutorial\example4\Activator.java
jar cfm build\example4.jar src\tutorial\example4\manifest.mf -C build tutorial\example4\

echo Building Example 5...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example2.jar -d build src\tutorial\example5\Activator.java
jar cfm build\example5.jar src\tutorial\example5\manifest.mf -C build tutorial\example5\

echo Building Example 6...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example2.jar -d build src\tutorial\example6\Activator.java src\tutorial\example6\service\SpellChecker.java
jar cfm build\example6.jar src\tutorial\example6\manifest.mf -C build tutorial\example6\

echo Building Example 7...
javac -cp %FELIX_HOME%\bin\felix.jar;build\example6.jar -d build src\tutorial\example7\Activator.java
jar cfm build\example7.jar src\tutorial\example7\manifest.mf -C build tutorial\example7\

echo Building Example 8...
javac -cp %FELIX_HOME%\bin\felix.jar;..\mavenised\local-maven-repo\org\apache\felix\org.apache.felix.servicebinder\0.9.0-SNAPSHOT\org.apache.felix.servicebinder-0.9.0-SNAPSHOT.jar;build\example2.jar;build\example6.jar -d build src\tutorial\example8\Activator.java src\tutorial\example8\SpellCheckerImpl.java
copy src\tutorial\example8\metadata.xml build\tutorial\example8
jar cfm build\example8.jar src\tutorial\example8\manifest.mf -C build tutorial\example8\
