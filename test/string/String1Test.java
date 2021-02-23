package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class String1Test {

    @Test
    void helloName() {
        Assertions.assertEquals("Hello Bob!", String1.helloName("Bob"));
        Assertions.assertEquals("Hello Alice!", String1.helloName("Alice"));
        Assertions.assertEquals("Hello X!", String1.helloName("X"));
    }

    @Test
    void makeAbba() {
        Assertions.assertEquals("HiByeByeHi", String1.makeAbba("Hi", "Bye"));
        Assertions.assertEquals("YoAliceAliceYo", String1.makeAbba("Yo", "Alice"));
        Assertions.assertEquals("WhatUpUpWhat", String1.makeAbba("What", "Up"));
    }

    @Test
    void makeTags() {
        Assertions.assertEquals("<i>Yay</i>", String1.makeTags("i", "Yay"));
        Assertions.assertEquals("<i>Hello</i>", String1.makeTags("i", "Hello"));
        Assertions.assertEquals("<cite>Yay</cite>", String1.makeTags("cite", "Yay"));
    }

    @Test
    void makeOutWord() {
        Assertions.assertEquals("<<Yay>>", String1.makeOutWord("<<>>", "Yay"));
        Assertions.assertEquals("<<WooHoo>>", String1.makeOutWord("<<>>", "WooHoo"));
        Assertions.assertEquals("[[word]]", String1.makeOutWord("[[]]", "word"));
    }

    @Test
    void extraEnd() {
        Assertions.assertEquals("lololo", String1.extraEnd("Hello"));
        Assertions.assertEquals("ababab", String1.extraEnd("ab"));
        Assertions.assertEquals("HiHiHi", String1.extraEnd("Hi"));
    }

    @Test
    void firstTwo() {
        Assertions.assertEquals("He", String1.firstTwo("Hello"));
        Assertions.assertEquals("ab", String1.firstTwo("abcdefg"));
        Assertions.assertEquals("a", String1.firstTwo("a"));
    }

    @Test
    void firstHalf() {
        assertEquals("Woo",String1.firstHalf("WooHoo"));
        assertEquals("Hello",String1.firstHalf("HelloThere"));
        assertEquals("abc",String1.firstHalf("abcdef"));
    }

    @Test
    void withoutEnd() {
        assertEquals("ell",String1.withoutEnd("Hello"));
        assertEquals("av",String1.withoutEnd("java"));
        assertEquals("odin",String1.withoutEnd("coding"));
    }

    @Test
    void comboString() {
        assertEquals("hiHellohi",String1.comboString("Hello", "hi"));
        assertEquals("hiHellohi",String1.comboString("hi", "Hello"));
        assertEquals("baaab",String1.comboString("aaa", "b"));
    }

    @Test
    void nonStart() {
        assertEquals("ellohere",String1.nonStart("Hello", "There"));
        assertEquals("avaode",String1.nonStart("java", "code"));
        assertEquals("hotlava",String1.nonStart("shotl", "java"));
    }

    @Test
    void left2() {
        assertEquals("lloHe",String1.left2("Hello"));
        assertEquals("vaja",String1.left2("java"));
        assertEquals("Hi",String1.left2("Hi"));
    }

    @Test
    void right2() {
        assertEquals("loHel",String1.right2("Hello"));
        assertEquals("vaja",String1.right2("java"));
        assertEquals("Hi",String1.right2("Hi"));
    }

    @Test
    void theEnd() {
        assertEquals("H",String1.theEnd("Hello", true));
        assertEquals("o",String1.theEnd("Hello", false));
        assertEquals("o",String1.theEnd("oh", true));
    }

    @Test
    void withouEnd2() {
        assertEquals("ell",String1.withouEnd2("Hello"));
        assertEquals("b",String1.withouEnd2("abc"));
        assertEquals("",String1.withouEnd2("ab"));
    }

    @Test
    void middleTwo() {
        assertEquals("ri",String1.middleTwo("string"));
        assertEquals("od",String1.middleTwo("code"));
        assertEquals("ct",String1.middleTwo("Practice"));
    }

    @Test
    void endsLy() {
        assertTrue(String1.endsLy("oddly"));
        assertFalse(String1.endsLy("y"));
        assertFalse(String1.endsLy("oddy") );
    }

    @Test
    void nTwice() {
        assertEquals("Helo",String1.nTwice("Hello", 2));
        assertEquals("Choate",String1.nTwice("Chocolate", 3) );
        assertEquals("Ce",String1.nTwice("Chocolate", 1));
    }

    @Test
    void twoChar() {
        assertEquals("ja",String1.twoChar("java", 0));
        assertEquals("va",String1.twoChar("java", 2) );
        assertEquals("ja",String1.twoChar("java", 3) );
    }

    @Test
    void middleThree() {
        assertEquals("and",String1.middleThree("Candy"));
        assertEquals("and",String1.middleThree("and") );
        assertEquals("lvi",String1.middleThree("solving"));
    }

    @Test
    void hasBad() {
        assertTrue(String1.hasBad("badxx"));
        assertTrue(String1.hasBad("xbadxx"));
        assertFalse(String1.hasBad("xxbadxx"));
    }

    @Test
    void atFirst() {
        assertEquals("he",String1.atFirst("hello"));
        assertEquals("hi",String1.atFirst("hi"));
        assertEquals("h@",String1.atFirst("h"));
    }

    @Test
    void lastChars() {
        assertEquals("ls",String1.lastChars("last", "chars"));
        assertEquals("ya",String1.lastChars("yo", "java"));
        assertEquals("h@",String1.lastChars("hi", ""));
    }

    @Test
    void conCat() {
        assertEquals("abcat",String1.conCat("abc", "cat"));
        assertEquals("dogcat",String1.conCat("dog", "cat"));
        assertEquals("abc",String1.conCat("abc", ""));
    }

    @Test
    void lastTwo() {
        assertEquals("codign",String1.lastTwo("coding"));
        assertEquals("cta",String1.lastTwo("cat"));
        assertEquals("ba",String1.lastTwo("ab"));
    }

    @Test
    void seeColor() {
        assertEquals("red",String1.seeColor("redxx"));
        assertEquals("",String1.seeColor("xxred"));
        assertEquals("blue",String1.seeColor("blueTimes"));
    }

    @Test
    void frontAgain() {
        assertTrue(String1.frontAgain("edited"));
        assertFalse(String1.frontAgain("edit"));
        assertTrue(String1.frontAgain("ed"));
    }

    @Test
    void minCat() {
        assertEquals("loHi",String1.minCat("Hello", "Hi"));
        assertEquals("ellojava",String1.minCat("Hello", "java") );
        assertEquals("javaello",String1.minCat("java", "Hello"));
    }

    @Test
    void extraFront() {
        assertEquals("HeHeHe",String1.extraFront("Hello"));
        assertEquals("ababab",String1.extraFront("ab"));
        assertEquals("HHH",String1.extraFront("H"));
    }

    @Test
    void without2() {
        assertEquals("lloHe",String1.without2("HelloHe"));
        assertEquals("HelloHi",String1.without2("HelloHi"));
        assertEquals("",String1.without2("Hi"));
    }

    @Test
    void deFront() {
        assertEquals("llo",String1.deFront("Hello"));
        assertEquals("va",String1.deFront("java"));
        assertEquals("aay",String1.deFront("away"));
    }

    @Test
    void startWord() {
        assertEquals("hi",String1.startWord("hippo", "hi"));
        assertEquals("hip",String1.startWord("hippo", "xip"));
        assertEquals("h",String1.startWord("hippo", "i"));
    }

    @Test
    void withoutX() {
        assertEquals("Hi",String1.withoutX("xHix"));
        assertEquals("Hi",String1.withoutX("xHi"));
        assertEquals("Hxi",String1. withoutX("Hxix"));
    }

    @Test
    void withoutX2() {
        assertEquals("Hi",String1.withoutX2("xHi"));
        assertEquals("Hi",String1.withoutX2("Hxi"));
        assertEquals("Hi",String1.withoutX2("Hi"));
    }
}