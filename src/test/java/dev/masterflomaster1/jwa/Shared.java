package dev.masterflomaster1.jwa;

public class Shared {

    private static WikiApi wikiApi;

    public static WikiApi api() {
        if (wikiApi == null)
            wikiApi = new WikiApi();

        return wikiApi;
    }

}
