Counting inversions in an array
===================
[![Build Status](https://secure.travis-ci.org/bogcon/AlgorithmsAndApplications.png?branch=master)](http://travis-ci.org/bogcon/AlgorithmsAndApplications)

About
------------
Given array A[1... n], for every i < j, counts all inversion pairs such that A[i] > A[j].

Running code examples
------------
**C** implementation:
```sh
cd C/
gcc -o InversionsCount InversionsCount.c (Linux)
./InversionsCount ../in/inputBig.txt (Linux)

compile with Visual Studio | MinGW | DevC++ (Windows) 
InversionsCount.exe ../in/inputBig.txt (Windows)
```
**Java** implementation:
```sh
cd Java/
mvn clean install
java -jar target/quicksort-1.0.0.jar ../in/inputBig.txt
```

For the input files in `in/` folder the expected results are: `inputTiny.txt`: 19, `inputBig.txt`: 2407905288
