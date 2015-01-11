MergeSort Algorithm
===================
[![Build Status](https://secure.travis-ci.org/bogcon/AlgorithmsAndApplications.png?branch=master)](http://travis-ci.org/bogcon/AlgorithmsAndApplications)

About
------------
MergeSort is an O(n * log n) comparison-based sorting algorithm.
MergeSort is a divide and conquer algorithm that was invented by John von Neumann in 1945.

Running code examples
------------
**C** implementation:
```sh
cd C/
gcc -o MergeSort MergeSort.c (Linux) or run the 'make' command
./MergeSort ../in/inputBig.txt (Linux)

compile with Visual Studio | MinGW | DevC++ (Windows)
MergeSort.exe ../in/inputBig.txt (Windows)
```

**Java** implementation:
```sh
cd Java/
mvn clean install
java -jar target/mergesort-1.0.0.jar ../in/inputBig.txt
```

For the input files in `in/` folder the expected results are: the vectors sorted.  

License
---------------------
`MergeSort` is released under the `MIT License`.   
You can find a copy of this license in [LICENSE.txt](LICENSE.txt).  
