import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

import java.util.ArrayList;
import java.util.List;

public class StorageProvider implements DataProvider {
    private final List<HWDiskStore> diskStats;

    public StorageProvider() {
        SystemInfo systemInfo = new SystemInfo();
        diskStats = systemInfo.getHardware().getDiskStores();
    }

    @Override
    public String getName() {
        return "Storage";
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();

        for (HWDiskStore disk : diskStats) {
            data.add("Name: " + disk.getName());
            data.add("Model: " + disk.getModel());
            data.add("Serial: " + disk.getSerial());
            data.add("Partitions: " + disk.getPartitions().toString());
        }

        return data;
    }

    @Override
    public boolean hasData() {
        return diskStats != null;
    }
}