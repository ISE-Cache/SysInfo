import java.util.ArrayList;

public interface DataProvider {
    String getName();

    ArrayList<String> getData();

    boolean hasData();
}