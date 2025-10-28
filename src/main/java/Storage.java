import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OSFileStore;

import java.util.ArrayList;
import java.util.List;

public class Storage implements DataProvider {

    private final SystemInfo systemInfo;
    private final List<HWDiskStore> diskStats;
    //private final OSFileStore fileStore;

    public Storage(){
        systemInfo = new SystemInfo();
        diskStats = systemInfo.getHardware().getDiskStores();
        //fileStore = systemInfo.getOperatingSystem().getFileSystem().getFileStores();
    }

    @Override
    public String getName()
    {
        return "Storage";
    }

    @Override
    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>();

        data.add("First Disk Model: " + diskStats.getFirst().getModel());
        data.add("Serial: " + diskStats.getFirst().getSerial());
        data.add("Partitions: " + diskStats.getFirst().getPartitions().toString());

        data.add("Last Disk Model: " + diskStats.getLast().getModel());
        data.add("Serial: " + diskStats.getLast().getSerial());
        data.add("Partitions: " + diskStats.getLast().getPartitions().toString());

        return data;
    }

    @Override
    public boolean hasData()
    {
        return diskStats != null;
    }
}