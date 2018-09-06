dim FileSys, source, destination, WSNet, theDate, theTime, computerName

Set FileSys = CreateObject("Scripting.FileSystemObject")
Set WSNet = CreateObject("WScript.Network")

computerName = WSNet.computerName
theDate = Replace(Date, "/","-")
theTime = Replace(Time, ":",".")
source = "C:\Users\rohans\Desktop\Backup"
destination = "E:\Rohan\QA\VBS\copy\"

if Not FileSys.FolderExists(destination) Then
  WScript.echo "the destination: " & destination & " doesnt exist, it will now be created"
  FileSys.Createfolder(destination)
  FileSys.CopyFolder source, destination
Else
  If FileSys.FolderExists(source) Then 
    FileSys.CopyFolder source, destination 
  Else
    WScript.echo "ERROR: The source folder is not present, nothing will be copied"
  End If 
End If