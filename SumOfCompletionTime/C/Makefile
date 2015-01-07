CC=gcc
CFLAGS=-c -Wall

all: SumOfCompletionTime

SumOfCompletionTime: SumOfCompletionTime.o
	$(CC) SumOfCompletionTime.o -o SumOfCompletionTime

SumOfCompletionTime.o: SumOfCompletionTime.c
	$(CC) $(CFLAGS) SumOfCompletionTime.c

clean:
	rm -f *.o SumOfCompletionTime
