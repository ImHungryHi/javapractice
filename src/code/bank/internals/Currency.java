package code.bank.internals;

public enum Currency {
    // Let's say euro is the default currency
    EURO(1.0), DOLLAR(1.21), RUBLE(90.33), RUPEE(89.72), PESO(24.22), LIRA(9.88), YEN(131.52), BITCOIN(0.000022), CHILIZ(2.34), ETHEREUM(0.00047), DOGECOIN(4.5), CARDANO(0.9257);
    private final double value;

    Currency(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
