public class Alphabet {
    private final String alphabet;

    public Alphabet(boolean upper, boolean lower, boolean numbers, boolean symbols) {
        StringBuilder pool = new StringBuilder();
        if (upper) pool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (lower) pool.append("abcdefghijklmnopqrstuvwxyz");
        if (numbers) pool.append("0123456789");
        if (symbols) pool.append("!@#$%^&*()-_=+[]{};:,.?/");
        alphabet = pool.toString();
    }

    public String getAlphabet() { return alphabet; }
}
