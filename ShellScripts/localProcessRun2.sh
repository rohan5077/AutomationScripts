#!/bin/bash

# INITIALIZATION OF LOCALSERVER PATH & REMOTESERVER LOCALHOST AND PATH

folderName=[]
NoOfFilesAndFolders=0
i=0
latestFolder=""
prevFolderName=""
filename="content.txt"
remoteServerLatestFolder=""
remoteServerScript="remotePullScript2.sh"
remoteHostName="debian@192.168.0.10"

#INITIALIZATION ENDS

ls > $filename

ssh $remoteHostName 'bash -s' < $remoteServerScript

sleep 5

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
	p[$i]=${folderName[$i]:7:1}										#extract p value from folderName
	q[$i]=${folderName[$i]:9:1}										#extract q value from folderName
	r[$i]=${folderName[$i]:11:1}										#extract r value from folderName
#	echo ${p[$i]}
#	echo ${q[$i]}
#	echo ${r[$i]}
done

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest p value
do
	if [ "${p[1]}" \> "${p[$i]}" ] | [ "${p[1]}" = "${p[$i]}" ];
	then
		p[1]=${p[1]};
#		echo "p: true condition"
	else
		p[1]=${p[$i]};
#		echo "p: false condition"
	fi
done

#echo "P: Out"${p[1]}

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest q value
do
	if [ "${q[1]}" \> "${q[$i]}" ] | [ "${q[1]}" = "${q[$i]}" ];
	then
		q[1]=${q[1]};
#		echo "q: true condition"
	else
		q[1]=${q[$i]};
#		echo "q: false condition"
	fi
done

#echo "Q: Out"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest r value
do
	if [ "${r[1]}" \> "${r[$i]}" ] | [ "${r[1]}" = "${r[$i]}" ];
	then
		r[1]=${q[1]};
#		echo "r: true condition"
	else
		r[1]=${r[$i]}
#		echo "r: false condition"
	fi
done

#echo "R: Out"

latestFolder="bb-slv-"${p[1]}"."${q[1]}"."${r[1]}								#latestFolderName

prevFolderName=$(tail -1 prevFolderName.txt | head -1)
remoteServerLatestFolder=$(tail -1 remoteServerLatestFolder.txt | head -1)

# if [ "$latestFolder" == "$remoteServerLatestFolder" ];
# then
	# echo "No Updates Available"
# else
	
# fi

echo "Previous FolderName: "$prevFolderName

echo $latestFolder > prevFolderName.txt												#latestFolderName

echo "Previous Folder Version: "$prevFolderName
echo "Latest Folder Version:   "$latestFolder
echo "Remote Server Latest Folder Name: "$remoteServerLatestFolder

if [ "$prevFolderName" = "$latestFolder" ];										#latestFolderName
then
	if [ "$remoteServerLatestFolder" == "$latestFolder" ];
	then
		echo "No Update Available"
	else
		scp -r -P 22 $remoteHostName:~/sharefolder/$remoteServerLatestFolder $remoteServerLatestFolder
#		pkill -9 python
		echo "Process Killed"
#		python /home/debian/ShellScripts/$remoteServerLatestFolder/hello.py
		echo "New Process Started of folder: "$remoteServerLatestFolder
		ls -d $latestFolder -lt >> fileTransferLog.txt
	fi
else
	echo "New Folder version is found, Folder Updated"
#	pkill -9 python
	echo "Process Killed"
#	python /home/debian/ShellScripts/$latestFolder/hello.py
	echo "New Process Started of folder: "$latestFolder
	ls -d $latestFolder -lt >> fileTransferLog.txt
fi

