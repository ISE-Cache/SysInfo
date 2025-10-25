import oshi.SystemInfo;
import oshi.hardware.platform.linux.LinuxHardwareAbstractionLayer;

import java.util.ArrayList;

public class Storage implements DataProvider {

    private final SystemInfo systemInfo;

    public Storage(){
        systemInfo = new SystemInfo();
    }

    @Override
    public String getName()
    {
        return "";
    }

    @Override
    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>();

        //data.add(hardware.getDiskStores().toString());

        return data;
    }

    @Override
    public boolean hasData()
    {
        return false;
    }
}