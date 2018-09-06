option explicit
dim source, mycom, destination, fso, wsnet, dtmValue, strDate, strTime, objShell

dtmValue = Now()
	strDate = "DosePacker_" & Month(dtmValue) & "_" & Day(dtmValue) & "_" & Year(dtmValue)
	strTime = strDate & "__" & Hour(dtmValue) & "-" & Minute(dtmValue) & "-" & Second(dtmValue)

source = "\\192.168.1.128\zip2"
mycom = "c:\users\rohans\desktop\Python"

set fso = CreateObject("Scripting.FileSystemObject")
Set objShell = WScript.CreateObject( "WScript.Shell" )

if not fso.FolderExists(source) then
	msgbox "Folder is not shared."
else
	if not fso.FolderExists(mycom) then
		msgbox "Creating a folder named 'Python'"
		fso.CreateFolder(mycom)
	else 
		if fso.FolderExists(mycom & "\server demo") then
			fso.DeleteFolder(mycom & "\server demo")
		end if 
		msgbox "File is being transferred..."
	end if
	
	msgbox "Folder is copying..."
	fso.CopyFolder source & "\backup" , mycom & "\server demo" , True
	
end if





