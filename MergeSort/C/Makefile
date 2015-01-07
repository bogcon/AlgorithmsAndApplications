CC=gcc
CFLAGS=-c -Wall

all: MergeSort

MergeSort: MergeSort.o
	$(CC) MergeSort.o -o MergeSort

MergeSort.o: MergeSort.c
	$(CC) $(CFLAGS) MergeSort.c

clean:
	rm -f *.o MergeSort
