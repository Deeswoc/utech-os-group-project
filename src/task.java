import java.util.concurrent.ConcurrentHashMap;

public class task {
    private int taskId;
    private static ConcurrentHashMap<Integer, Integer> sharedlist = new ConcurrentHashMap<>();
    private static int sharedListSemaphore = 0;
    private boolean usingSharedList = false;
    private int usingResource = 0;
    private int type;
//    private static se

    public task(int taskId, ConcurrentHashMap<Integer, Integer> sharedlist) {
        this.taskId = taskId;
        this.type = (int) (Math.random() * (4) + 1);

    }



    public task() {
        this.taskId = (int) (Math.random() * (20) + 1);
        this.type = (int) (Math.random() * (4) + 1);
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public ConcurrentHashMap<Integer, Integer> getSharedlist() {
        return this.sharedlist;
    }

    public void setSharedlist(ConcurrentHashMap<Integer, Integer> sharedlist) {
        this.sharedlist = sharedlist;
    }

    public task taskId(int taskId) {
        setTaskId(taskId);
        return this;
    }

    public task sharedlist(ConcurrentHashMap<Integer, Integer> sharedlist) {
        setSharedlist(sharedlist);
        return this;
    }


    //Randomly generates resource Id
    public int getRandomId() {
        int randNum = (int) (Math.random() * (20 - 1 + 1) + 1);
        return randNum;
    }

    //Randomly Generates Resources resource data (1-100)
    public int getRandomData() {
        int randNum = (int) (Math.random() * (100 - 1 + 1) + 1);
        return randNum;
    }


    //Shared list methods
    public void addRecord() {
        int Id = getRandomId();
        int data = getRandomData();
        sharedlist.put(Id, data);
    }

    public static void printSharedList() {
        System.out.println("Shared List: " + sharedlist);
    }

    //creating iterator to traverse hashmap

    //Rettrieve record from shared list
    public void retrieveRecord() {
        int id = getRandomId();
        for (ConcurrentHashMap.Entry<Integer, Integer> itr : sharedlist.entrySet()) {
            if (itr.getKey().equals(id)) {
                System.out.println(itr.getValue());
            }

        }

    }

    //Remove record from shared list
    public ConcurrentHashMap<Integer, Integer> removeRecord() {
        int remove = 0;
        int key = 0;
        int id = getRandomId();

        for (ConcurrentHashMap.Entry<Integer, Integer> itr : sharedlist.entrySet()) {
            if (itr.getKey().equals(id)) {
                remove = itr.getValue();
                key = itr.getKey();
                sharedlist.remove(remove);
                sharedlist.put(key, 0);
            }
        }
        return sharedlist;
    }

    //calculate all data values of sharedlist
    public int calculateTotal(ConcurrentHashMap<Integer, Integer> sharedlist) {
        int sum = 0;
        for (ConcurrentHashMap.Entry<Integer, Integer> itr : sharedlist.entrySet()) {
            sum = itr.getValue();
            sum++;
        }
        return sum;
    }

    public int runMethod() {
        switch (this.type) {
            case 1: {
                //Add Record
                if (sharedListSemaphore == 0) {
                    sharedListSemaphore = 1;
                    int randRecId = (int) (Math.random() * (20) + 1);
                    int randRecData = (int) (Math.random() * (100) + 1);
                    sharedlist.put(randRecId, randRecData);
                    printSharedList();
                    return -1;
                }

                break;
            }
            case 2: {
                if (sharedListSemaphore == 0) {
                    int randRecId = (int) (Math.random() * (20) + 1);
                    int randRecData = (int) (Math.random() * (100) + 1);
                    sharedlist.put(randRecId, randRecData);
                    printSharedList();
                    return -1;
                }
                break;

            }
            case 3: {
                if (sharedListSemaphore == 0) {
                    int randRecId = (int) (Math.random() * (20) + 1);
                    Integer i = sharedlist.get(randRecId);
                    System.out.println("Resource #" + randRecId + " is " + i);
                    return -1;
                }
                break;

            }
            case 4: {
                if (sharedListSemaphore == 0) {
                    int sum = 0;
                    for (int i = 0; i < sharedlist.size(); i++) {
                        sum += sharedlist.get(i);
                    }
                    System.out.println("The total of all the resources is : " + sum);
                    printSharedList();
                    return -1;
                }
                break;

            }

        }
        return 0;
    }

    public int release() {
        if (usingSharedList) {
            this.usingSharedList = false;
            sharedListSemaphore--;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                " taskId='" + getTaskId() + "'" +
                ", sharedlist='" + getSharedlist() + "'" +
                "}";
    }

    public static void initializeSharedList() {
        for (int i = 0; i < 20; i++) {
            sharedlist.put(i, 0);
        }
    }

}



