#!/bin/bash
while IFS='' read -r line || [[ -n "$line" ]]; do
	echo "Text read from a file: $line " 
done < "$1"
