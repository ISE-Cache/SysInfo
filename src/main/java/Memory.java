import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

import java.util.ArrayList;

public class Memory implements DataProvider {
    private final GlobalMemory globalMemory;

    public Memory() {
        SystemInfo systemInfo = new SystemInfo();
        globalMemory = systemInfo.getHardware().getMemory();
    }

    @Override
    public String getName() {
        return "Memory";
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();

        data.add("Total Memory: " + FormatUtil.formatBytes(globalMemory.getTotal()));
        data.add("Available Memory: " + FormatUtil.formatBytes(globalMemory.getAvailable()));
        data.add("Memory Page Size: " + FormatUtil.formatBytes(globalMemory.getPageSize()));

        data.add("Physical Memory: " + globalMemory.getPhysicalMemory());

        data.add("Virtual Memory Maximum: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getVirtualMax()));
        data.add("Virtual Memory In Use: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getVirtualInUse()));

        data.add("Virtual Memory: " + globalMemory.getVirtualMemory());
        data.add("Swap Total: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapTotal()));
        data.add("Swap Used: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapUsed()));
        data.add("Swap Pages In: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapPagesIn()));
        data.add("Swap Pages Out: " + FormatUtil.formatBytes(globalMemory.getVirtualMemory().getSwapPagesOut()));

        return data;
    }

    @Override
    public boolean hasData() {
        return globalMemory != null;
    }
}