Set objExplorer = CreateObject("InternetExplorer.Application")


'objExplorer.Navigate "http://192.168.1.136:10001/api/execute_station_routine%2010,104,0,10"
objExplorer.Navigate "www.google.com"

objExplorer.Visible = 1


Wscript.Sleep 5000


Set objDoc = objExplorer.Document


Do While True

    Wscript.Sleep 10000

    objDoc.Location.Reload(True)

    If Err <> 0 Then

        Wscript.Quit

    End If

Loop