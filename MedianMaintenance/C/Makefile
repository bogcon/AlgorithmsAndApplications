CC=gcc
CFLAGS=-c -Wall

all: MedianMaintenance

MedianMaintenance: MedianMaintenance.o
	$(CC) MedianMaintenance.o -o MedianMaintenance

MedianMaintenance.o: MedianMaintenance.c
	$(CC) $(CFLAGS) MedianMaintenance.c

clean:
	rm -f *.o MedianMaintenance
