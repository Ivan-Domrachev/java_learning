package Attestation.repositories;

import Attestation.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {
    private List<User> userList = new ArrayList<>();
    private static final String PATH_TO_USER = "user.txt";

    public UsersRepositoryFileImpl() {
        loadFromFile();
    }

    // Сохранение пользователей в текстовый файл
    private void saveToFile() {
        try {
            File file = new File(PATH_TO_USER);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (User user : userList) {
                    writer.write(user.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении пользователей в файл: " + e.getMessage());
        }
    }

    // Загрузка пользователей из текстового файла
    public void loadFromFile() {
        try {
            File file = new File(PATH_TO_USER);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                userList.clear();
                while ((line = reader.readLine()) != null) {
                    User user = User.fromString(line);
                    if (user != null) {
                        userList.add(user);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке пользователей из файла: " + e.getMessage());
        }
    }

    @Override
    public void create(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не может быть null!");
        }
        if (existsById(user.getId())) {
            throw new IllegalArgumentException("Пользователь с данным ID уже существует: " + user.getId());
        }
        userList.add(user);
        saveToFile();
    }

    @Override
    public User findById(String id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователя с заданным идентификатором не существует: " + id));
    }

    public boolean existsById(String id) {
        return userList.stream()
                .anyMatch(user -> user.getId().equals(id));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void update(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не может быть null.");
        }
        if (!existsById(user.getId())) {
            throw new IllegalArgumentException("Пользователя с заданным идентификатором не существует: " + user.getId());
        }
        User existingUser = findById(user.getId());
        userList.remove(existingUser);
        userList.add(user);
        saveToFile();
    }

    @Override
    public void deleteById(String id) {
        if (existsById(id)) {
            User user = findById(id);
            userList.remove(user);
            saveToFile();
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteAll() {
        if (!userList.isEmpty()) {
            userList.clear();
            saveToFile();
        } else {
            System.out.println("Список пользователей уже пуст.");
        }
    }

    public List<User> findByAge(int age) {
        return userList.stream()
                .filter(user -> user.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<User> findByIsWorker(boolean isWorker) {
        return userList.stream()
                .filter(user -> user.isWorker() == isWorker)
                .collect(Collectors.toList());
    }
}