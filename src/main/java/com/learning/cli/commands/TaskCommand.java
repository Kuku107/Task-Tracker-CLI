package com.learning.cli.commands;

import picocli.CommandLine;

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
                UpdateCommand.class
        }
)
public class TaskCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
