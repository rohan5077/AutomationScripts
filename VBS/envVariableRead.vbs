Set objShell = CreateObject("WScript.Shell")
Set objEnv = objShell.Environment("SYSTEM")
 
wscript.echo objEnv("test")