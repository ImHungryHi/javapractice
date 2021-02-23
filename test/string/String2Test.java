package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class String2Test {

    @Test
    void doubleChar() {
        assertEquals("TThhee",String2.doubleChar("The"));
        assertEquals("AAAAbbbb",String2.doubleChar("AAbb"));
        assertEquals("HHii--TThheerree",String2.doubleChar("Hi-There"));
    }

    @Test
    void countHi() {
        assertEquals(1,String2.countHi("abc hi ho"));
        assertEquals(2,String2.countHi("ABChi hi"));
        assertEquals(2,String2.countHi("hihi"));
    }

    @Test
    void catDog() {
        assertTrue(String2.catDog("catdog"));
        assertFalse(String2.catDog("catcat"));
        assertTrue(String2.catDog("1cat1cadodog"));
    }

    @Test
    void countCode() {
        assertEquals(1, String2.countCode("aaacodebbb"));
        assertEquals(2, String2.countCode("codexxcode"));
        assertEquals(2, String2.countCode("ccozexxcope"));
    }

    @Test
    void endOther() {
        assertTrue(String2.endOther("Hiabc", "abc"));
        assertTrue(String2.endOther("AbC", "HiaBc"));
        assertFalse(String2.endOther("AbD", "HiaBc"));
        assertTrue(String2.endOther("abc", "abXabc"));
    }

    @Test
    void xyzThere() {
        assertTrue(String2.xyzThere("abcxyz"));
        assertFalse(String2.xyzThere("abc.xyz"));
        assertTrue(String2.xyzThere("xyz.abc"));
    }

    @Test
    void bobThere() {
        assertTrue(String2.bobThere("abcbob"));
        assertTrue(String2.bobThere("b9b") );
        assertFalse(String2.bobThere("bac"));

    }

    @Test
    void xyBalance() {
        assertTrue(String2.xyBalance("aaxbby"));
        assertFalse(String2.xyBalance("aaxbb"));
        assertFalse(String2.xyBalance("yaaxbb"));
    }

    @Test
    void prefixAgain() {
        assertTrue(String2.prefixAgain("abXYabc", 1));
        assertTrue(String2.prefixAgain("abXYabc", 2) );
        assertFalse(String2.prefixAgain("abXYabc", 3));
    }

    @Test
    void sameStarChar() {
        assertTrue(String2.sameStarChar("xy*yzz"));
        assertFalse(String2.sameStarChar("xy*zzz"));
        assertTrue(String2.sameStarChar("*xa*az"));
    }
}