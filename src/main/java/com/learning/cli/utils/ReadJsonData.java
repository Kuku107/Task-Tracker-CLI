package com.learning.cli.utils;

import com.learning.cli.model.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ReadJsonData {
    public static List<Task> read() {
        List<Task> tasks = new ArrayList<Task>();
        String fileName = "src/main/java/com/learning/cli/data.json";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;
            int beginIndex;
            int endIndex;
            String value;

            while (br.readLine().equals("{")) {
                Task task = new Task();

                // set Id
                line = br.readLine();
                beginIndex = line.indexOf("\": ") + 4;
                endIndex = line.lastIndexOf("\"") - 1;
                value = line.substring(beginIndex, endIndex + 1);
                task.setId(Integer.parseInt(value));

                // set Description
                line = br.readLine();
                beginIndex = line.indexOf("\": ") + 4;
                endIndex = line.lastIndexOf("\"") - 1;
                value = line.substring(beginIndex, endIndex + 1);
                task.setDescription(value);

                // set status
                line = br.readLine();
                beginIndex = line.indexOf("\": ") + 4;
                endIndex = line.lastIndexOf("\"") - 1;
                value = line.substring(beginIndex, endIndex + 1);
                task.setStatus(value);

                //set createdAt
                line = br.readLine();
                beginIndex = line.indexOf("\": ") + 4;
                endIndex = line.lastIndexOf("\"") - 1;
                value = line.substring(beginIndex, endIndex + 1);
                task.setCreatedAt(Date.valueOf(value));

                //set updateAt
                line = br.readLine();
                beginIndex = line.indexOf("\": ") + 4;
                endIndex = line.lastIndexOf("\"") - 1;
                value = line.substring(beginIndex, endIndex + 1);
                task.setUpdatedAt(Date.valueOf(value));

                tasks.add(task);
                br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tasks;
    }

    public static void main(String[] args) {
        List<Task> tasks = read();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }
}
