@echo off
set VERSION=1.3.0
set MODPATH=C:\Users\Olive\Downloads\forge-1.20.1-47.4.0-mdk
set SERVERPATH=C:\Users\Olive\Downloads\forge-1.20.1-47.4.0-mdk\run\mods
set MODRINTHPATH=C:\Users\Olive\AppData\Roaming\ModrinthApp\profiles\Forge 1.20.1 testing\mods

cd %MODRINTHPATH%
del createindestructible-*.jar
mklink "createindestructible-%VERSION%.jar" "%MODPATH%\build\libs\createindestructible-%VERSION%.jar"
cd %SERVERPATH%
del createindestructible-*.jar
mklink "createindestructible-%VERSION%.jar" "%MODPATH%\build\libs\createindestructible-%VERSION%.jar"
pause