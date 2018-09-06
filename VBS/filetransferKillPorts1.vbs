option explicit
dim source, mycom, destination, fso, wsnet, dtmValue, strDate, strTime

dtmValue = Now()
	strDate = "DosePacker_" & Month(dtmValue) & "_" & Day(dtmValue) & "_" & Year(dtmValue)
	strTime = strDate & "__" & Hour(dtmValue) & "-" & Minute(dtmValue) & "-" & Second(dtmValue)

source = "\\192.168.1.195\rohan"
mycom = "c:\users\rohans\desktop\backup"

set fso = CreateObject("Scripting.FileSystemObject")
'set wsnet = CreateObject("WScript.Network")

'fso.CopyFolder "\\192.168.1.195\Rohan", "c:\users\rohans\desktop\backup\" & strTime
fso.CopyFolder "c:\users\rohans\desktop\backup" , "\\192.168.1.195\rohan" & strTime







