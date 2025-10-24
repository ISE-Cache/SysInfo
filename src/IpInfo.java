import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class IpInfo implements DataProvider {
    private ArrayList<String> ipdata = new ArrayList<>();

  
    public IpInfo() {
        try{
            InetAddress ip = InetAddress.getLocalHost();
            ipdata.add(ip.getHostAddress());
        }//end of try block

        catch(UnknownHostException e){
            ipdata.add("");
        }//end of catch block
    }//end of constructor


    @Override
    public String getName(){
        String name = "Ip address";
        return name ;
    }//end of getName

    @Override
    public ArrayList<String> getData(){
        return ipdata;

    }

    public boolean hasData(){
        return !ipdata.isEmpty();
    }


}//end of class