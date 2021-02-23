package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class String3Test {

    @Test
    void mixString() {
        assertEquals("axbycz", String3.mixString("abc", "xyz"));
        assertEquals("HTihere",String3.mixString("Hi", "There"));
        assertEquals("xTxhxexre",String3.mixString("xxxx", "There"));
    }

    @Test
    void repeatEnd() {
        assertEquals("llollollo",String3.repeatEnd("Hello", 3));
        assertEquals("lolo",String3.repeatEnd("Hello", 2));
        assertEquals("o",String3.repeatEnd("Hello", 1));
    }

    @Test
    void repeatFront() {
        assertEquals("ChocChoChC",String3.repeatFront("Chocolate", 4));
        assertEquals("ChoChC",String3.repeatFront("Chocolate", 3));
        assertEquals("IcI",String3.repeatFront("Ice Cream", 2));

    }

    @Test
    void repeatSeparator() {
        assertEquals("WordXWordXWord",String3.repeatSeparator("Word", "X", 3));
        assertEquals("ThisAndThis",String3.repeatSeparator("This", "And", 2));
        assertEquals("This",String3.repeatSeparator("This", "And", 1) );
    }

    @Test
    void xyzMiddle() {
        assertTrue(String3.xyzMiddle("AAxyzBB"));
        assertTrue(String3.xyzMiddle("AxyzBB"));
        assertFalse(String3.xyzMiddle("AxyzBBB"));
    }

    @Test
    void getSandwich() {
        assertEquals("jam",String3.getSandwich("breadjambread") );
        assertEquals("jam",String3.getSandwich("xxbreadjambreadyy") );
        assertEquals("",String3.getSandwich("xxbreadyy") );

    }

    @Test
    void oneTwo() {
        assertEquals("bca",String3.oneTwo("abc"));
        assertEquals("cat",String3.oneTwo("tca"));
        assertEquals("catdog",String3.oneTwo("tcagdo"));

    }

    @Test
    void zipZap() {
        assertEquals("zpXzp",String3.zipZap("zipXzap"));
        assertEquals("zpzp",String3.zipZap("zopzop"));
        assertEquals("zzzpzp",String3.zipZap("zzzopzop"));
    }

    @Test
    void starOut() {
        assertEquals("ad",String3.starOut("ab*cd"));
        assertEquals("ad",String3.starOut("ab**cd"));
        assertEquals("silly",String3.starOut("sm*eilly"));
    }

    @Test
    void plusOut() {
        assertEquals("++xy++",String3.plusOut("12xy34", "xy"));
        assertEquals("1+++++",String3.plusOut("12xy34", "1"));
        assertEquals("++xy++xy+++xy",String3.plusOut("12xy34xyabcxy", "xy"));

    }
}