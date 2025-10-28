public class Main {
    private static final String[] asciiBanner = {"\u001B[33m       _.-nnMMMMnn-._       ", "    \u001B[33m.d'000000--000000`b.    ", "  \u001B[33m.p'000/\u001B[37m,wWWWWWWw,\u001B[33m\\000`q.  ", " \u001B[33m.d'00/\u001B[37m,W^'\u001B[33m/0000\\\u001B[37m'^W,\u001B[33m\\00`b. ", "\u001B[33m.d'0/\u001B[37m/WWWWWWWWWW/\u001B[33m/0000000`b.", "\u001B[33m::00000\u001B[37mW:\u001B[33m00000000000000000::", "\u001B[33m`p00/\u001B[37m/WWWWWWWWWW/\u001B[33m/00000000q'", " \u001B[33m`p000\\\u001B[37m'Wv,\u001B[33m\\0000/\u001B[37m,vW'\u001B[33m/000q' ", "  \u001B[33m`b0000\\\u001B[37m'\\WWWWWW/'\u001B[33m/0000d'  ", "    \u001B[33m`q,000000--000000,p'    ", "       \u001B[33m'-000;;;;000-'       "};
    private static final DataProvider[] dataProviders = {new CPUProvider(), new GPUProvider(), new IpProvider(), new ProcessCountProvider(), new ShellProvider(), new StorageProvider(), new MemoryProvider()};

    public static void main(String[] args) {
        // Print an ASCII art banner
        for (final var line :  asciiBanner) {
            System.out.println(line);
        }

        for (DataProvider provider : dataProviders) {
            // Do not print providers that have no data
            if (!provider.hasData()) {
                continue;
            }
            // Add a blank line to separate providers
            System.out.println();
            // Print the name of each provider in yellow
            System.out.println("\u001B[33m" + provider.getName());
            // Switch to blue for the data
            System.out.print("\u001B[34m");
            for (final var row : provider.getData()) {
                System.out.println(row);
            }
        }
    }
}