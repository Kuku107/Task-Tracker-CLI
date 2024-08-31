package com.learning.cli.commands;

import picocli.CommandLine;

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
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
