Set WshShell = WScript.CreateObject("WScript.Shell") 
WshShell.AppActivate("Chrome")
i=0
do while i = 0
WshShell.SendKeys "{F5}"
WScript.sleep(10000)
loop
WshShell.AppActivate("TextPad")