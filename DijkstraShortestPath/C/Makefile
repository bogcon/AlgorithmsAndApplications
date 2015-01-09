CC=gcc
CFLAGS=-c -Wall

all: DijkstraShortestPath

DijkstraShortestPath: DijkstraShortestPath.o
	$(CC) DijkstraShortestPath.o -o DijkstraShortestPath

DijkstraShortestPath.o: DijkstraShortestPath.c
	$(CC) $(CFLAGS) DijkstraShortestPath.c

clean:
	rm -f *.o DijkstraShortestPath
