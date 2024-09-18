package com.learning.cli.commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "1.0.0",
        name = "task-cli",
        header = "Task-cli command",
        description = "Welcome to the task tracker application using cli",
        mixinStandardHelpOptions = true,
        footerHeading = "%n@Copyright%n",
        footer = "Developer by Le Van Duc.",
        subcommands = {
                AddCommand.class,
                DeleteCommand.class,
                UpdateCommand.class,
                ListCommand.class,
                MarkCommand.class
        }
)
public class RootCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Welcome to the task tracker application");
        return 0;
    }
}
