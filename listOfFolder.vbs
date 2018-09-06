Option Explicit

dim objFSO, objsourceFolder, colsourceFolders, source, destination, i, suffixLen
dim suffix(), p(), q(), r()																	'version 2.0.1 as p.q.r

i=0
suffixLen = -1

source = "\\192.168.1.128\zip2"
destination = "c:/users/rohans/desktop/python"

Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objsourceFolder = objFSO.GetFolder(source)
Set colsourceFolders = objsourceFolder.SubFolders

ReDim preserve suffix(20)

For Each objsourceFolder in colsourceFolders									'finding all subfolders
	suffix(i) = right(objsourceFolder,5)
	'WScript.echo objsourceFolder												'subfolders
	i=i+1
	suffixLen= suffixLen+1														'finding number of subfolders
Next

'suffixLen = uBound(suffix)

MsgBox "Number of folders are : " & suffixLen+1, 0, "Folder Info"				'echo number of folders

ReDim preserve suffix(suffixLen)												'redefine array length
'WScript.echo UBound(suffix)													'echo array length

Redim preserve p(suffixLen)
Redim preserve q(suffixLen)
Redim preserve r(suffixLen)

For i=0 to suffixLen
	p(i) = left(suffix(i),1)
	q(i) = mid(suffix(i),3,1)
	r(i) = right(suffix(i),1)
	'WScript.echo p(i)
	'WScript.echo q(i)
	'WScript.echo r(i)
next

for i=0 to suffixLen
	if p(1)=p(i) or p(1)>p(i) then
		p(1)=p(1)
	else 
		p(1)=p(i)
	end if 
next

'WScript.echo "P is : " & p(1)

for i=0 to suffixLen
	if q(1)=q(i) or q(1)>q(i) then
		q(1)=q(1)
	else 
		q(1)=q(i)
	end if 
next

'WScript.echo "Q is : " & q(1)

for i=0 to suffixLen
	if r(1)=r(i) or r(1)>r(i) then
		r(1)=r(1)
	else 
		r(1)=r(i)
	end if 
next

'WScript.echo "R is : " & r(1)

MsgBox "Latest Version is : " & p(1) & "." & q(1) & "." & r(1), 0 , "Version"
'WScript.echo q(1)
'WScript.echo r(1)

'WScript.echo "Latest folder path is : " & source & "\bb-slv-" & p(1) & "." & q(1) & "." & r(1)
objFSO.CopyFolder source & "\bb-slv-" & p(1) & "." & q(1) & "." & r(1) , destination & "\"
MsgBox "Folder is copied & pasted to " & destination, 0, "Transfer Info"



















		