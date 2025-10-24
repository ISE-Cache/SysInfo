import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.ProcessorCache;

import java.util.ArrayList;

public class CPUDataProvider implements DataProvider {

    private final SystemInfo systemInfo;
    private final CentralProcessor processor;

    public CPUDataProvider() {
        systemInfo = new SystemInfo();
        processor = systemInfo.getHardware().getProcessor();
    }

    @Override
    public String getName() {
        // Return actual CPU name
        return processor.getProcessorIdentifier().getName();
    }


    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();

        data.add("Physical cores: " + processor.getPhysicalProcessorCount());

        // virtual cores created by technologies like Hyper-Threading
        data.add("Logical CPUs: " + processor.getLogicalProcessorCount());

        // identifies your CPU model, vendor, and architecture.
        data.add("Processor Identifier: " + processor.getProcessorIdentifier().getIdentifier());

        //company that made the CPU
        data.add("Vendor: " + processor.getProcessorIdentifier().getVendor());

        //A grouping of processors with similar architecture.
        data.add("Family: " + processor.getProcessorIdentifier().getFamily());

        data.add("Model: " + processor.getProcessorIdentifier().getModel());
        data.add("Stepping: " + processor.getProcessorIdentifier().getStepping());

        for (ProcessorCache Cache : processor.getProcessorCaches()) {
            data.add("Cache Level: " + Cache.getLevel());
            data.add("Cache Name: " + Cache.getCacheSize() + "Bytes");
        }


        return data;
    }

    @Override
    public boolean hasData() {

        return processor != null;  // checks if the processor variable is actually filled / fetched processor info
    }
}



