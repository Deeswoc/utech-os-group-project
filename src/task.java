import java.util.ArrayList;





public class task {
    private int taskId;
    private int data;
    private int priority;

    //private ArrayList <Integer> sharedList;  

    public task() {
        taskId=0;
        priority=0;
    }

    public task(int taskId, int data ,int priority) {
        this.taskId = taskId;
        this.priority = priority;
        this.data=data;
    }

    //Accessors for Task Attributes
    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.taskId = data;
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
    ArrayList <task> resourcelist = new ArrayList<>();
    public void addRecord(){
        int Id= getRandomId();
        int data=getRandomData();
        int[] list={Id,data};
        for (int i = 0; i < list.length ;i+=2) {
             task shared= new task(list[i], list[i+1],1);
             resourcelist.add(shared);  
        }
        System.out.println(resourcelist);
        
    }

    //function to match the Id or data property within the ArrayList
    public boolean match(int item) {
        if (item==taskId) {
            return true;
        }else{
            return false;
        }   
            
    }

    //Remove Record from resource list  
    public void removeRecord(){
    int item=getRandomId();
       for(task Task: resourcelist){
           if (Task.match(item)) {
               resourcelist.remove(Task); 
           }
        }
        resourcelist.toString();
    }

    // Retrieve record from within resource list and displays it
    public void retrieveRecord(){
        int item=getRandomId();

        for (task Task: resourcelist) {
            if (Task.getTaskId()==item) {
                Task.resourcelist.toString();
            } else {
                System.out.println("error");
                
            } 
        }
    }

    //Calculate all data values in the data list
    public void calculateAllData(){
        int total=0;
        for (task Task : resourcelist) {
            total+= Task.getData();
        }

        System.out.println(total);
    }

    //Display function to display attribbutes and methods
    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", data='" + getData() + "'" +
            ", priority='" + getPriority() + "'" +
            "}";
    }
    


    
}

