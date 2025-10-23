public class Main {
    public static void main(String[] args)
    {
        //Asci logo
        String[] ascis = {"\u001B[33m       _.-nnMMMMnn-._       ","    \u001B[33m.d'000000--000000`b.    ",
                "  \u001B[33m.p'000/\u001B[37m,wWWWWWWw,\u001B[33m\\000`q.  ",
                " \u001B[33m.d'00/\u001B[37m,W^'\u001B[33m/0000\\\u001B[37m'^W,\u001B[33m\\00`b. ",
                "\u001B[33m.d'0/\u001B[37m/WWWWWWWWWW/\u001B[33m/0000000`b.",
                "\u001B[33m::00000\u001B[37mW:\u001B[33m00000000000000000::",
                "\u001B[33m`p00/\u001B[37m/WWWWWWWWWW/\u001B[33m/00000000q'",
                " \u001B[33m`p000\\\u001B[37m'Wv,\u001B[33m\\0000/\u001B[37m,vW'\u001B[33m/000q' ",
                "  \u001B[33m`b0000\\\u001B[37m'\\WWWWWW/'\u001B[33m/0000d'  ",
                "    \u001B[33m`q,000000--000000,p'    ","       \u001B[33m'-000;;;;000-'       "};

        System.out.println("\n\u001B[34mWelcome to the CM SIA (System Infomartion Application)\n");

        int asciIndex = 0;
        DataProvider[] dataproviders = new DataProvider[]{};

        for (DataProvider dataProvider : dataproviders)
        {
            if (asciIndex <= 11){
                System.out.println(ascis[asciIndex]);
                asciIndex++;
            }
            else if (asciIndex == 12)
            {
                System.out.println("");
            }
            System.out.println("          \u001B[34m"+dataproviders);
        }
    }
}