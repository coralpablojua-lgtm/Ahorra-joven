@echo off
setlocal
title Ahorra Joven - Spring Boot API
cd /d "%~dp0demo"
where java >nul 2>nul
if errorlevel 1 (echo ERROR: Instala Java JDK 17 o superior. & pause & exit /b 1)
echo Iniciando Ahorra Joven...
start "" cmd /c "timeout /t 12 /nobreak >nul & start http://localhost:8080"
call mvnw.cmd spring-boot:run
if errorlevel 1 (echo No se pudo iniciar. Revisa Java, internet y el puerto 8080. & pause)
endlocal
