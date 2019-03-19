package io.ayte.utility.supplier.kit.simple;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

class ConstantSupplierContractTest {
    @Test
    public void returnsProvidedValue() {
        val sut = ConstantSupplier.create(2);
        assertThat(sut.get(), equalTo(2));
        assertThat(sut.get(), equalTo(2));
    }

    @Test
    public void acceptsNull() {
        val sut = ConstantSupplier.create(null);
        assertThat(sut.get(), nullValue());
    }
}
