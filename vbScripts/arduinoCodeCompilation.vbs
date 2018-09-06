Dim objShell

Set objShell = WScript.CreateObject( "WScript.Shell" )


objShell.Run("""C:\Program Files (x86)\Arduino\arduino.exe""")
WScript.Sleep 5000
objShell.sendKeys "%"
objShell.sendKeys "{RIGHT}"
objShell.sendKeys "{RIGHT}"
objShell.sendKeys "{ENTER}"
objShell.sendKeys "{DOWN}"
objShell.sendKeys "{ENTER}"

Set objShell = Nothing
WScript.Sleep 250