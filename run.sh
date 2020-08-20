#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java src.Simulator $1
