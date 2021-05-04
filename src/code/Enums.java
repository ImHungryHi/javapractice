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
        },
        YEN {
            @Override
            double getEuroValue() {
                return 131.52;
            }
        };

        double getEuroValue() {
            return 0d;
        }
    }
}
