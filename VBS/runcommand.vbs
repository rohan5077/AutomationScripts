option Explicit
dim obj

Set obj = CreateObject("wscript.shell")

obj.run "E:\Rohan\QA"
obj.run "ping 192.168.1.189"
obj.run "explorer.exe Shell:::{2559a1f3-21d7-11d4-bdaf-00c04f60b9f0}"