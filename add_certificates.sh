#!/bin/bash

DIRECTORY="certificates"

if [ $# -ne 1 ]
then

	echo "[ERROR] Usage: `basename $0` <path/to/java/keystore>" 1>&2
	exit -1
fi

if [[ $EUID -ne 0 ]]; then
   echo "[ERROR] This script must be run as root" 1>&2
   exit 1
fi

for certificate in `ls $DIRECTORY/`
do
	keytool -import -file $DIRECTORY/$certificate -keystore $1 -alias $1
done
