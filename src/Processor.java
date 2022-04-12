public class Processor {
    private Process runningProcess;
    private int semaphore;
    public Processor() {

    }

    public Process getRunningProcess() {
        return runningProcess;
    }

    public void setRunningProcess(Process runningProcess) {
        this.runningProcess = runningProcess;
    }

    public Process pop() {
        System.out.println("Removing PID: " + runningProcess.GetPid() + " from processor");
        Process outgoing = runningProcess;
        this.runningProcess = null;
        return outgoing;
    }

    public void run() {
        //Do a thing
    }
}
