Option Explicit

DIM objFSO, strNewestsourceFolder, strNewestmycomFolder, objsourceFolder, objmycomFolder, dDate, colsourceFolders, colmycomFolders, source, mycom, sourceToDestinationFolderName, DestinationFolderName

source = "\\192.168.1.128\zip2"
mycom = "c:\users\rohans\desktop\Python"

Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objsourceFolder = objFSO.GetFolder(source)
Set objmycomFolder = objFSO.GetFolder(mycom)
Set colsourceFolders = objsourceFolder.SubFolders
Set colmycomFolders = objmycomFolder.SubFolders

dDate = Now-365

For Each objsourceFolder in colsourceFolders
	If objsourceFolder.DateCreated > dDate Then
		dDate = objsourceFolder.DateCreated
		strNewestsourceFolder = objsourceFolder
	End If
Next

For Each objmycomFolder in colmycomFolders
	If objmycomFolder.DateCreated > dDate Then
		dDate = objmycomFolder.DateCreated
		strNewestmycomFolder = objmycomFolder
	End If
Next

sourceToDestinationFolderName = right (strNewestsourceFolder,12)			'folder name to be saved at localdrive
DestinationFolderName = right (strNewestmycomFolder,12)			'folder name to be saved at localdrive
'WScript.Echo "Newest Folder at the source is: "&sourceToDestinationFolderName
'WScript.Echo "Newest Folder at the local drive is: "&DestinationFolderName

'WScript.Echo sourceToDestinationFolderName
'WScript.Echo DestinationFolderName

if (sourceToDestinationFolderName = DestinationFolderName) then
	WScript.Echo "No changes yet!"
else 
	objFSO.copyFolder strNewestsourceFolder , mycom & "\" & sourceToDestinationFolderName			'copy folder from source to localdrive
	WScript.Echo "New Folder is placed at the network drive and has been copied."
end if 

'WScript.Echo strNewestsourceFolder			'path for newest folder at source
WScript.Echo strNewestmycomFolder			'path for newest folder at local drive
