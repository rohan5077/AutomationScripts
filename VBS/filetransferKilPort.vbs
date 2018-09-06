option explicit
dim source, destination, fso, wsnet

source = "c:\users\rohans\desktop\backup"
destination = "\\192.168.1.128\zip2"

set fso = CreateObject("Scripting.FileSystemObject")
set wsnet = CreateObject("WScript.Network")

if Not fso.FolderExists(destination) then
	fso.CreateFolder(destination)
else 
	msgbox "folder already exists"
end if 

fso.CopyFolder source, destination & "\"





