//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        String[] ascis = {"\u001B[33m       _.,nnMMMMnn,._","    .d''000000000000``b.","  .p'0000\u001B[37m,wWWWWWWw,\u001B[33m0000`q.",
                ".d'0000\u001B[37m,W^'\u001B[33m000000\u001B[37m'^W,\u001B[33m0000`b.",".d'00\u001B[37m/WWWWWWWWWW/\u001B[33m00000000`b.",
                "::00000\u001B[37mW:\u001B[33m00000000000000000::","`p.00\u001B[37m/WWWWWWWWW/\u001B[33m000000000.q'",
                " `p.000\u001B[37m'Wv,\u001B[33m000000\u001B[37m,vW'\u001B[33m000.q'","  `b.0000\u001B[37m'\\WWWWWW/'\u001B[33m0000.d'",
                "    `q..000000000000..p'","       '',,,0000,,,''"};

        DataProvider[] dataproviders = new DataProvider[]{};

        System.out.println("\n\u001B[34mWelcome to the CM SIA (System Infomartion Application)\n");

        for (String asci : ascis)
        {
            System.out.println(asci);
        }

        for (DataProvider dataProvider : dataproviders)
        {
            System.out.println("\u001B[34m"+dataproviders);
        }
    }
}