package code.bank.internals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {
    @Test
    public void testLoadFile() {
        System.out.println(Currency.DOLLAR);
        Currency.loadRates();
        System.out.println(Currency.DOLLAR);
    }
}