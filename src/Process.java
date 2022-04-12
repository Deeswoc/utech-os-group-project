import java.util.Random;
//import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("unused")
public class Process implements Comparable<Process> {

    private int PID;
    private task Task;
    private boolean started = false;
    private int priority;
    private int ArrivalTime;
    private int BurstTime;
    private int CPUTime = 0;
    private LocalTime StartTime;
    private LocalTime EndTime;
    private int BlockTime;
    private DateTimeFormatter dtf;
    public static int processCount = 0;


    public Process() {
        processCount++;
        this.PID = processCount;
        // Random number Generator for Arrival Time 0 - 29
        Random arrivaTime = new Random();
        int ATmax = 29;
        ArrivalTime = arrivaTime.nextInt(ATmax);

        // Random number Generator for Burst Time 1 - 5
        Random burstTime = new Random();
        int BTmax = 5;
        BurstTime = burstTime.nextInt(BTmax) + 1;

        Task = new task();

        // Random number Generator for Priority 1 - 5
        Random Priority = new Random();
        int pmax = 5;
        priority = Priority.nextInt(pmax) + 1;


        // Date formatter capturing system time
        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        StartTime = LocalTime.now();
        dtf.format(StartTime);
        EndTime = LocalTime.now();
        dtf.format(EndTime);


        // Array List for Process ID adding unique process ID's
    }

    public Process(int pid, int Priority, int AT, int BT, LocalTime ST, LocalTime ET, int BlockT) {
        PID = pid;
        priority = Priority;
        ArrivalTime = AT;
        BlockTime = BlockT;
        BurstTime = BT;
        StartTime = ST;
        EndTime = ET;

    }

    public void SetPID(int pid) {
        PID = pid;
    }

    public int GetPid() {
        return PID;
    }

    public void SetPriority(int Priority) {

        priority = Priority;
    }

    public int GetPriority() {

        return priority;
    }

    public void SetArrivalTime(int AT) {

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


    public void Task() {

        Random Rand = new Random();
        int max = 3;
        int TaskSelect = Rand.nextInt(max);


        if (TaskSelect == 0) {

            System.out.println("add task");
        }
        if (TaskSelect == 1) {
            System.out.println("remove task");
        }
        if (TaskSelect == 2) {

            System.out.println("delete task");
        }
        if (TaskSelect == 3) {
            System.out.println("calulate data");
        }
    }


    public void Display() {
        System.out.println("Process ID: " + PID);
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


    @Override
    public int compareTo(Process o) {

        if (this.GetArrivalTime() > o.GetArrivalTime()) {
            return 1;
        } else if (this.GetArrivalTime() < o.GetArrivalTime()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {

        return "PID: " + this.GetPid() + " \nArrival Time: " + this.GetArrivalTime() + "\n" + "Burst Time:" + this.GetBurstTime() + "\nPriority: "  + this.priority;
    }

    public int getCPUTime() {
        return CPUTime;
    }

    public boolean start() {
        if (!started) {
            started = true;
            Task.runMethod();
            return true;
        } else {
            return false;
        }
    }

    public int incrementCPUTime() {
        return CPUTime++;
    }
}
