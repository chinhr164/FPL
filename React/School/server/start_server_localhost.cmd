@echo off
set /P file=Enter file: 
start  json-server -w %file%.json