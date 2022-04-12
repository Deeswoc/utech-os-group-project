import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scheduler {
    // TODO - just doing the outline of the scheduler.
    //  The actual classes can be implemented later.
    //  Just getting data structures set up
    List<Queue<Integer>> priorityQueue;
    private Object[] processors;
    private List<Process> processes;
    private List<Integer[]> resources;
    private static Scheduler scheduler;
    private Queue<Process> readyQueue;
    private Scheduler() {
        processes = new ArrayList<Process>();
        priorityQueue = new ArrayList<Queue<Integer>>(5);
        resources = new ArrayList<Integer[]>();
        for(int i = 0; i < 5; i++){
            priorityQueue.add(new LinkedList<Integer>());
        }

        for(int i = 0; i < 20; i++){
            Process process = new Process();
            processes.add(process);
        }
        for(int i = 0; i < 10; i++){
            resources.add(new Integer[]{0, 0});
        }
    }

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            scheduler = new Scheduler();
        }
        return scheduler;
    }

    public void printProcesses(){
        for(int i = 0; i < 20; i++){
            System.out.println("PID: " + processes.get(i).GetPid());
        }
    }

    @Override
    public String toString() {
        StringBuilder resourcesString = new StringBuilder();
        for(int i = 0; i < 5; i++){
            resourcesString
                    .append(resources.get(i)[0])
                    .append(", ")
                    .append( resources.get(i)[1])
                    .append("\n");
        }
        return resourcesString.toString();
    }

    public void printResources(){
        for(int i = 0; i < resources.size(); i++){

        }
    }
}
