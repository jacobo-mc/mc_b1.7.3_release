@echo off

if exist "runtime/command" (
    set /p command=< runtime\command
) else (
    set command=runtime\bin\python\python
)

"%command%" runtime\updatemd5.py %*
pause
