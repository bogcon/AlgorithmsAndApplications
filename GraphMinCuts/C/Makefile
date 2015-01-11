CC=gcc
CFLAGS=-c -Wall

all: GraphMinCuts

GraphMinCuts: GraphMinCuts.o
	$(CC) GraphMinCuts.o -o GraphMinCuts

GraphMinCuts.o: GraphMinCuts.c
	$(CC) $(CFLAGS) GraphMinCuts.c

clean:
	rm -f *.o GraphMinCuts
