import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Driver {
    public static void main(String[] args){
        System.out.println("Hello World");
        ConcurrentHashMap resourceList = Resource.getResources();
        System.out.print(resourceList.entrySet().toString());


//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        for(int i = 0 ; i < 20; i++){
//            List<Integer> l = new ArrayList<Integer>();
//            l.add(0);
//            l.add(0);
//            res.add(l);
//        }
//        System.out.print("Resource #1: " + resourceList.get(1));
//
//        for(int i = 0 ; i < 20; i++){
//            System.out.println(i +"="+ res.get(i));
//        }
        Processor p1 = new Processor();
        Processor p2 = new Processor();
        Processor[] processors = new Processor[]{p1, p2};


        Scheduler scheduler = Scheduler.getScheduler();
        scheduler.setProcessors(processors);
        scheduler.printProcesses();
        scheduler.startSystem();
//        scheduler.printProcesses();

        
       


        


        
      



        

        

    }
}
