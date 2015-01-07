CC=gcc
CFLAGS=-c -Wall

all: 2Sum

2Sum: 2Sum.o
	$(CC) 2Sum.o -o 2Sum

2Sum.o: 2Sum.c
	$(CC) $(CFLAGS) 2Sum.c

clean:
	rm -f *.o 2Sum
