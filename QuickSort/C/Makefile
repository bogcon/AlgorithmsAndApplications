CC=gcc
CFLAGS=-c -Wall

all: QuickSort

QuickSort: QuickSort.o
	$(CC) QuickSort.o -o QuickSort

2Sum.o: 2Sum.c
	$(CC) $(CFLAGS) QuickSort.c

clean:
	rm -f *.o QuickSort
