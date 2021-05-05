package code.bank.internals;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public enum Currency {
    // Let's say euro is the default currency
    EURO(1.0), DOLLAR(1.21), RUBLE(90.33), RUPEE(89.72), PESO(24.22), LIRA(9.88), YEN(131.52), BITCOIN(0.000022), CHILIZ(2.34), ETHEREUM(0.00047), DOGECOIN(4.5), CARDANO(0.9257);
    private final double value;
    private final AtomicReference<Double> atomicValue = new AtomicReference<>(1d);

    // Only default or private allowed - you can't call the constructor externally (default is mapped to private)
    Currency(double value) {
        this.value = value;
    }

    // Fields and functions, however, are allowed to have any modifier
    double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return name() + "=" + getValue();
    }

    static void loadRates() {
        try (InputStream in = new FileInputStream(new File(System.getProperty("user.dir") + "/files/exchangerates.currencies"))) {
            Properties props = new Properties();
            props.load(in);

            for (Currency c : Currency.values()) {
                String nm = c.name();
                String prop = props.getProperty(nm);
                c.atomicValue.set(Double.parseDouble(props.getProperty(c.name(), "1")));
                System.out.println(c.getAtomicValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    double getAtomicValue() {
        return this.atomicValue.get();
    }
}
