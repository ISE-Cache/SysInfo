public class Main {
    public static void main(String[] args) {
        String[] BeautifulASCIIArtArrayOfStrings = {"\u001B[33m       _.-nnMMMMnn-._       ", "    \u001B[33m.d'000000--000000`b.    ", "  \u001B[33m.p'000/\u001B[37m,wWWWWWWw,\u001B[33m\\000`q.  ", " \u001B[33m.d'00/\u001B[37m,W^'\u001B[33m/0000\\\u001B[37m'^W,\u001B[33m\\00`b. ", "\u001B[33m.d'0/\u001B[37m/WWWWWWWWWW/\u001B[33m/0000000`b.", "\u001B[33m::00000\u001B[37mW:\u001B[33m00000000000000000::", "\u001B[33m`p00/\u001B[37m/WWWWWWWWWW/\u001B[33m/00000000q'", " \u001B[33m`p000\\\u001B[37m'Wv,\u001B[33m\\0000/\u001B[37m,vW'\u001B[33m/000q' ", "  \u001B[33m`b0000\\\u001B[37m'\\WWWWWW/'\u001B[33m/0000d'  ", "    \u001B[33m`q,000000--000000,p'    ", "       \u001B[33m'-000;;;;000-'       "};

        DataProvider[] dataProviders = new DataProvider[]{
                new CPUDataProvider(),
                new IpInfo(),
                new ProcessCount(),
                new ShellProvider(),
                new Storage(),
                new Memory()
        };

        for (final var ascii : BeautifulASCIIArtArrayOfStrings) {
            System.out.println(ascii);
        }

        for (DataProvider provider : dataProviders) {
            System.out.println("          \u001B[34m" + provider.getName());
            System.out.println("          \u001B[34m" + provider.getData());
        }
    }
}