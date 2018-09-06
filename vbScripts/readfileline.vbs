Set objFileToRead = CreateObject("Scripting.FileSystemObject").OpenTextFile("C:\users\rohans\desktop\automation.ini",1)
Dim strLine, lineString, val

'line = InputBox("line Number:")
ReadLine(6)
wscript.echo strLine

Function ReadLine(line)
	For val=1 to line
		 strLine = objFileToRead.ReadLine()
		 'Do something with the line
	Next
	objFileToRead.Close
	'wscript.echo strLine
	Set objFileToRead = Nothing
End Function