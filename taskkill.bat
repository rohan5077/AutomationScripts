color 02

for /f "tokens=5" %%a in ('netstat -aon ^| find "8080" ^| find "LISTENING"') do taskkill /f /pid %%a

TIMEOUT 5

CD\
e:
cd rohan/electronics_automation

cscript copy_paste.vbs

python hello.py
pause