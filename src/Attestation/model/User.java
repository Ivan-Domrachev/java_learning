package Attestation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String name;
    private String patronymic = "";
    private int age = -1;
    private boolean isWorker;

    public User(LocalDateTime date, String login, String password, String confirmPassword, String lastName, String name, String patronymic, int age, boolean isWorker) {
        this(date, login, password, confirmPassword, lastName, name, isWorker);
        this.patronymic = patronymic;
        this.age = age;
    }

    public User(LocalDateTime date, String login, String password, String confirmPassword, String lastName, String name, boolean isWorker) {
        this.id = UUID.randomUUID().toString();
        setDate(date);
        setLogin(login);
        if (password.equals(confirmPassword)) {
            setPassword(password);
            setConfirmPassword(confirmPassword);
        } else {
            throw new IllegalArgumentException("Пароли не совпадают");
        }
        setLastName(lastName);
        setName(name);
        this.isWorker = isWorker;
    }

    public User() {
    }

    public static User fromString(String str) {
        String[] parts = str.split("\\|");
        if (parts.length != 9) {
            throw new IllegalArgumentException("Некорректный формат строки: " + str);
        }
        User user = new User();
        user.setId(parts[0]);
        user.setDate(LocalDateTime.parse(parts[1]));
        user.setLogin(parts[2]);
        user.setPassword(parts[3]);
        user.setLastName(parts[4]);
        user.setName(parts[5]);
        user.setPatronymic(parts[6]);
        user.setAge(Integer.parseInt(parts[7]));
        user.setWorker(Boolean.parseBoolean(parts[8]));
        return user;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return id + "|" + date.format(formatter) + "|" + login + "|" + password + "|" + lastName + "|" + name + "|" + patronymic + "|" + age + "|" + isWorker;
    }

    // Геттеры и сеттеры

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || !isValid(login, true)) {
            throw new IllegalArgumentException("Логин должен содержать буквы, цифры или знак подчеркивания и быть короче 20 символов.");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || !isValid(password, false)) {
            throw new IllegalArgumentException("Пароль должен содержать буквы, цифры, знак подчеркивания и быть короче 20 символов.");
        }
        this.password = password;
    }

    private boolean isValid(String str, boolean isLogin) {
        boolean hasLength = str.length() <= 20;
        boolean hasLetter = str.chars().anyMatch(Character::isLetter);
        boolean hasDigit = str.chars().anyMatch(Character::isDigit);
        boolean hasUnderscore = str.contains("_");
        if (isLogin) {
            return hasLength && hasLetter && (hasDigit || hasUnderscore);
        } else {
            return hasLength && hasLetter && hasDigit;
        }
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (confirmPassword == null || !isValid(confirmPassword, false)) {
            throw new IllegalArgumentException(
                    "Подтверждение пароля должно содержать буквы, цифры, знак подчеркивания и быть короче 20 символов."
            );
        }
        if (!confirmPassword.equals(this.password)) {
            throw new IllegalArgumentException("Пароль и подтверждение пароля не совпадают.");
        }
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || !lastName.matches("[а-яА-Яa-zA-Z]+")) {
            throw new IllegalArgumentException("Фамилия должна состоять только из букв.");
        }
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !name.matches("[а-яА-Яa-zA-Z]+")) {
            throw new IllegalArgumentException("Имя должно состоять только из букв.");
        }
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic != null && !patronymic.isEmpty() && !patronymic.matches("[а-яА-Яa-zA-Z]+")) {
            throw new IllegalArgumentException("Отчество должно состоять только из букв.");
        }
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }
}