#!/bin/bash

ls -a > content.txt

folderName=[]
NoOfFilesAndFolders=0
NoOfFiles=5
filename="content.txt"
i=0

#version is represented as p.q.r

p=[]
q=[]
r=[]

while IFS='' read -r line;
do
	if [ "${line%%v*}" == "bb-sl" ]; then
		#echo $line
		folderName[$NoOfFilesAndFolders]=$line
		NoOfFilesAndFolders=$((NoOfFilesAndFolders+1))
		#echo "Array Index is $NoOfFilesAndFolders: " ${folderName[$NoOfFilesAndFolders]}
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

for ((i=0 ; i<NoOfFilesAndFolders ; i++))
do
	p[$i]=${folderName[$i]:7:1}
	q[$i]=${folderName[$i]:9:1}
	r[$i]=${folderName[$i]:11:1}
	#echo ${p[$i]}
	#echo ${q[$i]}
	#echo ${r[$i]}
done

for ((i=0 ; i<NoOfFilesAndFolders ; i++))
do
	if [ "${p[1]}" -gt "${p[$i]}" ] | [ "${p[1]}" == "${p[$i]}" ];
	then
		p[1]=${p[1]};
		#echo "p: true condition"
	else
		p[1]=${p[$i]};
		#echo "p: false condition"
	fi
done

#echo "P: Out"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))
do
	if [ "${q[1]}" -gt "${q[$i]}" ] | [ "${q[1]}" == "${q[$i]}" ];
	then
		q[1]=${q[1]};
		#echo "q: true condition"
	else
		q[1]=${q[$i]};
		#echo "q: false condition"
	fi
done

#echo "Q: Out"

for ((i=0 ; i<NoOfFilesAndFolders ; i++))
do
	if [ "${r[1]}" -gt "${r[$i]}" ] | [ "${r[1]}" == "${r[$i]}" ];
	then
		r[1]=${q[1]};
		#echo "r: true condition"
	else
		r[1]=${r[$i]}
		#echo "r: false condition"
	fi
done

#echo "R: Out"

echo "Latest Version: "${p[1]}"."${q[1]}"."${r[1]}

scp -r -P 22 /home/debian/ShellScripts/bb-slv-${p[1]}.${q[1]}.${r[1]} meditab@192.168.0.11:~/Desktop/rohantest/bb-slv-${p[1]}.${q[1]}.${r[1]}
