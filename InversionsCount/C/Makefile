CC=gcc
CFLAGS=-c -Wall

all: InversionsCount

InversionsCount: InversionsCount.o
	$(CC) InversionsCount.o -o InversionsCount

InversionsCount.o: InversionsCount.c
	$(CC) $(CFLAGS) InversionsCount.c

clean:
	rm -f *.o InversionsCount
