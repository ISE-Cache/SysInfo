import oshi.software.os.OperatingSystem;
import oshi.SystemInfo;
import java.util.ArrayList;

public class ProcessCount implements DataProvider{
    private int processCount;
    private int threadCount;

    public ProcessCount() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        this.processCount = operatingSystem.getProcessCount();
        this.threadCount = operatingSystem.getThreadCount();
    }

    @Override
    public String getName() {
        return "\u001B[33mProcess Count";
    }//end of getName

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> processdata = new ArrayList<>();
        processdata.add("Total running processes: " + processCount);
        processdata.add("Total threads: "+ threadCount);
        return processdata;
    }//end of getData

    @Override
    public boolean hasData() {
        return ((processCount >0) && (threadCount >0));
    }
}