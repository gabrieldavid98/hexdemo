package net.gd.hexdemo.domain.valueobjects;

public final class Name {
    private final String value;

    public Name(String value) {
        if (value == null || value.isBlank()) {
            throw new NameShouldNotBeEmptyException("The 'Name' is required");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Name name) {
        return value.equals(name.getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
