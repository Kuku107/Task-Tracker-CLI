package com.learning.cli.utils;

import com.learning.cli.model.Task;

import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteJsonData {
    public static void write(List<Task> tasks) {
        String fileName = "src/main/java/com/learning/cli/data.json";
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[\n");
        for (Task task : tasks) {
            jsonString.append("{\n");
            jsonString.append("\"id\": \"").append(task.getId()).append("\",\n");
            jsonString.append("\"description\": \"").append(task.getDescription()).append("\",\n");
            jsonString.append("\"status\": \"").append(task.getStatus()).append("\",\n");
            jsonString.append("\"createdAt\": \"").append(task.getCreatedAt().toString()).append("\",\n");
            jsonString.append("\"updatedAt\": \"").append(task.getUpdatedAt().toString()).append("\"\n");
            jsonString.append("},\n");
        }
        jsonString.deleteCharAt(jsonString.length() - 2);
        jsonString.append("]");

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(jsonString.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task(1, "hit the gym",
                "todo", Date.valueOf("2024-08-31"), Date.valueOf("2024-08-31"));
        Task task2 = new Task(2, "hit the library",
                "in-progress", Date.valueOf("2024-08-31"), Date.valueOf("2024-08-31"));
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        write(tasks);
    }
}
