@echo off
javac -Xlint:unchecked src/*.java src/sql/*.java
if not exist build/utilx mkdir build/utilx
xcopy /Q /E /Y src\*.class build\utilx\
jar cvf utilx.jar -C build/ .
@pause