import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ShellProvider implements DataProvider {

    private String shell;

    public ShellProvider() {
        String[] knownPOSIXShells = {"bash", "sh", "zsh", "ksh", "csh", "tcsh", "fish"};
        try {
            shell = System.getenv("SHELL");
            String POSIXpath = null;
            for (String knownPOSIXShell : knownPOSIXShells) {
                if (shell.endsWith("/" + knownPOSIXShell)) {
                    POSIXpath = shell;
                    shell = knownPOSIXShell;
                    break;
                }
            }
            if (POSIXpath != null) {
                shell += " (" + POSIXpath + ")";
                var version = Runtime.getRuntime().exec(POSIXpath + " --version");
                try (var reader = new BufferedReader(new InputStreamReader(version.getInputStream()))) {
                    // Only keep the version number
                    var pattern = Pattern.compile(".*version\\s+([\\d._]+).*");
                    while (true) {
                        var line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        var matcher = pattern.matcher(line);
                        if (matcher.matches()) {
                            shell += " " + matcher.group(1);
                            break;
                        }
                    }
                } catch (IOException ignored) {
                }
                version.destroy();
            }
        } catch (Exception ignored) {
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
