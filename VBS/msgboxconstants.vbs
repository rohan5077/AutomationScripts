option Explicit
dim a
a = Msgbox ("Constant msgbox",vbAbortRetryIgnore+vbExclamation+vbDefaultButton2+vbSystemModal)
if a=vbAbort then msgbox "Quit",vbCritical