Option Explicit
Dim date

date = now()

msgbox date
msgbox day(date)& "-" & month(date) & "-" & year(date) & "    " & hour(date) & ":" & minute(date) & ":" & second(date)