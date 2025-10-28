import oshi.SystemInfo;
import oshi.hardware.NetworkIF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IpInfo implements DataProvider {

    private List<NetworkIF> networkInterfaces;

    public IpInfo() {
        SystemInfo systemInfo = new SystemInfo();
        networkInterfaces = systemInfo.getHardware().getNetworkIFs();
    }

    @Override
    public String getName() {
        return "Networking";
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();

        for (NetworkIF networkInterface : networkInterfaces) {
            data.add("\nInterface Name: " + networkInterface.getName());
            data.add("Speed: " + networkInterface.getSpeed() + " Mbps");
            data.add("\nIPv4 Address: " + Arrays.toString(networkInterface.getIPv4addr()));
            data.add("IPv6 Address: " + Arrays.toString(networkInterface.getIPv6addr()));
            data.add("\nPackets Sent: " + networkInterface.getPacketsSent());
            data.add("Packets Recieved: " + networkInterface.getPacketsRecv() + "\n");
        }
        return data;

    }//end of getData

    @Override
    public boolean hasData() {
        return !networkInterfaces.isEmpty();
    }




}