//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.learning.cli.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learning.cli.model.Task;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class ReadJsonData {
    public ReadJsonData() {
    }

    public static List<Task> read() {
        String jarDir = Paths.get(System.getProperty("java.class.path")).toAbsolutePath().getParent().getParent().toString();
        Path filePath = Path.of(jarDir, "data.json");
        String jsonList = null;

        try {
            jsonList = Files.readString(filePath);
        } catch (IOException var5) {
            IOException e = var5;
            e.printStackTrace();
        }

        Type listType = (new TypeToken<List<Task>>() {
        }).getType();
        List<Task> task = (List)(new Gson()).fromJson(jsonList, listType);
        return task;
    }

    public static void main(String[] args) {
        List<Task> tasks = read();
        Iterator var2 = tasks.iterator();

        while(var2.hasNext()) {
            Task task = (Task)var2.next();
            System.out.println(task);
        }

    }
}
