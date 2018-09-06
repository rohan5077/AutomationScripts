option explicit
dim source, mycom, fso, version, source_ver1, source_ver2, source_ver3

version = "2.1.1"


source = "\\192.168.1.128\zip2"
mycom = "c:\users\rohans\desktop\Python"

set fso = CreateObject("Scripting.FileSystemObject")

if not fso.FolderExists(source) then
	msgbox "Folder is not shared."
else
	if not fso.FolderExists(mycom) then
		msgbox "Creating a folder named 'Python'"
		fso.CreateFolder(mycom)
	else 
		if fso.FolderExists(mycom & "\bb-slv-" & version) then
			msgbox "folder exists"
			source_ver1 = left(version, 1)
			source_ver2 = mid(version,3,1)
			source_ver3 = right(version,1)
			msgbox source_ver1
			msgbox source_ver2
			msgbox source_ver3
		else
			fso.CopyFolder source & "\bb-slv-*" , mycom
			msgbox "No Folder found named bb-slv in local directory "& vbNewLine & "Folder copied from network drive"
		end if
	end if


	'Wscript.Echo fso.GetFileVersion("c:\users\rohans\desktop\Python\file.txt")
	
	'msgbox "Folder is copying..."
	'fso.CopyFolder source & "\backup" , mycom & "\server demo" , True
end if






