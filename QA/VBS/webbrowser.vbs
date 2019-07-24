option explicit
dim search, obj, filler

set obj = CreateObject("wscript.shell")
filler = inputbox("Type to search: ")
obj.run "chrome.exe"
wscript.sleep 1500
obj.sendkeys filler
obj.sendkeys "{enter}"

