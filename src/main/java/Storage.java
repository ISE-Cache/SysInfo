import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OSFileStore;

import java.util.ArrayList;
import java.util.List;

public class Storage implements DataProvider {

    private final SystemInfo systemInfo;
    private final List<HWDiskStore> diskStats;
    private final OSFileStore fileStore;

    public Storage(){
        systemInfo = new SystemInfo();
        diskStats = systemInfo.getHardware().getDiskStores();
        fileStore = systemInfo.getOperatingSystem().getFileSystem().getFileStores().getFirst();
    }

    @Override
    public String getName()
    {
        return diskStats.getFirst().getName();
    }

    @Override
    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>();

        data.add(diskStats.getFirst().getModel());
        data.add(diskStats.getFirst().getSerial());
        data.add(diskStats.getFirst().getPartitions().toString());

        data.add(diskStats.getLast().getModel());
        data.add(diskStats.getLast().getSerial());
        data.add(diskStats.getLast().getPartitions().toString());

        data.add(fileStore.getType());
        data.add(fileStore.getLabel());
        data.add(fileStore.getVolume());
        data.add(fileStore.getLogicalVolume());
        data.add(fileStore.getDescription());
        data.add(fileStore.getMount());
        data.add(fileStore.getOptions());
        data.add(fileStore.getUUID());

        return data;
    }

    @Override
    public boolean hasData()
    {
        return diskStats != null;
    }
}