package dev.masterflomaster1.jwa.model.action;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Tags;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

class BlockActionTest {

    @Test
    @DisplayName("Block IP address 192.0.2.5 for three days with a reason.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new BlockAction.Builder()
                                .user("192.0.2.5")
                                .expiry("3 days")
                                .reason("First strike")
                                .token("241b26e632a6aadfc6e3ee963e793a5665c210b0+\\")
                                .build()
                )
                .build();

        WikiApi api = new WikiApi();
        Gson gson = new Gson();
        Response r = gson.fromJson(api.executePost(a), Response.class);

        System.out.println(r);
    }

    @Test
    @DisplayName("Block user Vandal indefinitely with a reason, and prevent new account creation and email sending.")
    void testExample2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new BlockAction.Builder()
                                .user("Vandal")
                                .expiry("never")
                                .reason("Vandalism")
                                .noCreate()
                                .autoBlock()
                                .noEmail()
                                .token("241b26e632a6aadfc6e3ee963e793a5665c210b0+\\")
                                .build()
                )
                .build();

        WikiApi api = new WikiApi();
        Gson gson = new Gson();
        System.out.println(a.getUrl());
        Response r = gson.fromJson(api.execute(a), Response.class);

        System.out.println(r);
    }

    @Test
    void getUser() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .user("Name")
                .token("token")
                .build();

        Assertions.assertEquals("Name", a.getUser());
    }

    @Test
    void getExpiry() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .expiry("2014-09-18T12:34:56Z")
                .token("token")
                .build();

        Assertions.assertEquals("2014-09-18T12:34:56Z", a.getExpiry());
    }

    @Test
    void getReason() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .reason("Vandalism")
                .token("token")
                .build();

        Assertions.assertEquals("Vandalism", a.getReason());
    }

    @Test
    void isAnonOnly() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .anonOnly()
                .token("token")
                .build();

        Assertions.assertTrue(a.isAnonOnly());
    }

    @Test
    void isNoCreate() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .noCreate()
                .token("token")
                .build();

        Assertions.assertTrue(a.isNoCreate());
    }

    @Test
    void isAutoBlock() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .autoBlock()
                .token("token")
                .build();

        Assertions.assertTrue(a.isAutoBlock());
    }

    @Test
    void isNoEmail() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .noEmail()
                .token("token")
                .build();

        Assertions.assertTrue(a.isNoEmail());
    }

    @Test
    void isHideName() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .hideName()
                .token("token")
                .build();

        Assertions.assertTrue(a.isHideName());
    }

    @Test
    void isAllowUserTalk() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .allowUserTalk()
                .token("token")
                .build();

        Assertions.assertTrue(a.isAllowUserTalk());
    }

    @Test
    void isReBlock() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .reBlock()
                .token("token")
                .build();

        Assertions.assertTrue(a.isReBlock());
    }

    @Test
    void isWatchUser() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .watchUser()
                .token("token")
                .build();

        Assertions.assertTrue(a.isWatchUser());
    }

    @Test
    void getWatchlistExpiry() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .watchlistExpiry("test")
                .token("token")
                .build();

        Assertions.assertEquals("test", a.getWatchlistExpiry());
    }

    @Test
    void getTags() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .tags(Set.of(Tags.CONVENIENT_DISCUSSIONS, Tags.REPEATING_CHARACTERS))
                .token("token")
                .build();

        Assertions.assertEquals(Set.of(Tags.CONVENIENT_DISCUSSIONS, Tags.REPEATING_CHARACTERS), a.getTags());
    }

    @Test
    void isPartial() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .partial()
                .token("token")
                .build();

        Assertions.assertTrue(a.isPartial());
    }

    @Test
    void getPageRestrictions() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .pageRestrictions(Set.of("Java_(programming_language)"))
                .token("token")
                .build();

        Assertions.assertEquals(Set.of("Java_(programming_language)"), a.getPageRestrictions());
    }

    @Test
    void getNamespaceRestrictions() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .namespaceRestrictions(Set.of(Namespace.TALK))
                .token("token")
                .build();

        Assertions.assertEquals(Set.of(Namespace.TALK), a.getNamespaceRestrictions());
    }

    @Test
    void getToken() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .namespaceRestrictions(Set.of(Namespace.TALK))
                .token("token")
                .build();

        Assertions.assertEquals("token", a.getToken());
    }
}