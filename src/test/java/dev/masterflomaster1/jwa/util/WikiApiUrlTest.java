package dev.masterflomaster1.jwa.util;

import org.junit.jupiter.api.Test;

class WikiApiUrlTest {

    @Test
    void test() {
        WikiApiUrl a = new WikiApiUrl();
        a.appendQuery("prop", "templates");
        a.putQuery("tllimit", 10);
        a.appendQuery("prop", "contributors");
        a.appendQuery("prop", "extlinks");
//        a.addUnique("prop", "templates");

        System.out.println(a.build());
    }

}