
REM To use this file correctly, replace the path below "C:\java\eclipse-workspace\LinegameEditor2\src" with YOUR OWN path
REM to LinegameEditor2\src. Do not expect it to work if you do not change this.
java -jar prebuild.jar C:\java\eclipse-workspace\LinegameEditor2\src
javac -source 10 -d bin @args.txt
exit
