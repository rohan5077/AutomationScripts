option explicit
dim file

Set file = CreateObject("Scripting.FileSystemObject")

if file.FileExists("\\192.168.1.173\zip") then
	wscript.echo "file exists"
else 
	wscript.echo "file does not exist"
end if