package com.learning.cli.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learning.cli.model.Task;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;

public class ReadJsonData {
    public static List<Task> read() {
        Path filePath =
                Path.of("D:\\Coding\\Back-end project\\Task Tracker CLI\\src\\main\\java\\com\\learning\\cli\\data.json");

        String jsonList = null;
        try {
            jsonList = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Type listType =  new TypeToken<List<Task>>() {}.getType();
        List<Task> task = new Gson().fromJson(jsonList, listType);
        return task;
    }

    public static void main(String[] args) {
        List<Task> tasks = read();
        for(Task task : tasks) {
            System.out.println(task);
        }
    }
}
