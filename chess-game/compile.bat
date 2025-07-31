@echo off
echo Compiling Chess Game...

:: Create build folder if it doesn't exist
if not exist build mkdir build

:: Compile all source files
g++ -std=c++17 -Iinclude src\*.cpp -o build\chess.exe

if %errorlevel%==0 (
    echo Compilation successful.
) else (
    echo Compilation failed.
)

pause