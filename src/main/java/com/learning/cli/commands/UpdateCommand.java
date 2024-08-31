package com.learning.cli.commands;

import com.learning.cli.model.Task;
import com.learning.cli.utils.ReadJsonData;
import com.learning.cli.utils.WriteJsonData;
import picocli.CommandLine;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "update",
        aliases = {"change"},
        header = "Update command",
        description = "This command is primarily using to change the task",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {}
)
public class UpdateCommand implements Callable<Integer> {

    @CommandLine.Parameters (index = "0")
    private int id;

    @CommandLine.Parameters (index = "1")
    private String detail;
    @Override
    public Integer call() throws Exception {
        if (id == 0 || Objects.isNull(detail)) {
            System.out.println("Please provide the id and the detail");
            return 0;
        }

        List<Task> tasks = ReadJsonData.read();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(detail);
                System.out.println("Update successfully");
                WriteJsonData.write(tasks);
                return 0;
            }
        }

        System.out.println("Task not found");
        return 0;
    }
}
