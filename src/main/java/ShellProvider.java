import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ShellProvider implements DataProvider {
    private String shell;

    public ShellProvider() {
        // These shells are known to respond to --version in a compatible format
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
                var version = getProgramVersionFromCommand(POSIXpath + " --version");
                if (version != null) {
                    shell += " version " + version;
                }
            }
        } catch (Exception ignored) {
        }
    }

    /// Extracts the version number from the output of a command
    private static String getProgramVersionFromCommand(final String command) {
        try {
            var process = Runtime.getRuntime().exec(command);
            try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                // Search for the version number following the word "version"
                var pattern = Pattern.compile(".*version\\s+([\\d._]+).*");
                while (true) {
                    var line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    var matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        // We successfully matched the version number
                        return matcher.group(1);
                    }
                }
            } finally {
                process.destroy();
            }
        } catch (IOException ignored) {
        }
        return null;
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
