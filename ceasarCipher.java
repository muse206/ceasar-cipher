public class ceasarCipher {
    public static void main(String[] args) {
        String str = "YXOWYBXSXQGROXQBOQYBCKWCKGYUOP" + "BYWDBYELVONNBOKWCROPYEXNRSWCOVP"
                + "DBKXCPYBWONSXRSC	LONSXDYKRYBBSL" + "VOFOBWSXROVKIYXRSCKBWYEBVSUOLKM"
                + "UKXNSPROVSPDONRSCROKNKVSDDVOROM" + "YEVNCOORSCLBYGXLOVVICVSQRDVINYW"
                + "ONKXNNSFSNONLIKBMROCSXDYCDSPPCO" + "MDSYXCDROLONNSXQ	GKCRKBNVIKLVOD"
                + "YMYFOBSDKXNCOOWONBOKNIDYCVSNOYP" + "PKXIWYWOXDRSCWKXIVOQCZSDSPEVVID"
                + "RSXMYWZKBONGSDRDROCSJOYPDROBOCD" + "YPRSWGKFONKLYEDROVZVOCCVIKCROVYYUON";
        crackCaesar(str);
        bruteForce(str);
    }

    public static void bruteForce(String cypher1) {
        for (int key = 1; key < 26; key++) {
            decrypt(cypher1, key);
        }
    }

    public static void decrypt(String Cypher1, int key1) {
        String encrypted = "";
        Cypher1 = Cypher1.toUpperCase();
        for (int i = 0; i < Cypher1.length(); i++) {
            char letter = Cypher1.charAt(i);
            if (letter >= 65 && letter <= 90) {
                letter -= key1;
                letter = (char) ((letter + 'A') % 26 + 'A');
                encrypted += letter;
            }
        }
        System.out.println("Key:	" + key1 + ":" + encrypted);
    }

    public static String crackCaesar(String Cypher1) {
        char most = getCharFreq(Cypher1);
        int key = most - 69;
        decrypt(Cypher1, key);
        return "";
    }

    public static char getCharFreq(String Cypher1) {
        int maxCount = 0;
        char maxChar = 'a';
        for (int j = 0; j < 26; j++) {
            int value = 0;
            for (int cypher = 0; cypher < Cypher1.length(); cypher++) {
                if (Cypher1.charAt(cypher) == j + 65)
                    value++;
            }
            char letter = (char) (j + 65);
            if (value > maxCount) {
                maxCount = value;
                maxChar = letter;
            }
            System.out.println(letter + ":	" + value + ":	" + Math.round((value * 100.0) / Cypher1.length()) + "%");
        }
        return maxChar;
    }
}