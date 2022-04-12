import java.util.concurrent.ConcurrentHashMap;

public class task {
    private int taskId;
    private static ConcurrentHashMap<Integer, Integer> sharedlist= new ConcurrentHashMap<>();
//    private static se

    public task(int taskId, ConcurrentHashMap<Integer,Integer> sharedlist) {
        this.taskId = taskId;
        this.sharedlist = sharedlist;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public ConcurrentHashMap<Integer,Integer> getSharedlist() {
        return this.sharedlist;
    }

    public void setSharedlist(ConcurrentHashMap<Integer,Integer> sharedlist) {
        this.sharedlist = sharedlist;
    }

    public task taskId(int taskId) {
        setTaskId(taskId);
        return this;
    }

    public task sharedlist(ConcurrentHashMap<Integer,Integer> sharedlist) {
        setSharedlist(sharedlist);
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
  

    //Shared list methods
    public void addRecord(){
        int Id= getRandomId();
        int data=getRandomData();
        sharedlist.put(Id, data);
    }

    //creating iterator to traverse hashmap
     
    //Rettrieve record from shared list
    public void retrieveRecord(){
        int id= getRandomId();
        for(ConcurrentHashMap.Entry<Integer,Integer> itr: sharedlist.entrySet()){
            if (itr.getKey().equals(id)) {
                System.out.println(itr.getValue());
            }
            
        }

    }
    //Remove record from shared list
    public ConcurrentHashMap<Integer,Integer> removeRecord(){
        int remove=0;
        int key=0;
        int id= getRandomId();

        for(ConcurrentHashMap.Entry<Integer,Integer> itr: sharedlist.entrySet()){
            if (itr.getKey().equals(id)) {
                remove= itr.getValue();
                key= itr.getKey();
                sharedlist.remove(remove);
                sharedlist.put(key, 0);
            }  
        }
        return sharedlist;
    }
    //calculate all data values of sharedlist
    public int calculateTotal(ConcurrentHashMap<Integer,Integer> sharedlist){
        int sum=0;
        for(ConcurrentHashMap.Entry<Integer,Integer> itr: sharedlist.entrySet()){
            sum=itr.getValue();
            sum++;  
        }
        return sum;
    }
    
    
    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", sharedlist='" + getSharedlist() + "'" +
            "}";
    }
   
}



