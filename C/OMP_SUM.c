 #include <omp.h>
 #include <stdio.h>
 #include <stdlib.h>

 main(int argc, char *argv[]) {

 int nthreads, tid, sum, x, size, i;	
 sum=0;

 printf("Enter the size of Array: ");
 scanf("%d",&size);

 int A[size];

 Fillarray(A,size);			// fill array with random numbers

 #pragma omp parallel		//Create parallel region
   {
	nthreads = omp_get_num_threads(); //get number of threads available
   }

 int localSum[nthreads];	//shared array created in master thread 

 #pragma omp parallel private(tid,i)		//make private copies of tid, and i for each thread
   {
	tid = omp_get_thread_num();		//get thread id for each thread
	x = size/nthreads;					//number of items tobe added by eaach thread

	for(i = tid*x; i < ((tid+1)*x)-1; i++)		//each thread adds their own portion of data

	    {
		localSum[tid] = localSum[tid] + A[i];
	    }
   }

for(i = 0; i < nthreads; i++)
      {
	   sum=sum+localSum[i];
      }

printf("Sum of %d numbers in Array is %d",size,sum);

}

void Fillarray(int* A, int size)
    {
	for(int i=0; i<size; i++)
	   A[i] = (rand()%200) + 100;
    }

