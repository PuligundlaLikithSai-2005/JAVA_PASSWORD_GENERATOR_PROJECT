# 🔐 Java Password Generator & Strength Checker
[PASSWORD_LOGO](https://github.com/PuligundlaLikithSai-2005/JAVA_PASSWORD_GENERATOR_PROJECT/blob/main/Password_LOGO.png)
A console-based Java project that generates passwords, checks password strength, and provides password-security tips.

## Features
- Uppercase, lowercase, numbers and symbols
- Custom password length
- Password strength scoring
- Interactive CLI menu
- Security recommendations

## Run

Requires **JDK 17+**.

```bash
javac -d out src/main/java/*.java
java -cp out Main
```

## Project Structure

```text
Password-Generator/
├── src/main/java/
│   ├── Main.java
│   ├── Generator.java
│   ├── Alphabet.java
│   └── Password.java
├── docs/
│   └── sample-output.txt
├── .gitignore
├── LICENSE
└── README.md
```

## Skills
Java • OOP • StringBuilder • Scanner • Loops • Conditions • Switch • Regex

## Security Note
This is a learning project. For production password generation, use `java.security.SecureRandom` instead of `Math.random()`. Never commit real passwords or secrets to GitHub.
