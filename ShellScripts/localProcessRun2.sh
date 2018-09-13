#!/bin/bash

# INITIALIZATION OF LOCALSERVER PATH & REMOTESERVER LOCALHOST AND PATH

folderName=[]
NoOfFilesAndFolders=0
i=0
latestFolder=""
prevFolderName=""
filename="content.txt"
remoteServerLatestFolder=""
remoteServerScript="remotePullScript2.sh"												#shell script which will run on remote server
remoteHostName="debian@192.168.0.10"													#Remote server with localhost

#INITIALIZATION ENDS

ssh $remoteHostName 'bash -s' < $remoteServerScript										#command to run script on remote server

if [ "$?" = 0 ];
then
    echo "OK"
else
    echo "$(date): Server was not reachable." >>  fileTransferLog.txt
	exit 1																				#stop the script if scp fails
fi

sleep 5

echo "			Local Host Update"

ls > $filename

#version is represented as bb-slv-p.q.r

p=[]
q=[]
r=[]

while IFS='' read -r line;
do
	if [ "${line%%v*}" == "bb-sl" ]; then									#Search for folderName start from bb-slv
#		echo $line
		folderName[$NoOfFilesAndFolders]=$line
		NoOfFilesAndFolders=$((NoOfFilesAndFolders+1))
#		echo "Array Index is $NoOfFilesAndFolders: " ${folderName[$NoOfFilesAndFolders]}
	fi
#	echo ${folderName[$NoOfFilesAndFolders]}
#	echo "Array index is $NoOfFilesAndFolders: " ${folderName[$NoOfFilesAndFolders]}
#	NoOfFilesAndFolders=$((NoOfFilesAndFolders+1))
#	echo $NoOfFilesAndFolders
done < "$filename"

#echo "No. of Files and Folders: "$NoOfFilesAndFolders
#echo "No. of Files: "$NoOfFiles


#for ((i=0 ; i<NoOfFilesAndFolders ; i++))
#do
#	echo ${folderName[NoOfFilesAndFolders]}
#done

echo "Total No. of bb-slv folders: "$NoOfFilesAndFolders
#echo ${folderName[0]:7:5}

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#extract version from FolderName
do
	p[$i]=${folderName[$i]:7:1}												#extract p value from folderName
	q[$i]=${folderName[$i]:9:1}												#extract q value from folderName
	r[$i]=${folderName[$i]:11:1}											#extract r value from folderName
#	echo ${p[$i]}
#	echo ${q[$i]}
#	echo ${r[$i]}
done

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest p value
do
	if [ "${p[0]}" \> "${p[$i]}" ] | [ "${p[0]}" = "${p[$i]}" ];
	then
		p[0]=${p[0]};
#		echo "p: true condition"
	else
		p[0]=${p[$i]};
#		echo "p: false condition"
	fi
done

#echo "P: Out"${p[1]}

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest q value
do
	if [ "${q[0]}" \> "${q[$i]}" ] | [ "${q[0]}" = "${q[$i]}" ];
	then
		q[0]=${q[0]};
#		echo "q: true condition"
	else
		q[0]=${q[$i]};
#		echo "q: false condition"
	fi
done

#echo "Q: Out"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest r value
do
	if [ "${r[0]}" \> "${r[$i]}" ] | [ "${r[0]}" = "${r[$i]}" ];
	then
		r[0]=${r[0]};
#		echo "r: true condition"
	else
		r[0]=${r[$i]}
#		echo "r: false condition"
	fi
done

#echo "R: Out"

latestFolder="bb-slv-"${p[0]}"."${q[0]}"."${r[0]}								#latestFolderName
echo "$latestFolder"

#prevFolderName=$(tail -1 prevFolderName.txt | head -1)
#remoteServerLatestFolder=$(tail -1 remoteServerLatestFolder.txt | head -1)

prevFolderName=$(tail -n 1 prevFolderName.txt)
remoteServerLatestFolder=$(tail -n 1 remoteServerLatestFolder.txt)

# if [ "$latestFolder" == "$remoteServerLatestFolder" ];
# then
	# echo "No Updates Available"
# else
	
# fi

#echo "Previous FolderName: "$prevFolderName

echo "$latestFolder" > prevFolderName.txt												#latestFolderName

echo "Previous Folder Version: "$prevFolderName
echo "Latest Folder Version:   "$latestFolder
echo "Remote Server Latest Folder Name: "$remoteServerLatestFolder

if [ "$prevFolderName" = "$latestFolder" ];										#latestFolderName
then
	if [ "$remoteServerLatestFolder" == "$latestFolder" ];
	then
		echo "No Update Available"
		echo "$(date)- No Update was Available" >> fileTransferLog.txt
	else
		scp -r -P 22 $remoteHostName:~/sharefolder/$remoteServerLatestFolder $remoteServerLatestFolder
#		pkill -9 python
		echo "Process Killed"
#		python /home/debian/ShellScripts/$remoteServerLatestFolder/hello.py
		echo "New Process Started of Remotefolder: "$remoteServerLatestFolder
		ls -d $remoteServerLatestFolder -lt >> fileTransferLog.txt
	fi
else
	if [ "$remoteServerLatestFolder" == "$prevFolderName" ];
	then
		scp -r -P 22 $remoteHostName:~/sharefolder/$remoteServerLatestFolder $remoteServerLatestFolder
#		pkill -9 python
		echo "Process Killed"
#		python /home/debian/ShellScripts/$remoteServerLatestFolder/hello.py
		echo "New Process Started of Remotefolder: "$remoteServerLatestFolder
		ls -d $remoteServerLatestFolder -lt >> fileTransferLog.txt
	else
		echo "New Folder version is found, Folder Updated"
	#	pkill -9 python
		echo "Process Killed"
	#	python /home/debian/ShellScripts/$latestFolder/hello.py
		echo "New Process Started of Localfolder: "$latestFolder
		ls -d $latestFolder -lt >> fileTransferLog.txt
	fi
fi

