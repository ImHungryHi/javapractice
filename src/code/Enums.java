package code;

public enum Enums {
    FIRST(1), SECOND(2), THIRD(3);
    private final int n;

    Enums(int n) {
        this.n = n;
    }

    int getValue() {
        return n;
    }

    String getName() {
        // Don't do this, just use the ".name()" function on this instance somewhere else
        return name();
    }

    // Do this somewhere else
    void printSubs() {
        for (SubEnum sub : SubEnum.values()) {
            System.out.println(sub.name() + "=" + sub.getEuroValue());
        }
    }

    @Override
    public String toString() {
        String s = "I'm the ";

        switch(n) {
            case 1:
                s += "first";
                break;
            case 2:
                s += "second";
                break;
            case 3:
                s += "third";
        }

        return s;
    }

    public static enum SubEnum {
        DOLLAR {
            @Override
            double getEuroValue() {
                return 1.21;
            }
        },
        RUBLE {
            @Override
            double getEuroValue() {
                return 90.33;
            }

            @Override
            double getDollarValue() {
                return 75.21;
            }
        },
        YEN {
            @Override
            double getEuroValue() {
                return 131.52;
            }

            @Override
            double getDollarValue() {
                return 109.34;
            }
        };

        abstract double getEuroValue();

        double getDollarValue() {
            return 1.0;
        }
    }
}
