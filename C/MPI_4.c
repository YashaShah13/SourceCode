#include <mpi.h>
#include <stdio.h>
#include<stdlib.h>
#include<time.h>
#define MASTER 0					//designate rank 0 as master processor
int main(int argc, char** argv) {
	
	MPI_Status stat;
	MPI_Init(&argc,&argv);
	int p,sum=0;
	
	MPI_Comm_size(MPI_COMM_WORLD, &p);	//get numbar of processsor available
	int pid;

	MPI_Comm_rank(MPI_COMM_WORLD, &pid);
	srand(10*pid*time(NULL));
	int num = rand()%50+1;
	printf("tid is: %d num=%d \n",pid,num);
	MPI_Reduce(&num,&sum,1,MPI_INT,MPI_SUM,0,MPI_COMM_WORLD);	//add all the numbers and store in sum
	if (pid == MASTER)
	{
		 float avg =(float) sum / p;
		printf("sum is: %d \n", sum);
		printf("avg is: %.2f \n", avg);
	}
	MPI_Finalize();
}