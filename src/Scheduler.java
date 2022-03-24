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
    private List<Integer[]> resource;
    private static Scheduler scheduler;
    private Scheduler() {
        priorityQueue = new ArrayList<Queue<Integer>>(5);
        resource = new ArrayList<Integer[]>();
        for(int i = 0; i < 5; i++){
            priorityQueue.add(new LinkedList<Integer>());
        }
        for(int i = 0; i < 10; i++){
            resource.add(new Integer[]{0, 0});
        }
    }

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            scheduler = new Scheduler();
        }
        return scheduler;
    }

    @Override
    public String toString() {
        StringBuilder resourcesString = new StringBuilder();
        for(int i = 0; i < 5; i++){
            resourcesString
                    .append(resource.get(i)[0])
                    .append(", ")
                    .append( resource.get(i)[1])
                    .append("\n");
        }
        return resourcesString.toString();
    }
}
