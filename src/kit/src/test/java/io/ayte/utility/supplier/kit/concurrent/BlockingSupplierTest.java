package io.ayte.utility.supplier.kit.concurrent;

import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class BlockingSupplierTest {
    @Test
    public void wrapsRegularSupplier() {
        val sut = BlockingSupplier.create(() -> null);
        assertThat(sut, instanceOf(BlockingSupplier.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void passesThreadSafeSupplier() {
        val mock = mock(ThreadSafeSupplier.class);
        val sut = BlockingSupplier.create(mock);
        assertThat(sut, is(mock));
    }
}
