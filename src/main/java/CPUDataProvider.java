import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.ProcessorCache;

import java.util.ArrayList;
import java.util.HashMap;

public class CPUDataProvider implements DataProvider {

    private final CentralProcessor processor;

    public CPUDataProvider() {
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

        // virtual cores created by technologies like Hyper-Threading
        data.add("Logical CPUs: " + processor.getLogicalProcessorCount());

        // TODO: Join cache sizes by level
        var levels = new long[((int)Byte.MAX_VALUE) + 1];
        for (ProcessorCache Cache : processor.getProcessorCaches()) {
            levels[Cache.getLevel()] += Cache.getCacheSize();
        }

        for (int level = 0; level < levels.length; level++) {
            var size = levels[level];
            if (size == 0) continue;
            String formattedSize = size >= 1024 ? String.format("%d KB", size / 1024) : String.format("%d B", size);
            data.add("\nCache Level: " + level);
            data.add("Cache Size: " + formattedSize);
        }


        return data;
    }

    @Override
    public boolean hasData() {
        return processor != null;  // checks if the processor variable is actually filled / fetched processor info
    }
}



