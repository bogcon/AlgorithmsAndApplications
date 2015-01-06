/*
 * Header file for greedy algorithm for minimizing the weighted sum of completion times.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/SumOfCompletionTime
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

#ifndef _SUM_OF_COMPLETION_TIME_H_
#define _SUM_OF_COMPLETION_TIME_H_

struct Job {
    int length;
    int weight;
};
typedef struct Job Job;

/* function prototypes */
int readJobsSortedFromFile(Job**, const char*, int*, char*, char*);
void err(const char*);

#endif /* _SUM_OF_COMPLETION_TIME_H_ */
