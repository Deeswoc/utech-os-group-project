import java.util.*;

public class Scheduler {
    // TODO - just doing the outline of the scheduler.
    //  The actual classes can be implemented later.
    //  Just getting data structures set up
    List<Queue<Integer>> priorityQueue;
    private Processor[] processors;
    private Queue<Process> processes;
    private List<Integer[]> resources;
    private static Scheduler scheduler;
    private int CPUclock = 0;
    private final int quantum = 4;
    private char semaphore;
    private Queue<Process> readyQueue;
    private Queue<Process> pq1;
    private Queue<Process> pq2;
    private Queue<Process> pq3;
    private Queue<Process> pq4;
    private Queue<Process> pq5;
    private Queue<Process> ioQueue;
    private Queue<Process> blocked;
    private Queue<Process> completed;
    private boolean queuesEmpty = true;

    private Scheduler() {
        List temp = new ArrayList<Process>();
        priorityQueue = new ArrayList<Queue<Integer>>(5);
        resources = new ArrayList<Integer[]>();
        for (int i = 0; i < 5; i++) {
            priorityQueue.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < 20; i++) {
            Process process = new Process();

            temp.add(process);

        }

        Collections.sort(temp);
        processes = new LinkedList<Process>(temp);
        for (int i = 0; i < 10; i++) {
            resources.add(new Integer[]{0, 0});
        }
        readyQueue = new LinkedList<Process>();
        pq1 = new LinkedList<Process>();
        pq2 = new LinkedList<Process>();
        pq3 = new LinkedList<Process>();
        pq4 = new LinkedList<Process>();
        pq5 = new LinkedList<Process>();
        ioQueue = new LinkedList<Process>();
        blocked = new LinkedList<Process>();
        completed = new LinkedList<Process>();
    }

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            scheduler = new Scheduler();
        }
        return scheduler;
    }

    public void printProcesses() {
        Process process = null;
        System.out.println(processes);
    }

    @Override
    public String toString() {
        StringBuilder resourcesString = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            resourcesString
                    .append(resources.get(i)[0])
                    .append(", ")
                    .append(resources.get(i)[1])
                    .append("\n");
        }
        return resourcesString.toString();
    }

    public Processor[] getProcessors() {
        return processors;
    }

    public void checkPriorityQueues() {
        System.out.println();
    }

    public void setProcessors(Processor[] processors) {
        this.processors = processors;
    }

    public void printResources() {
        for (int i = 0; i < resources.size(); i++) {

        }
    }


    public void startSystem() {
        boolean run = true;
        System.out.println("All Processes       :" + processes);
        System.out.println("All Processes Count : " + processes.size());

        while (run) {

            System.out.println("Time: " + CPUclock);
            while (!processes.isEmpty() && processes.peek().GetArrivalTime() == CPUclock) {
                System.out.println("Adding process " + processes.peek().GetPid() + " to priority queue");
                queueProcess(processes.poll());
            }

            if (processors[0].getRunningProcess() == null) {
                System.out.println("Loading Processor1");
                loadProcessor(processors[0]);
            }

            if (processors[1].getRunningProcess() == null) {
                System.out.println("Loading Processor2");
                loadProcessor(processors[1]);
            }

            if (processors[0].getRunningProcess() != null &&
                    processors[0].getRunningProcess().incrementCPUTime() >= processors[0].getRunningProcess().GetBurstTime()) {
                completed.add(processors[0].pop());
            }

            if (processors[1].getRunningProcess() != null &&
                    processors[1].getRunningProcess().incrementCPUTime() >= processors[1].getRunningProcess().GetBurstTime()) {
                completed.add(processors[1].pop());
            }

            if (processes.isEmpty()) {
                run = false;
            }
            CPUclock++;
        }

        System.out.println("Completed Processes: " + completed.toString());
        System.out.println("Number of Processes: " + completed.size());

    }

    private void queueProcess(Process process) {
        switch (process.GetPid()) {
            case 1: {
                pq1.add(process);
                break;
            }
            case 2: {
                pq2.add(process);
                break;
            }
            case 3: {
                pq3.add(process);
                break;
            }
            case 4: {
                pq4.add(process);
                break;
            }
            case 5: {
                pq5.add(process);
                break;
            }
        }
        queuesEmpty = false;
    }

    private void loadProcessor(Processor processor) {
        if (!pq1.isEmpty()) {
            System.out.println("Getting PID: " + pq1.peek().GetPid() + " from PQ1");
            processor.setRunningProcess(pq1.poll());
        } else if (!pq2.isEmpty()) {
            System.out.println("Getting PID: " + pq2.peek().GetPid() + " from PQ2");
            processor.setRunningProcess(pq2.poll());
        } else if (!pq3.isEmpty()) {
            System.out.println("Getting PID: " + pq3.peek().GetPid() + " from PQ3");
            processor.setRunningProcess(pq3.poll());
        } else if (!pq4.isEmpty()) {
            System.out.println("Getting PID: " + pq4.peek().GetPid() + " from PQ4");
            processor.setRunningProcess(pq4.poll());
        } else if (!pq5.isEmpty()) {
            System.out.println("Getting PID: " + pq5.peek().GetPid() + " from PQ5");
            processor.setRunningProcess(pq5.poll());
        } else {
            queuesEmpty = true;
        }
    }


}
