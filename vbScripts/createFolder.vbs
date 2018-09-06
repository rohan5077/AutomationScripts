Set file = CreateObject("Scripting.FileSystemObject")

	folderName = "c:\users\rohans\desktop\folder_create"
	
if file.FolderExists(folderName) = false then
	file.CreateFolder(folderName)
else
	msgbox "Folder is already exists!"
end if

	Set tfile = file.CreateTextFile("c:\users\rohans\desktop\folder_create\newTextFile.txt",true)
	
	tfile.Write "Hi, This is written by vbScript"
	tfile.close

set file = nothing
set tfile = nothing
