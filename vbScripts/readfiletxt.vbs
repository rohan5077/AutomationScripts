Set objFileToRead = CreateObject("Scripting.FileSystemObject").OpenTextFile("C:\users\rohans\desktop\filetozip.txt",1)
Dim strLine
do while not objFileToRead.AtEndOfStream
     strLine = objFileToRead.ReadLine()
     'Do something with the line
loop
objFileToRead.Close
wscript.echo strLine
Set objFileToRead = Nothing