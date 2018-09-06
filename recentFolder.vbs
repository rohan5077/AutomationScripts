Option Explicit

DIM objFSO, strNewestFolder, objFolder, dDate, colFolders, source, mycom

source = "\\192.168.1.128\zip2"
mycom = "c:\users\rohans\desktop\Python"

Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objFolder = objFSO.GetFolder(source)
Set colFolders = objFolder.SubFolders

dDate = Now-365

For Each objFolder in colFolders
If objFolder.DateCreated > dDate Then
dDate = objFolder.DateCreated
strNewestFolder = objFolder
End If
Next

WScript.Echo strNewestFolder			'path for newest folder

