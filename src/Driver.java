import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Driver {
    public static void main(String[] args){
        System.out.println("Hello World");
        task.initializeSharedList();
        task.printSharedList();
        ConcurrentHashMap resourceList = Resource.getResources();

        Processor p1 = new Processor();
        Processor p2 = new Processor();
        Processor[] processors = new Processor[]{p1, p2};


        Scheduler scheduler = Scheduler.getScheduler();
        scheduler.setProcessors(processors);
        scheduler.startSystem();

        task.printSharedList();

       scheduler.printProcesses();

        
       


        


        
      



        

        

    }
}
