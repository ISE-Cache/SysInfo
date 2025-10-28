import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PCIProvider implements DataProvider {
    private long deviceCount = 0;

    public PCIProvider() {
        try (Stream<String> lines = Files.lines(Path.of("/proc/bus/pci/devices"))) {
            deviceCount = lines.count();
        } catch (IOException ignored) {
        }
    }

    @Override
    public String getName() {
        return "PCI";
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("PCI Device Count: " + deviceCount);
        return data;
    }

    @Override
    public boolean hasData() {
        return deviceCount > 0;
    }
}
