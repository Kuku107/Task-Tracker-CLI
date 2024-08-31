package com.learning.cli.commands;

import picocli.CommandLine;

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
    private String task;

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
