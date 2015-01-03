/*
 * Sorting a vector via MergeSort algorithm and Divide and Conquer aproach in O(n * log n).
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/MergeSort
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "MergeSort.h"

/**
 * Main function. Reads vector, sorts it, and prints the sorted vector.
 * @param     argc       Command line arguments no.
 * @param     argv       Command line arguments.
 * @return               Success/error code. (0 is a success, anything else is error).
 */
int main(int argc, char** argv) {
	printf("------ Begin MergeSort ------\n");
	int n, i = 0;
	int *vectorToSort, *sortedVector;
	clock_t start, end;
	char error[128];

	/* read vector */
	if (argc == 1) {
		err("Err. The input file must be given as an argument.\n");
	}
	if (!readVectorFromFile(&vectorToSort, &n, argv[1], error)) {
		err(error);
	}

	/* print read vector */
	//printf("The read vector is: ");
	//printVector(vectorToSort, n);
	//printf("\n");

	/* sort vector */
	start = clock();
	sortedVector = mergeSort(n, vectorToSort);
	end = clock();

	/* print sorted vector */
	printf("The sorted vector is: ");
	printVector(sortedVector, n);
	printf("\n");

	/* free memory */
	free(vectorToSort);
	free(sortedVector);

	printf("Elapsed: %f seconds while sorting.\n", (double) (end - start) / CLOCKS_PER_SEC);
	printf("------- End MergeSort -------\n");
	return EXIT_SUCCESS;
}

/**
 * Prints error and exits program.
 * @param    msg   The error to print.
 */
void err(const char* msg) {
	printf("%s", msg);
	printf("------- End MergeSort -------\n");
	exit(EXIT_FAILURE);
}

/**
 * Recursive function (based on Divide and Conquer algorithm) that sorts a vector (via Merge Sort algorithm).
 * @param    n    The dimension of the vector to sort.
 * @param    v    The vector to sort.
 * @return        The sorted vector.
 */
int* mergeSort(const int n, int* v) {
	if (1 == n) { // base case
		return v;
	}
	int* returnValue;
	int n1 = n / 2;
	int n2 = n - n1;
	int* leftHalf = (int*) malloc(sizeof(int) * n1);
	int* rightHalf = (int*) malloc(sizeof(int) * n2);
	memcpy(leftHalf, v, sizeof(int) * n1);
	memcpy(rightHalf, v + n1, sizeof(int) * n2);
	returnValue = merge(n1, n2, mergeSort(n1, leftHalf), mergeSort(n2, rightHalf));
	free(leftHalf);
	free(rightHalf);
	return returnValue;
}

/**
 * Merges two sorted vectors.
 * @param    n1    The dimension of the first vector.
 * @param    n2    The dimension of the second vector.
 * @param    v1    The first vector. (should be sorted)
 * @param    v2    The second vector. (should be sorted)
 * @return         The combined v1,v2 sorted vector.
 */
int* merge(const int n1, const int n2, const int* v1, const int* v2) {
	int n = n1 + n2, k = 0, i = 0, j = 0;
	int* v = (int *) malloc(sizeof(int) * n);

	while (i < n1 && j < n2) {
		if (v1[i] <= v2[j]) {
			v[k++] = v1[i++];
		} else {
			v[k++] = v2[j++];
		}
	}

	if (i < n1) {
		while (k < n) {
			v[k++] = v1[i++];
		}
	}
	if (j < n2) {
		while (k < n) {
			v[k++] = v2[j++];
		}
	}
	return v;
}

/**
 * Reads array from file.
 * @param      v     The address of the array to store read elements.
 * @param      n     The address of the number of elements array has.
 * @param      file  The file where to read array from.
 * @param      err   An error message, if any occcurred during reading.
 * @return           1 if everything went fine, 0 otherwise. 
 */
int readVectorFromFile(int** v, int* n, char* file, char* err) {
	FILE *inputFile = fopen(file, "rt");
	int countReadedElements = 0, i = 0;

	if (inputFile == NULL) {
		strcpy(err, "Err. Could not open file.\n");
		return 0;
	}
	if (fscanf(inputFile, "%d", n) != 1) {
		fclose(inputFile);
		strcpy(err, "Err. Could not read number of elements.\n");
		return 0;
	}
	*v = (int*) malloc(sizeof(int) * (*n));
	for (i = 0; i < *n; i++) {
		if (fscanf(inputFile, "%d", &(*v)[i]) != 1) {
			break;
		}
		countReadedElements++;
	}
	fclose(inputFile);
	if (countReadedElements != *n) {
		strcpy(err,	"Err. Number of declared elements does not match with the one found in file.\n");
		return 0;
	}
	return 1;
}

/**
 * Prints an array 's elements.
 * @param    v        The vector to print.
 * @param    n        The number of elements vector has.    
 */
void printVector(const int* v, const int n) {
	int i;
	for (i = 0; i < n; i++) {
		printf("%d ", v[i]);
	}
}
