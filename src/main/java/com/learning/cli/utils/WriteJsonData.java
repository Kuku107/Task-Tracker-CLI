package com.learning.cli.utils;

import com.google.gson.Gson;
import com.learning.cli.model.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class WriteJsonData {
    public static void write(List<Task> tasks) {
        String jarDir = Paths.get(System.getProperty("java.class.path"))
                .toAbsolutePath().getParent().getParent().toString();

        Path filePath = Path.of(jarDir, "data.json");
        Gson gson = new Gson();
        try {
            FileWriter fw = new FileWriter(filePath.toFile());
            fw.write("[\n");
            for(int i = 0; i < tasks.size() - 1; i++) {
                fw.write(gson.toJson(tasks.get(i)));
                fw.write(",\n");
            }
            fw.write(gson.toJson(tasks.get(tasks.size() - 1)) + "\n");
            fw.write("]");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/java/com/learning/cli/data.json";
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
