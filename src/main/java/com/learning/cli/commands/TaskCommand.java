package com.learning.cli.commands;

import com.learning.cli.model.Task;
import com.learning.cli.utils.ReadJsonData;
import com.learning.cli.utils.WriteJsonData;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "task-cli",
        aliases = {"task"},
        header = "Task-cli command",
        description = "Welcome to the task tracker application using cli",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {
                AddCommand.class,
                DeleteCommand.class,
                UpdateCommand.class,
                ListCommand.class
        }
)
public class TaskCommand implements Callable<Integer> {
    @CommandLine.Parameters(
            defaultValue = "",
            index = "0"
    )
    private String mark;

    @CommandLine.Parameters(
            defaultValue = "0",
            index = "1"
    )
    private int id;

    @Override
    public Integer call() throws Exception {
        if (!mark.isEmpty() && id != 0) {
            List<Task> tasks = ReadJsonData.read();
            for (Task task : tasks)
                if (task.getId() == id) {
                    if (mark.equals("mark-in-progress"))
                        task.setStatus("in-progress");
                    else
                        task.setStatus("done");
                    WriteJsonData.write(tasks);
                    return 0;
                }
        }
        return 0;
    }
}
