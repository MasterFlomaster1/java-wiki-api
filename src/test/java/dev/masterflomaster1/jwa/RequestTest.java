package dev.masterflomaster1.jwa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class RequestTest {

    @Test
    @DisplayName("Exception is thrown when the action is not specified")
    void shouldThrownExceptionOnEmptyAction() {
        assertThrows(WikiApiException.class, () -> new WikiApiRequest.Builder().build());
    }

}
