@echo off
pushD %FELIX_HOME%
echo java -jar %FELIX_HOME%\bin\felix.jar %*
java -jar %FELIX_HOME%\bin\felix.jar %*
popD