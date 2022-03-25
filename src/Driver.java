
public class Driver {
    public static void main(String[] args){
        System.out.println("Hello World");
        System.out.println(Scheduler.getScheduler().toString());



        //Test purpose add record method displayed below:
        task t1 = new task(1,1);
        t1.addRecord();
        

        

    }
}
