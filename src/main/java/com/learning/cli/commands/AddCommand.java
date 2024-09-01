package com.learning.cli.commands;

import com.learning.cli.model.Task;
import com.learning.cli.utils.ReadJsonData;
import com.learning.cli.utils.WriteJsonData;
import picocli.CommandLine;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "add",
        aliases = {"plus"},
        header = "Add command",
        description = "This command is primarily using to add the task",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {}
)
public class AddCommand implements Callable<Integer> {

    @CommandLine.Parameters
    private String detail;

    @Override
    public Integer call() throws Exception {
        if (Objects.isNull(detail)) {
            System.out.println("Please provide a task");
            return 0;
        }

        List<Task> tasks = ReadJsonData.read();
        Task task = new Task();
        if (tasks.isEmpty())
            task.setId(1);
        else
            task.setId(tasks.get(tasks.size() - 1).getId() + 1);
        task.setDescription(detail);
        task.setStatus("todo");
        task.setCreatedAt(Date.valueOf(LocalDate.now().toString()));
        task.setUpdatedAt(Date.valueOf(LocalDate.now().toString()));
        tasks.add(task);
        WriteJsonData.write(tasks);
        System.out.println("Task added successfully (ID: " + task.getId() + ")");
        return 0;
    }
}
