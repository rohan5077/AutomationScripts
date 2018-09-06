option Explicit
dim obj
dim a

Set obj = CreateObject("wscript.shell")

obj.run "explorer.exe Shell:::{2559a1f3-21d7-11d4-bdaf-00c04f60b9f0}"
wscript.sleep 1000
obj.sendkeys"\\192.168.1.173"
obj.sendkeys"{enter}"
wscript.sleep 2000
do until a=4
	a=a+1
	obj.sendkeys"{right}"
loop
obj.sendkeys"{enter}"