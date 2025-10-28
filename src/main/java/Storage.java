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
            data.add("\nName: " + disk.getName());
            data.add("\nModel: " + disk.getModel());
            data.add("\nSerial: " + disk.getSerial());
            data.add("\nPartitions: " + disk.getPartitions().toString());
        }

        return data;
    }

    @Override
    public boolean hasData()
    {
        return diskStats != null;
    }
}