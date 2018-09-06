dim FileSys, source, destination, WSNet, theDate, theTime, computerName, pass, strDate, strTime

Set FileSys = CreateObject("Scripting.FileSystemObject")
Set WSNet = CreateObject("WScript.Network")

Set oWSH = CreateObject("WScript.Shell")
 vbsInterpreter = "cscript.exe"

 Call ForceConsole()

 Function printf(txt)
    WScript.StdOut.WriteLine txt
 End Function

 Function printl(txt)
    WScript.StdOut.Write txt
 End Function

 Function scanf()
    scanf = LCase(WScript.StdIn.ReadLine)
 End Function

 Function wait(n)
    WScript.Sleep Int(n * 1000)
 End Function

 Function ForceConsole()
    If InStr(LCase(WScript.FullName), vbsInterpreter) = 0 Then
        oWSH.Run vbsInterpreter & " //NoLogo " & Chr(34) & WScript.ScriptFullName & Chr(34)
        WScript.Quit
    End If
 End Function

dtmValue = Now()
	strDate = "DosePacker_" & Month(dtmValue) & "_" & Day(dtmValue) & "_" & Year(dtmValue)
	strTime = strDate & "__" & Hour(dtmValue) & "-" & Minute(dtmValue) & "-" & Second(dtmValue)

source = "C:\Users\rohans\Desktop\Backup"
destination = "\\192.168.1.173\zip2"
new_folder = "\\192.168.1.173\zip2\Test_folder"
backup_folder = "\\192.168.1.173\zip2\Backup\" &strTime

if Not FileSys.FolderExists(new_folder) Then
  printf "The destination: " & destination & " doesnt exist, it will now be created"
  wait(5)
  FileSys.Createfolder(new_folder)
  FileSys.CopyFolder source, new_folder
Else
  If FileSys.FolderExists(new_folder) Then 
    printf "The Old Folder: " & new_folder & " exists, it will now be moved to backup folder"
	wait(5)
    FileSys.MoveFolder new_folder , backup_folder
	printf "Folder has been moved."

  Else
    printf "ERROR: The source folder is not present, nothing will be copied"
	wait(5)
  End If 
End If