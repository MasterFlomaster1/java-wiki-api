package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.ImageInfoProp;
import dev.masterflomaster1.jwa.model.QueryAction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class ImageInfoPropTest {

    @Test
    void test() throws IOException, InterruptedException, WikiApiException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                            new ImageInfoProp.Builder()
                                                    .iiProp(Set.of(ImageInfoProp.IIProp.USER, ImageInfoProp.IIProp.TIMESTAMP))
                                                    .iiLimit(10)
                                                    .iiExtMetadataLanguage(ISO639Language.English)
                                                    .build()
                                        )
                                )
                                .titles(Set.of("Java_(programming_language)"))
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}
