public class Main
{
    public static void main(String[] args)
    {
        int asciIndex;
        //Asci logo
        String[] ascis = {"\u001B[33m       _.-nnMMMMnn-._       ","    \u001B[33m.d'00000000000000`b.    ",
                "  \u001B[33m.p'0000\u001B[37m,wWWWWWWw,\u001B[33m0000`q.  ",
                " \u001B[33m.d'000\u001B[37m,W^'\u001B[33m000000\u001B[37m'^W,\u001B[33m000`b. ",
                "\u001B[33m.d'00\u001B[37m/WWWWWWWWWW/\u001B[33m00000000`b.",
                "\u001B[33m::00000\u001B[37mW:\u001B[33m00000000000000000::",
                "\u001B[33m`p000\u001B[37m/WWWWWWWWW/\u001B[33m0000000000q'",
                " \u001B[33m`p0000\u001B[37m'Wv,\u001B[33m000000\u001B[37m,vW'\u001B[33m0000q' ",
                "  \u001B[33m`b00000\u001B[37m'\\WWWWWW/'\u001B[33m00000d'  ",
                "    \u001B[33m`q,00000000000000,p'    ","       \u001B[33m'-000;;;;000-'       "};

        DataProvider[] dataproviders = new DataProvider[]{};

        System.out.println("\n\u001B[34mWelcome to the CM SIA (System Infomartion Application)\n");

        //example, remove on completion
        for (asciIndex = 0; asciIndex < 11; asciIndex++)
        {
            System.out.print(ascis[asciIndex]);
            System.out.println("          \u001B[34mdevice: "+asciIndex);
        }

        //actual system
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