CC=gcc
CFLAGS=-c -Wall

all: PrimMST

PrimMST: PrimMST.o
	$(CC) PrimMST.o -o PrimMST

PrimMST.o: PrimMST.c
	$(CC) $(CFLAGS) PrimMST.c

clean:
	rm -f *.o PrimMST
