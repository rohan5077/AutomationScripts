Set objShell = CreateObject("WScript.Shell")
Set objEnv = objShell.Environment("SYSTEM")
 
objEnv("test") = "Hello World!"