import java.util.ArrayList;


public class task {
    private int taskId;
    private int priority;
    private ArrayList <Integer> sharedList;  

    public task() {
        taskId=0;
        priority=0;
    }

    public task(int taskId, int priority, ArrayList<Integer> sharedList) {
        this.taskId = taskId;
        this.priority = priority;
        this.sharedList = sharedList;
    }

    //Accessors for Task Attributes
    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getPriority() {
        return this.priority;
    }

    public ArrayList<Integer> getSharedList() {
        return this.sharedList;
    }


    //Mutators for task class attributes

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSharedList(ArrayList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    public task taskId(int taskId) {
        setTaskId(taskId);
        return this;
    }

    public task priority(int priority) {
        setPriority(priority);
        return this;
    }

    public task sharedList(ArrayList<Integer> sharedList) {
        setSharedList(sharedList);
        return this;
    }


    //Randomly generates resource Id 
    public int getRandomId(){
        int randNum = (int)(Math.random()*(20-1+1)+1);
        return randNum;
    }
    
    //Randomly Generates Resources resource data (1-100)
    public int getRandomData(){
        int randNum = (int)(Math.random()*(100-1+1)+1);
        return randNum;
    }

    //Task directive to Add Record to the resource list
    public void addRecord(){
        int Id= getRandomId();
        int data=getRandomData();
        sharedList.add(Id);
        sharedList.add(data);
        System.out.println(sharedList);

    }


    //Display function to display attribbutes and methods
    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", priority='" + getPriority() + "'" +
            ", sharedList='" + getSharedList() + "'" +
            "}";
    }
    
}

