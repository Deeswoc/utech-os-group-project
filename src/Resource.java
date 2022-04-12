import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Resource {
    private static int initial_count = 20;
    private static int current_count = 0;
    private static ConcurrentHashMap<Integer, List<Integer>> sharedlist;

    private Resource(){

    }

    static public ConcurrentHashMap<Integer, List<Integer>> getResources(){

        if(sharedlist==null){
            sharedlist = new ConcurrentHashMap<Integer, List<Integer>>();
            for(int i = 0; i < initial_count; i++){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(0);
                temp.add(0);
                sharedlist.put(i, temp);
            }
        }
        return sharedlist;
    }

}
