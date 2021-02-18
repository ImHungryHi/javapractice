import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Twas brillig and the slithy toves\n" +
                "did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves\n" +
                "and the mome raths outgrabe.\n" +
                "\n" +
                "Beware the Jabberwock, my son.\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird and shun\n" +
                "the frumious Bandersnatch.\n" +
                "\n" +
                "He took his vorpal sword in hand.\n" +
                "Long time the manxome foe he sought.\n" +
                "So rested he by the Tumtum tree\n" +
                "and stood awhile in thought.\n" +
                "\n" +
                "And as in uffish thought he stood;\n" +
                "the Bandersnatch, with eyes of flame,\n" +
                "came whiffling through the Tulgey wood\n" +
                "and burbled as it came.\n" +
                "\n" +
                "One, two! One, two! And through! And Through!\n" +
                "His vorpal blade went snicker-snack.\n" +
                "He left it dead, and with its head\n" +
                "he went galumphing back.\n" +
                "\n" +
                "And hast thou slain the Jabberwock?\n" +
                "Come to my arms, my beamish boy.\n" +
                "Oh frabjous day! Calloo, callay!\n" +
                "He chortled in his joy.\n" +
                "\n" +
                "Twas brillig and the slithy toves\n" +
                "did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves\nand the mome raths outgrabe.\n" +
                "\n" +
                "Lewis Carroll - Jabberwocky");
        //TestCase.tafelVanTien();
        //TestCase.nestedLoops();
        //TestCase.timing();
        String s = "Twas brillig and the slithy toves did gyre and gimble in the wabe.";

        for (int x = 0; x < s.length(); x++) {
            int idx = x % 10;
            System.out.print(idx);
        }

        System.out.println("\n" + s + ";'b' can be found at idx " + TestCase.indexOf(s, 'b', false));
        System.out.println("'b' can be found at indexes " + Arrays.toString(TestCase.indexOfAll(s, 'b', false)));
        System.out.println("And the count of 't' is " + TestCase.countChar(s, 't'));
        System.out.println("Substring 4-10 = \"" + TestCase.substr(s, 4, 10) + "\"");
        System.out.println("Substring from 5 onward = \"" + TestCase.substr(s, 5) + "\"");

        HashMap<Character, Integer> counts = TestCase.countLettersAlternative(s);
        System.out.println(counts.toString());
        System.out.println(TestCase.sieveOfEratosthenes(100).toString());
    }
}
