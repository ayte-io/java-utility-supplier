package io.ayte.utility.supplier.kit.simple;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundRobinSupplierTest {
    @SuppressWarnings("ConstantConditions")
    @Test
    public void throwsOnNullSource() {
        assertThrows(NullPointerException.class, () -> RoundRobinSupplier.create(null));
    }

    @Test
    public void acceptsZeroSizedSource() {
        val sut = RoundRobinSupplier.create(Collections.emptyList());
        assertThat(sut.get(), nullValue());
        assertThat(sut.get(), nullValue());
    }

    public static Object[][] sourcesProvider() {
        return new Object[][] {
                {Collections.singleton(1)},
                {Arrays.asList(1, 2, 3)}
        };
    }

    @ParameterizedTest
    @MethodSource("sourcesProvider")
    public void acceptsRegularSources(Collection<Integer> source) {
        val sut = RoundRobinSupplier.create(source);
        for (int i = 0; i < 2; i++) {
            for (val element : source) {
                assertThat(sut.get(), equalTo(element));
            }
        }
    }
}
