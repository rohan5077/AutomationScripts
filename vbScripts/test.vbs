Dim objShell, x, InoFilePath, sSelectedValue

InoFilePath = "E:\Rohan\Arduino_prog\Silvasa_cmdproc_mega\ethernet_cmdproc_eeprom_powerstep_final\ethernet_cmdproc_eeprom_powerstep_final.ino"

Set objShell = WScript.CreateObject( "WScript.Shell" )


objShell.Run("""C:\Program Files (x86)\Arduino\arduino.exe""")
WScript.Sleep 5000

'Commands for INO file selection

objShell.sendKeys "^(o)"



Set objShell = Nothing
WScript.Sleep 250

