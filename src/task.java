import java.util.ArrayList;


public class task {
    private int taskId;
    private int priority;
    //private ArrayList <Integer> sharedList;  

    public task() {
        taskId=0;
        priority=0;
    }

    public task(int taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
        //this.sharedList = sharedList;
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


    //Mutators for task class attributes

    public void setPriority(int priority) {
        this.priority = priority;
    }


    public task taskId(int taskId) {
        setTaskId(taskId);
        return this;
    }

    public task priority(int priority) {
        setPriority(priority);
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

        int[] list={Id,data};
        ArrayList <sharedList> resource = new ArrayList<>();
        for (int i = 0; i < list.length ;i+=2) {
             sharedList shared= new sharedList(list[i], list[i+1]);
             resource.add(shared);
            
        }

        System.out.println(resource);
    }


    //Display function to display attribbutes and methods
    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() +
            ", priority='" + getPriority() +
            "}";
    }

    
}


//Shared list class to implement a custom ArrayList Object
class sharedList{
     int Id;
     int data;
    public sharedList(int Id, int data) {
        this.Id = Id;
        this.data = data;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  getId() + "," +getData() ;
    }
}

