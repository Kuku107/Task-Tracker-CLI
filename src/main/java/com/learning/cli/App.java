package com.learning.cli;

import com.learning.cli.commands.TaskCommand;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int exitCode = new CommandLine(new TaskCommand()).execute("update", "2", "hehe1");
        System.exit(exitCode);
    }
}
