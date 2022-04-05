import java.util.ArrayList;



public class task {
    private int taskId;
    private ArrayList <Integer> sharedlist= new ArrayList<Integer>(20);

    public task() {
    }

    public task(int taskId, ArrayList<Integer> sharedlist) {
        this.taskId = taskId;
        this.sharedlist = sharedlist;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public ArrayList<Integer> getSharedlist() {
        return this.sharedlist;
    }

    public void setSharedlist(ArrayList<Integer> sharedlist) {
        this.sharedlist = sharedlist;
    }

    public task taskId(int taskId) {
        setTaskId(taskId);
        return this;
    }

    public task sharedlist(ArrayList<Integer> sharedlist) {
        setSharedlist(sharedlist);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", sharedlist='" + getSharedlist() + "'" +
            "}";
    }


    
}

