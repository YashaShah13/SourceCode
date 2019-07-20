#include <mpi.h>
#include <stdio.h>
#include<stdlib.h>
#include<time.h>
#define MASTER 0
int main(int argc, char** argv) {
	
	MPI_Status stat[4];
	MPI_Init(&argc,&argv);
	int p,tag=1,sum=0,temp,np;		// variables in each processors
	float avg;						//
	MPI_Comm_size(MPI_COMM_WORLD, &p); // get total number of processors available
	np=p;
	int pid;
	

	MPI_Comm_rank(MPI_COMM_WORLD, &pid); // get rank of each processor
	srand(10*pid*time(NULL));
	int num = rand()%50+1;				// Each processor will generate one random number
	MPI_Barrier (MPI_COMM_WORLD); // wait for all processor to reach at this point
	printf("pid=%d generated num=%d \n",pid,num);
	MPI_Barrier (MPI_COMM_WORLD);
	int mid = p / 2; 
	while(p!=1) 
	{
		if (pid < mid)   //half of processors will recieve from other half
		{
			temp = num;
			MPI_Recv(&num, 1, MPI_INT, mid + pid, tag, MPI_COMM_WORLD, &stat[pid]);
			num=temp+num;

		}

		else if(pid<p)		//half of processors will send to other half
		{
			MPI_Send(&num, 1, MPI_INT, pid - mid, tag, MPI_COMM_WORLD);
		}
		

		p=mid;
		mid=mid/2;
		
	}

	MPI_Barrier (MPI_COMM_WORLD);
	printf("pid=%d after receive operations num=%d \n", pid, num);
	MPI_Barrier (MPI_COMM_WORLD);
	if(pid==MASTER)
	{
	avg=(float)num/np;
	printf("avg = %f \n",avg);
	}

	MPI_Finalize();
}