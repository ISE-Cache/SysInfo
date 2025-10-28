import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.ProcessorCache;

import java.util.ArrayList;

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
        for (ProcessorCache Cache : processor.getProcessorCaches()) {
            data.add("\nCache Level: " + Cache.getLevel());

            long sizeInKB = Cache.getCacheSize() / 1024;
            data.add("Cache Size: " + sizeInKB + " KB");
        }


        return data;
    }

    @Override
    public boolean hasData() {
        return processor != null;  // checks if the processor variable is actually filled / fetched processor info
    }
}



