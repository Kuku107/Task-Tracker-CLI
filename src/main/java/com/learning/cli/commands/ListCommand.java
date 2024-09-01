package com.learning.cli.commands;

import com.learning.cli.model.Task;
import com.learning.cli.utils.ReadJsonData;
import picocli.CommandLine;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "list",
        aliases = {"ls"},
        header = "List command",
        description = "This command is primarily using to list the task",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {}
)
public class ListCommand implements Callable<Integer> {

    @CommandLine.Parameters(
            defaultValue = ""
    )
    private String status;

    @Override
    public Integer call() throws Exception {
        System.out.printf("%3s %4s %10s %s\n",
                "ID",
                "Stat",
                "Created",
                "Detail"
        );
        List<Task> tasks = ReadJsonData.read();
        if (Objects.isNull(status) || status.isEmpty()) {
            for (Task task : tasks)
                printTask(task);
            return 0;
        }

        for(Task task : tasks) {
            if (task.getStatus().equals(status))
                printTask(task);
        }
        return 0;
    }

    private void printTask(Task task) {
        System.out.printf("%3d %4s %10s %s\n",
                        task.getId(),
                        getTypeStatus(task.getStatus()),
                        task.getCreatedAt().toString(),
                        task.getDescription()
                );
    }

    private String getTypeStatus(String status) {
        if (status.equals("done"))
            return "[x]";
        if (status.equals("todo"))
            return "[ ]";
        return "[/]";
    }
}
