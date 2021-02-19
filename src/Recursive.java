public class Recursive {
    public static void samIAm(String[] arrInput, String prefix) {
        if (arrInput.length == 1)
            System.out.println(prefix + arrInput[0]);

        for (int x = 0; x < arrInput.length; x++) {
            String[] passThrough = new String[arrInput.length - 1];
            int i = 0;

            for (int y = 0; y < arrInput.length; y++) {
                if (!arrInput[y].equals(arrInput[x])) {
                    passThrough[i] = arrInput[y];
                    i++;
                }
            }

            samIAm(passThrough, prefix + arrInput[x]);
        }
    }
}
