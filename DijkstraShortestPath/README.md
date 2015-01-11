Dijkstra's Algorithm
===================
[![Build Status](https://secure.travis-ci.org/bogcon/AlgorithmsAndApplications.png?branch=master)](http://travis-ci.org/bogcon/AlgorithmsAndApplications)

About
------------
Dijkstra's algorithm, conceived by Dutch computer scientist Edsger Dijkstra in 1956 and published in 1959, is a graph search algorithm that solves the single-source shortest path problem for a graph with non-negative edge path costs, producing a shortest path tree. This algorithm is often used in routing and as a subroutine in other graph algorithms.

Running code examples
------------
**C** implementation:
```sh
cd C/  
gcc -o DijkstraShortestPath DijkstraShortestPath.c (Linux) or run 'make' command
./DijkstraShortestPath ../in/inputBig.txt (Linux)

compile with Visual Studio | MinGW | DevC++ (Windows)
DijkstraShortestPath.exe ../in/inputBig.txt (Windows)
```

**Java** implementation:
```sh
cd Java/
mvn clean install
java -jar target/dijkstra-1.0.0.jar ../in/inputBig.txt
```

For the input files in `in/` folder the some/all of expected results are: 

some of the result for `inputBig.txt`:  
Shortest path from 1 to 7 is: 2599  
Shortest path from 1 to 37 is: 2610  
Shortest path from 1 to 59 is: 2947  
Shortest path from 1 to 82 is: 2052  
Shortest path from 1 to 99 is: 2367  
Shortest path from 1 to 115 is: 2399  
Shortest path from 1 to 133 is: 2029  
Shortest path from 1 to 165 is: 2442  
Shortest path from 1 to 188 is: 2505  
Shortest path from 1 to 197 is: 3068  

results for `inputMedium.txt`:  
Shortest path from 1 to 1 is: 0  
Shortest path from 1 to 2 is: 1  
Shortest path from 1 to 3 is: 6  
Shortest path from 1 to 4 is: 5  
Shortest path from 1 to 5 is: 4  
Shortest path from 1 to 6 is: 3  
Shortest path from 1 to 7 is: 2  

results for `inputSmall.txt`:  
Shortest path from 1 to 1 is: 0  
Shortest path from 1 to 2 is: 1  
Shortest path from 1 to 3 is: 3  
Shortest path from 1 to 4 is: 6  

License
---------------------
`DijkstraShortestPath` is released under the `MIT License`.   
You can find a copy of this license in [LICENSE.txt](LICENSE.txt).  


