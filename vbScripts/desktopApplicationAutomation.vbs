Dim objShell, x, InoFilePath, sSelectedValue

InoFilePath = "E:\Rohan\Arduino_prog\Silvasa_cmdproc_mega\test_ethernet_cmdproc_eeprom_powerstep_final.ino\test_ethernet_cmdproc_eeprom_powerstep_final.ino.ino"

Set objShell = WScript.CreateObject( "WScript.Shell" )


objShell.Run("""C:\Program Files (x86)\Arduino\arduino.exe""")
WScript.Sleep 5000

'Commands for INO file selection

objShell.sendKeys "^(o)"
'objShell.sendKeys "%"
'objShell.sendKeys "{ENTER}"
'objShell.sendKeys "{DOWN}"
'objShell.sendKeys "{DOWN}"
'objShell.sendKeys "{ENTER}"
WScript.Sleep 1000
objShell.sendKeys InoFilePath
objShell.sendKeys "{ENTER}"
WScript.Sleep 1000

'Commands for set the MEGA board

objShell.sendKeys "%"
for x = 1 to 3 
	objShell.sendKeys "{RIGHT}"
Next

for x = 1 to 7
	objShell.sendKeys "{DOWN}"
Next

objShell.sendKeys "{RIGHT}"

for x = 1 to 6
	objShell.sendKeys "{DOWN}"
Next
WScript.Sleep 1000
objShell.sendKeys "{ENTER}"
MSGBOX "Mega Selected, You have 15 seconds to select PORT ."

WScript.Sleep 10000

'Commands for compile program

objShell.sendKeys "^(r)"
'objShell.sendKeys "%"
'objShell.sendKeys "{RIGHT}"
'objShell.sendKeys "{RIGHT}"
'objShell.sendKeys "{DOWN}"

WScript.Sleep 1000
'objShell.sendKeys "{ENTER}"

WScript.Sleep 15000

Set objShell = Nothing
WScript.Sleep 250

