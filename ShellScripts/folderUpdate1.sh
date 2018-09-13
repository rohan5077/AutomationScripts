#!/bin/bash

ls > content.txt

folderName=[]
NoOfFilesAndFolders=0
filename="content.txt"
i=0
latestFolder=""
prevFolderName=""

#version is represented as bb-slv-p.q.r

p=[]
q=[]
r=[]

while IFS='' read -r line;
do
	if [ "${line%%v*}" == "bb-sl" ]; then									#Search for folderName start from bb-slv
		#echo $line
		folderName[$NoOfFilesAndFolders]=$line
		NoOfFilesAndFolders=$((NoOfFilesAndFolders+1))
#		echo "Array Index is $NoOfFilesAndFolders: " ${folderName[$NoOfFilesAndFolders]}
	fi
	#echo ${folderName[$NoOfFilesAndFolders]}
	#echo "Array index is $NoOfFilesAndFolders: " ${folderName[$NoOfFilesAndFolders]}
	#NoOfFilesAndFolders=$((NoOfFilesAndFolders+1))
	#echo $NoOfFilesAndFolders
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
	#echo ${p[$i]}
	#echo ${q[$i]}
	#echo ${r[$i]}
done

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest p value
do
	if [ "${p[0]}" \> "${p[$i]}" ] | [ "${p[0]}" = "${p[$i]}" ];
	then
		p[0]=${p[0]};
		#echo "p: true condition"
	else
		p[0]=${p[$i]};
		#echo "p: false condition"
	fi
done

#echo "P: Out ${p[0]}"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest q value
do
	if [ "${q[0]}" \> "${q[$i]}" ] | [ "${q[0]}" = "${q[$i]}" ];
	then
		q[0]=${q[0]};
		#echo "q: true condition"
	else
		q[0]=${q[$i]};
		#echo "q: false condition"
	fi
done

#echo "Q: Out ${q[0]}"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))									#loop for fetching greatest r value
do
	if [ "${r[0]}" \> "${r[$i]}" ] | [ "${r[0]}" = "${r[$i]}" ];
	then
		r[0]=${r[0]};
		#echo "r: true condition"
	else
		r[0]=${r[$i]}
		#echo "r: false condition"
	fi
done

echo "R: Out ${r[0]}"

latestFolder="bb-slv-"${p[0]}"."${q[0]}"."${r[0]}								#latestFolderName

prevFolderName=$(tail -1 prevFolderName.txt | head -1)

echo $latestFolder > prevFolderName.txt												#latestFolderName

echo "Previous Folder Version: "$prevFolderName
echo "Latest Folder Version:   "$latestFolder

if [ "$prevFolderName" = "$latestFolder" ];										#latestFolderName
then
	echo "No Update Available"
	echo "$(date)- No Update was Available" >> fileTransferLog.txt
else
	echo "New Folder version is found, Folder Updated"
	pkill -9 python
	echo "Process Killed"
	#python /home/debian/ShellScripts/$latestFolder/hello.py
	echo "New Process Started"
	ls -d $latestFolder -lt >> fileTransferLog.txt
fi

#scp -r -P 22 /home/debian/ShellScripts/bb-slv-${p[1]}.${q[1]}.${r[1]} meditab@192.168.0.11:~/Desktop/rohantest/bb-slv-${p[1]}.${q[1]}.${r[1]}

#python /home/debian/ShellScripts/$latestFolder/hello.py								#python command to run the code


