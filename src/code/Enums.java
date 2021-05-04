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
}
