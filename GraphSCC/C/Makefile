CC=gcc
CFLAGS=-c -Wall

all: GraphSCC

GraphSCC: GraphSCC.o
	$(CC) GraphSCC.o -o GraphSCC

GraphSCC.o: GraphSCC.c
	$(CC) $(CFLAGS) GraphSCC.c

clean:
	rm -f *.o GraphSCC
