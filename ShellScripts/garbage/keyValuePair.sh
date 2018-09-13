#!/bin/bash

while read -r line;
do
	declare "$line";
done < "keyValuePair.txt"
