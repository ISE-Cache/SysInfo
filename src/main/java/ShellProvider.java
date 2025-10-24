import java.util.ArrayList;

public class ShellProvider implements DataProvider {

    private String shell;

    public ShellProvider() {
        try {
            shell = System.getenv("SHELL");
        } catch (Exception e) {
        }
    }

    @Override
    public String getName() {
        return "Shell";
    }

    @Override
    public ArrayList<String> getData() {
        var array = new ArrayList<String>();
        array.add(shell);
        return array;
    }

    @Override
    public boolean hasData() {
        return shell != null;
    }
}
