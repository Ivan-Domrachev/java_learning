package Attestation;

import Attestation.model.User;
import Attestation.repositories.UsersRepositoryFileImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App {
    static UsersRepositoryFileImpl usersRepositoryFile = new UsersRepositoryFileImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Выберите пункт:
                    1. Добавить пользователя
                    2. Удалить пользователя по id
                    3. Обновить пользователя
                    4. Посмотреть список пользователей
                    5. Удалить всех пользователей
                    6. Найти пользователя по id
                    7. Для завершения программы, введите end""");
            String interfaceUser = scanner.nextLine();
            if (interfaceUser.equalsIgnoreCase("end")) {
                System.out.println("Программа завершена.");
                break;
            }
            try {
                int num = Integer.parseInt(interfaceUser);
                interfaceCommand(num, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 7.");
            }
        }
    }

    private static void interfaceCommand(int num, Scanner scanner) {
        try {
            switch (num) {
                case 1: {
                    User user = creatUser(scanner);
                    usersRepositoryFile.create(user);
                    System.out.println("Пользователь успешно добавлен.");
                    break;
                }
                case 2: {
                    System.out.println("Введите id: ");
                    String id = scanner.nextLine();
                    usersRepositoryFile.deleteById(id);
                    System.out.println("Пользователь успешно удален.");
                    break;
                }
                case 3: {
                    System.out.println("Введите id: ");
                    String id = scanner.nextLine();
                    User user = usersRepositoryFile.findById(id);
                    System.out.println("Данные пользователя: \n" + user);
                    User userUpdate = creatUser(scanner);
                    userUpdate.setId(user.getId());
                    usersRepositoryFile.update(userUpdate);
                    System.out.println("Пользователь успешно обновлен.");
                    break;
                }
                case 4: {
                    System.out.println("Список пользователей: ");
                    List<User> userList = usersRepositoryFile.findAll();
                    if (userList.isEmpty()) {
                        System.out.println("Список пользователей пуст.");
                    } else {
                        for (User user : userList) {
                            System.out.println(user);
                        }
                    }
                    break;
                }
                case 5: {
                    usersRepositoryFile.deleteAll();
                    System.out.println("Все пользователи удалены.");
                    break;
                }
                case 6: {
                    System.out.println("Введите id: ");
                    String id = scanner.nextLine();
                    User user = usersRepositoryFile.findById(id);
                    System.out.println("Найден пользователь: \n" + user);
                    break;
                }
                default: {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 6.");
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static User creatUser(Scanner scanner) {
        System.out.println("Введите логин пользователя: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();
        System.out.println("Введите фамилию пользователя: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите имя пользователя: ");
        String name = scanner.nextLine();
        System.out.println("Введите отчество пользователя (при отсутствии отчества, поле оставить пустым): ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите возраст пользователя (если возраст неизвестен, введите -1): ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Данный пользователь является сотрудником? (Введите true, если является сотрудником, введите false, если не является сотрудником): ");
        boolean isWorker = Boolean.parseBoolean(scanner.nextLine());

        return new User(LocalDateTime.now(), login, password, confirmPassword, lastName, name, patronymic, age, isWorker);
    }
}


