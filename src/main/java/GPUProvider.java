import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;

import java.util.ArrayList;
import java.util.List;

public class GPUProvider implements DataProvider {
    private final List<GraphicsCard> cards;

    public GPUProvider() {
        final var systemInfo = new SystemInfo();
        cards = systemInfo.getHardware().getGraphicsCards();
    }

    @Override
    public String getName() {
        return "GPU";
    }

    @Override
    public ArrayList<String> getData() {
        final var data = new ArrayList<String>();
        boolean first = true;
        for (final var card : cards) {
            if (!first) {
                // Add an empty line between multiple GPUs
                data.add("");
            }
            first = false;
            data.add("Name: " + card.getName());
            data.add("Vendor: " + card.getVendor());
            data.add("VRAM: " + Util.readableSize(card.getVRam()));
            data.add("Version Info: " + card.getVersionInfo());
        }
        return data;
    }

    @Override
    public boolean hasData() {
        return !cards.isEmpty();
    }
}
