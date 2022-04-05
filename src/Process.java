
import java.util.ArrayList;

import java.util.Random;
//import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



@SuppressWarnings("unused")
public class Process {
	
	private ArrayList<Integer> PID;
	private task Task;
	private int priority;
	private int ArrivalTime;
	private int BurstTime;
	private LocalTime StartTime;
	private LocalTime EndTime;
	private int BlockTime;
	private DateTimeFormatter dtf;
	
	

	public Process() {
		
		// Random number Generator for Arrival Time 0 - 29
		Random arrivaTime = new Random();
		int ATmax = 29;
		ArrivalTime = arrivaTime.nextInt(ATmax);
		
		// Random number Generator for Burst Time 1 - 5
		Random burstTime = new Random();
		int BTmax = 5;
		BurstTime =  burstTime.nextInt(BTmax) +1 ;
		
		
		// Random number Generator for Priority 1 - 5
		Random Priority = new Random();
		int pmax = 5;
		priority =  Priority.nextInt(pmax) +1 ;
				
		
		// Date formatter capturing system time
		 dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		 StartTime = LocalTime.now();
		 dtf.format(StartTime);
		 EndTime = LocalTime.now();
		 dtf.format(EndTime);
		 
		 
		 // Array List for Process ID adding unique process ID's
		 PID = new ArrayList<Integer>();
		 PID.add(1);
		 PID.add(2);
		 PID.add(3);
		 PID.add(4);
		 PID.add(5);
		 PID.add(7);
		 PID.add(8);
		 PID.add(9);
		 PID.add(10);
		 PID.add(11);
		 PID.add(12);
		 PID.add(13);
		 PID.add(14);
		 PID.add(15);
		 PID.add(16);
		 PID.add(17);
		 PID.add(18);
		 PID.add(19);
		 PID.add(20);
		 
		 
	}
	
	public Process(ArrayList<Integer> pid, int Priority,int AT, int BT, LocalTime ST, LocalTime ET, int BlockT){	
		PID = pid;
		priority = Priority;
		ArrivalTime = AT;
		BlockTime = BlockT;
		BurstTime = BT;
		StartTime = ST;
		EndTime= ET;
		
	}
	
	public void SetPID(ArrayList<Integer> pid) {
		
		PID = pid;
	}
	
	public ArrayList<Integer> GetPid(){
		return PID;
	}
	
	public void SetPriority( int Priority) {
		
		priority = Priority;
	}
	
	public int GetPriority() {
		
		return priority;
	}
	
	public void SetArrivalTime(int AT ) {
		
		ArrivalTime = AT;
		
	} 
	
	public int GetArrivalTime() {
		return ArrivalTime; 
	}
	
	public int GetBurstTime() {
		return BurstTime;
	}

	public void SetBurstTime(int burstTime) {
		BurstTime = burstTime;
	}

	public LocalTime GetStartTime() {
		return StartTime;
	}

	public void SetStartTime(LocalTime startTime) {
		StartTime = startTime;
	}

	public LocalTime GetEndTime() {
		return EndTime;
	}

	public void SetEndTime(LocalTime endTime) {
		EndTime = endTime;
	}

	public int GetBlockTime() {
		return BlockTime;
	}

	public void SetBlockTime(int blockTime) {
		BlockTime = blockTime;
	}
	
	
	
	public void Task()
	{
		
		Random Rand = new Random();
		int max = 3;
		int TaskSelect = Rand.nextInt(max);
		
		
		if(TaskSelect == 0)
		{
			
			System.out.println("add task");
		}
		if(TaskSelect == 1)
		{
			System.out.println("remove task");
		}
		if(TaskSelect == 2)
		{
			
			System.out.println("delete task");
		}
		if(TaskSelect == 3)
		{
			System.out.println("calulate data");
		}
	}
	
	
	
	
	public void Display()
	{
		System.out.println("Process ID: " + PID.get(0));
		System.out.println("Priority: " + priority);
		System.out.println("Arrival Time: " + ArrivalTime);
		System.out.println("Burst Time: " + BurstTime);
		System.out.println("Start Time: " + dtf.format(StartTime));
		System.out.println("End Time: " + dtf.format(EndTime));
		System.out.println("Block Time: " + BlockTime);
	}

	
	
	////////////////// ***********************Main**************************** \\\\\\\\\\\\\\\\\\\\\\\\
	
	
	public static void main(String[] args) {
	
		
		
		Process p = new Process();
		
		//p.GetArrivalTime();
		
		
		p.Display();
	//System.out.println(p);
		
		
	//	p.Task();

	}


	
	

}
