@echo off
del docs\* /f /q
"C:\Program Files\Java\jdk1.7.0_45\bin\javadoc.exe" -d docs -windowtitle utilx -version -author -footer "<link rel='stylesheet' href='/utilx/assets/css/docs.css' type='text/css'><script src='//ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.3.min.js'></script><script src='/utilx/assets/js/docs.js'></script>" src/*.java src/sql/*.java src/cli/*.java src/forms/*.java
@pause