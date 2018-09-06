folderPath = "c:/users/rohans/desktop/folderCreate"

set fso = CreateObject("Scripting.FileSystemObject")

if fso.folderExists(folderPath) = false then
	fso.CreateFolder(folderPath)
else 
	msgbox "folder is already exist!"
end if

set tfile = fso.CreateTextFile(folderPath & "/newFile.txt")
	
tfile.Write "Hi, This is written in vbscript! Thank YOu"

tfile.close

set tfileRead = fso.OpenTextFile(folderPath & "/newFile.txt")

do until tfileRead.AtEndOfStream
	txt = tfileRead.readline
	msgbox txt
loop