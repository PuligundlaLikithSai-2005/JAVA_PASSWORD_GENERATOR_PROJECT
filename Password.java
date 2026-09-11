public class Password {
    private final String password;

    public Password(String password) { this.password = password; }

    public int calculateScore() {
        int score = 0;
        if (password.length() >= 8) score += 2;
        if (password.length() >= 12) score += 2;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[^a-zA-Z0-9].*")) score += 2;
        return score;
    }

    public String toString() { return password; }
}
