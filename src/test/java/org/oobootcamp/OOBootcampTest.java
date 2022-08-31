package org.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OOBootcampTest {

//    @Test
//    void should_welcome_to_oo_bootcamp() {
//        OOBootcamp ooBootcamp = new OOBootcamp("Hello, Welcome to OOBootcamp");
//        assertThat(ooBootcamp.message()).isEqualTo("Hello, Welcome to OOBootcamp");
//    }

    @Test
    void should_get_fizzbuzz_array() {
        OOBootcamp ooBootcamp = new OOBootcamp();
        assertThat(ooBootcamp.call(5)).isEqualTo("Buzz");

        assertThat(ooBootcamp.call(3)).isEqualTo("Fizz");
        assertThat(ooBootcamp.call(15)).isEqualTo("FizzBuzz");
        assertThat(ooBootcamp.call(2)).isEqualTo("2");
    }

}
