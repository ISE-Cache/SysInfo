import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DataProvider myCPU = new CPUDataProvider();

        if(myCPU.hasData()){

            System.out.println("--- CPU Information ---");

            System.out.println("CPU Name: " + myCPU.getName());
            System.out.println("");

            ArrayList<String> CPUData = myCPU.getData();

            for (String infoLine : CPUData) {
                System.out.println(infoLine);
            }

        } else {
            System.out.println("Error: Could not retrieve CPU data.");
        }
    }
}


