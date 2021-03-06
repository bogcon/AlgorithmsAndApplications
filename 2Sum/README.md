2Sum Problem
===================
[![Build Status](https://secure.travis-ci.org/bogcon/AlgorithmsAndApplications.png?branch=master)](http://travis-ci.org/bogcon/AlgorithmsAndApplications)

About
---------------------
Check if there are distinct numbers x,y in the input file that satisfy x + y = sum.  
For better performance sort the vector in O(n * log n) and then for every element x
binary search for t - x.
Could be done even better instead of binary search for t - x store key t - x in a hash table.

Running code examples
---------------------
**C** implementation:
```sh
cd C/  
gcc -o 2Sum 2Sum.c (Linux) or run 'make' command
./2Sum ../in/inputBig.txt (Linux)

compile with Visual Studio | MinGW | DevC++ (Windows)
2Sum.exe ../in/inputBig.txt (Windows)
```

**Java** implementation:  
```sh
cd Java/
mvn clean install
java -jar target/twosum-1.0.0.jar ../in/inputBig.txt
```
For the input files in `in/` folder the expected results are:   
for `inputBig.txt` and sum **-8848** algorithm should find a pair x,y, x != y that gives that sum  
for `inputSmall.txt` and sum **10** algorithm should find a pair x,y, x != y that gives that sum  

License
---------------------
`2Sum` is released under the `MIT License`.   
You can find a copy of this license in [LICENSE.txt](LICENSE.txt).  

