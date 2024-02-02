package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SiteInfoMetaTest {

    private WikiApi api;

    @BeforeEach
    void setUp() {
        api = new WikiApi();
    }

    @Test
    void test() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteInfoMeta.Builder()
                                        .siProp(Set.of(SiteInfoMeta.SiProp.GENERAL))
                                        .siShowAllDb()
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

    @Test
    void getSiProp() {
        var a = new SiteInfoMeta.Builder()
                .siProp(Set.of(SiteInfoMeta.SiProp.GENERAL))
                .build();

        assertEquals(a.getSiProp(), Set.of(SiteInfoMeta.SiProp.GENERAL));
    }

    @Test
    void isSiShowAllDb() {
        var a = new SiteInfoMeta.Builder()
                .siProp(Set.of(SiteInfoMeta.SiProp.GENERAL))
                .siShowAllDb()
                .build();

        assertTrue(a.isSiShowAllDb());
    }

    @Test
    void isSiNumberInGroup() {
        var a = new SiteInfoMeta.Builder()
                .siProp(Set.of(SiteInfoMeta.SiProp.GENERAL))
                .siNumberInGroup()
                .build();

        assertTrue(a.isSiNumberInGroup());
    }
}