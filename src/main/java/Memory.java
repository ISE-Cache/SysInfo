import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;
import java.util.ArrayList;

public class Memory implements DataProvider
{
    private final SystemInfo systemInfo;
    private final GlobalMemory globalMemory;

    public Memory()
    {
        systemInfo = new SystemInfo();
        globalMemory = systemInfo.getHardware().getMemory();
    }

    @Override
    public String getName(){
        return "\u001B[33mMemory";
    }

    @Override
    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>();

        data.add("\nTotal Memory: " + FormatUtil.formatBytes(globalMemory.getTotal()));
        data.add("\nAvailable Memory: " + FormatUtil.formatBytes(globalMemory.getAvailable()));
        data.add("\nMemory Page Size: " + FormatUtil.formatBytes(globalMemory.getPageSize()));

        data.add("\nPhysical Memory: " + globalMemory.getPhysicalMemory());

        data.add("\nVirtual Memory Maximum: " + globalMemory.getVirtualMemory().getVirtualMax());
        data.add("\nVirtual Memory In Use: " + globalMemory.getVirtualMemory().getVirtualInUse());

        data.add("\nVirtual Memory: " + globalMemory.getVirtualMemory());
        data.add("\nSwap Total: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapTotal()));
        data.add("\nSwap Used: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapUsed()));
        data.add("\nSwap Pages In: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapPagesIn()));
        data.add("\nSwap Pages Out: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapPagesOut()));

        return data;
    }

    @Override
    public boolean hasData()
    {
        return globalMemory != null;
    }
}