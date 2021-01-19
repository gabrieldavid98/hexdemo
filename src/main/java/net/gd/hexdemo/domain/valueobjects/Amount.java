package net.gd.hexdemo.domain.valueobjects;

public final class Amount {
    private final double value;

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean equals(Amount amount) {
        return value == amount.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        return new Double(value).hashCode();
    }
}
