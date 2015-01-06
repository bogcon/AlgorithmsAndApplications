/*
 * Greedy algorithm for minimizing the weighted sum of completion times.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/SumOfCompletionTime
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include "SumOfCompletionTime.h"

/**
 * Main function.
 * @param     argc       Command line arguments no.
 * @param     argv       Command line arguments.
 * @return    int        Success/error code. (0 is a success, anything else is error).
 */
int main(int argc, char** argv) {
	printf("------ Begin Greedy Minimizing The Weighted Sum Of Completion Times ------\n");
	clock_t start, end;
	char error[128];
	int i, n;
	Job* jobs;
	long long sum = 0, completionSum = 0;

	/* read jobs, sorts them and calculate the result */
	start = clock();
	if (argc < 3) {
		err("Err. Please provide the ratio calculation strategy as the first argument and the input file as the second argument.\n");
	}
	if (0 != strcmp("sum", argv[1]) && 0 != strcmp("division", argv[1])) {
		err("Err. The ratio calculation strategy should be one of 'sum' or 'division'\n");
	}
	if (!readJobsSortedFromFile(&jobs, argv[1], &n, argv[2], error)) {
		err(error);
	}
	
	for (i = 0; i < n; i++) {
		sum += jobs[i].length;
		completionSum += jobs[i].weight * sum;
	}
	/* free memory */
	free(jobs);
	end = clock();

	/* print result */
	printf("The weighted sum of completion times = %lld\n", completionSum);
	
	printf("Elapsed: %f seconds with sum calculation.\n",(double) (end - start) / CLOCKS_PER_SEC);
	printf("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------\n");
	return EXIT_SUCCESS;
}

/**
 * Reads array of jobs from file.
 * @param v The address of the array to store read elements.
 * @param ratioStrategy Whether ratio is calculated by dividing weight by length, or summing length to weight.
 * @param n The address of the number of elements array has.
 * @param file The file where to read array from.
 * @param err An error message, if any occcurred during reading.
 * @return 1 if everything went fine, 0 otherwise.
 */
int readJobsSortedFromFile(Job** v, const char* ratioStrategy, int* n, char* file, char* err) {
	FILE *inputFile = fopen(file, "rt");
	int countReadedElements = 0, i = 0, length, weight, j;

	if (inputFile == NULL) {
		strcpy(err, "Err. Could not open file.\n");
		return 0;
	}
	if (fscanf(inputFile, "%d", n) != 1) {
		fclose(inputFile);
		strcpy(err, "Err. Could not read number of jobs.\n");
		return 0;
	}
	*v = (Job*) malloc(sizeof(Job) * (*n));
	if (0 == strcmp("sum", ratioStrategy)) { // The ratio is calculated as difference between weight and length. Is not always optimal.
		for (i = 0; i < *n; i++) {
			if (fscanf(inputFile, "%d %d", &weight, &length) != 2) {
				break;
			}
			Job job = { .weight = weight, .length = length };
			j = i;
			while (j > 0
				   && ((*v)[j - 1].weight - (*v)[j - 1].length) < (job.weight - job.length)) {
				(*v)[j] = (*v)[j - 1];
				j--;
			}
			while (j > 0
				   && ((*v)[j - 1].weight - (*v)[j - 1].length) == (job.weight - job.length)
				   && (*v)[j - 1].weight < job.weight) {
				(*v)[j] = (*v)[j - 1];
				j--;
			}
			(*v)[j] = job;
			countReadedElements++;
		}
	} else { // The ratio is calculated as weight divided by length. Is always optimal.
		for (i = 0; i < *n; i++) {
			if (fscanf(inputFile, "%d %d", &weight, &length) != 2) {
				break;
			}
			Job job = { .weight = weight, .length = length };
			j = i;
			while (j > 0
				   && ((*v)[j - 1].weight * job.length) < (job.weight * (*v)[j - 1].length)) { // w1/len1 < w2/len2 <=> w1*len2 < w2.len1 
				(*v)[j] = (*v)[j - 1];
				j--;
			}
			while (j > 0
				   && ((*v)[j - 1].weight * job.length) == (job.weight * (*v)[j - 1].length)
				   && (*v)[j - 1].weight < job.weight) {
				(*v)[j] = (*v)[j - 1];
				j--;
			}
			(*v)[j] = job;
			countReadedElements++;
		}
	}
	
	fclose(inputFile);
	if (countReadedElements != *n) {
		strcpy(err, "Err. Number of declared jobs does not match with the one found in file.\n");
		return 0;
	}
	return 1;
}

/**
 * Prints error and exits program.
 * @param    msg    The error to print.
 */
void err(const char* msg) {
	printf("%s", msg);
	printf("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------\n");
	exit(EXIT_FAILURE);
}
