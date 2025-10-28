import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.ProcessorCache;
import oshi.util.FormatUtil;

import java.util.ArrayList;

public class CPUProvider implements DataProvider {

    private final CentralProcessor processor;

    public CPUProvider() {
        SystemInfo systemInfo = new SystemInfo();
        processor = systemInfo.getHardware().getProcessor();
    }

    @Override
    public String getName() {
        return "CPU";
    }


    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        // identifies your CPU model, vendor, and architecture.
        data.add("Processor Identifier: " + processor.getProcessorIdentifier().getIdentifier());

        data.add("Physical cores: " + processor.getPhysicalProcessorCount());

        // virtual cores created by technologies like Hyper-Threading(Intel) or SMT(AMD)
        data.add("Logical CPUs: " + processor.getLogicalProcessorCount());

        // Total CPU cache size by level (L1, L2, L3, etc.)
        var levels = new long[((int) Byte.MAX_VALUE) + 1];
        for (ProcessorCache cache : processor.getProcessorCaches()) {
            levels[cache.getLevel()] += cache.getCacheSize();
        }

        for (int level = 0; level < levels.length; level++) {
            var size = levels[level];
            if (size == 0) continue;
            data.add("\nCache Level: " + level);
            data.add("Cache Size: " + FormatUtil.formatBytes(size));
        }

        return data;
    }

    @Override
    public boolean hasData() {
        return processor != null;  // checks if the processor variable is actually filled / fetched processor info
    }
}



