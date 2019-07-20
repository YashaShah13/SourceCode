#include <mpi.h>
#include <stdio.h>
#include<stdlib.h>
#define MASTER 0					//define master procesor rank as 0
int main(int argc, char** argv) {
	
	MPI_Status stat;
	MPI_Init(&argc,&argv);

	int p,tag=1,sum=0,temp,avg=0;
	MPI_Comm_size(MPI_COMM_WORLD, &p); //total nmber of processors
	int pid;
	MPI_Comm_rank(MPI_COMM_WORLD, &pid); //rank of each processor

	int num = (rand() % 300) + 200;
	
	MPI_Send(&num, 1, MPI_INT, MASTER, tag, MPI_COMM_WORLD);// All processors send data to master

	if (pid == MASTER)
	{
		for (int i = 0; i < p; i++)
		{
			MPI_Recv(&temp, 1, MPI_INT, pid,tag,MPI_COMM_WORLD,&stat);		//master receives data from all processor
			sum = sum + temp;
		}
		avg = sum / p;
		printf("avg=%d", avg);
	}

	MPI_Finalize();
}