dim FileSys, source, destination, WSNet, theDate, theTime, computerName, pass, strDate, strTime

Set FileSys = CreateObject("Scripting.FileSystemObject")
Set WSNet = CreateObject("WScript.Network")

dtmValue = Now()
	strDate = "DosePacker_" & Month(dtmValue) & "_" & Day(dtmValue) & "_" & Year(dtmValue)
	strTime = strDate & "__" & Hour(dtmValue) & "-" & Minute(dtmValue) & "-" & Second(dtmValue)

source = "C:\Users\rohans\Desktop\Backup"
destination = "\\192.168.1.173\zip2"
new_folder = "\\192.168.1.173\zip2\Test_folder"
backup_folder = "\\192.168.1.173\zip2\Backup\" &strTime

if Not FileSys.FolderExists(new_folder) Then
  WScript.echo "The destination: " & destination & " doesnt exist, it will now be created"
  printf "Folder is not found"
  FileSys.Createfolder(new_folder)
  FileSys.CopyFolder source, new_folder
Else
  If FileSys.FolderExists(new_folder) Then 
    WScript.echo "The Old Folder: " & new_folder & " exists, it will now be moved to backup folder"
	printf "folder is found"
    FileSys.MoveFolder new_folder , backup_folder
	WScript.echo "Folder has been moved."

  Else
    WScript.echo "ERROR: The source folder is not present, nothing will be copied"
  End If 
End If

wait(20)