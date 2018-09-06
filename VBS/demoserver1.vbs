option Explicit
dim obj, fso
dim a

Set obj = CreateObject("wscript.shell")
Set fso = CreateObject(Scripting.FileSystemObject)

obj.run "explorer.exe Shell:::{2559a1f3-21d7-11d4-bdaf-00c04f60b9f0}"
wscript.sleep 1000
obj.sendkeys"\\192.168.1.195\rohan"
obj.sendkeys"{enter}"

fso.CopyFolder 

