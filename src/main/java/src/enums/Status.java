package src.enums;

public enum Status {
    SPECIAL,NON_SPECIAL;

    @Override
    public String toString() {
        char first = this.name().charAt(0);
        String result = first + this.name().toLowerCase().substring(1);
        return result;
    }
}
