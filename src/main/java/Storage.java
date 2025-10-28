import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import java.util.ArrayList;
import java.util.List;

public class Storage implements DataProvider
{
    private final SystemInfo systemInfo;
    private final List<HWDiskStore> diskStats;

    public Storage()
    {
        systemInfo = new SystemInfo();
        diskStats = systemInfo.getHardware().getDiskStores();
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

        for (HWDiskStore disk : diskStats)
        {
            data.add(disk.getName());
            data.add(disk.getModel());
            data.add(disk.getSerial());
            data.add(disk.getPartitions().toString());
        }

        return data;
    }

    @Override
    public boolean hasData()
    {
        return diskStats != null;
    }
}