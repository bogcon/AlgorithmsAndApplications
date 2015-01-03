/*
 * Header file for MergeSort Algorithm.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/MergeSort
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

#ifndef _MERGE_SORT_H_
#define _MERGE_SORT_H_

/* function prototypes */
int* merge(const int, const int, const int*, const int*);
int* mergeSort(const int, int*);
void err(const char*);
int readVectorFromFile(int**, int*, char*, char*);
void printVector(const int*, const int);

#endif /* _MERGE_SORT_H_ */
