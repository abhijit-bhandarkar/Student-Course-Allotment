
Assuming you are in the directory containing this README:

## To clean:
	ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
## To successfully run this command you need to place "input_file.txt" inside the folder studentCoursesBackup
## path to store the input_file is "*/abhijit_bhandarkar_assign_2/studentCoursesBackup/"
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
The time complexities of all methods of MyArrayList
insertNode = O(ln N) average case
deleteNode = O(ln N) average case
