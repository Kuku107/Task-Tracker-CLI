package com.learning.cli.commands;

import com.learning.cli.model.Task;
import com.learning.cli.utils.ReadJsonData;
import com.learning.cli.utils.WriteJsonData;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "delete",
        aliases = {"erase", "minus"},
        header = "Delete command",
        description = "This command is primarily using to delete the task",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {}
)
public class DeleteCommand implements Callable<Integer> {

    @CommandLine.Parameters
    private int id = 0;

    @Override
    public Integer call() throws Exception {
        if (id == 0) {
            System.out.println("Please provide a task id");
            return 0;
        }

        List<Task> tasks = ReadJsonData.read();
        tasks.removeIf(task -> task.getId() == id);
        WriteJsonData.write(tasks);
        return 0;
    }
}
