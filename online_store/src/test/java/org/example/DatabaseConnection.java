package org.example;
import java.sql.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/online_store";
    private static final String USER = "verrysorry";
    private static final String PASSWORD = "ivan1996";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Подключение к БД успешно!");

            // Только выполнение скриптов без вывода данных
            executeSqlScript(conn, "src/main/resources/schema.sql");
            executeSqlScript(conn, "src/main/resources/test-queries.sql");

        } catch (SQLException | IOException e) {
            System.err.println("❌ Ошибка: " + e.getMessage());
        }
    }

    private static void executeSqlScript(Connection conn, String scriptPath) throws IOException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get(scriptPath)));
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✔ Скрипт " + scriptPath + " выполнен");
        }
    }
}