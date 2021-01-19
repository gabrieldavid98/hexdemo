package net.gd.hexdemo.domain.valueobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTests {
    @Test
    void should_throwsAnException_whenNameIsEmptyBlankOrNull() {
        Assertions.assertThrows(
            NameShouldNotBeEmptyException.class,
            () -> new Name("")
        );

        Assertions.assertThrows(
            NameShouldNotBeEmptyException.class,
            () -> new Name(null)
        );
    }
}
