package edu.austral.ingsis;

import edu.austral.ingsis.clifford.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFileSystemRunner implements FileSystemRunner{
    @Override
    public List<String> executeCommands(List<String> commands) {
        Map<String, Commands> myCommands = Map.of(
                "touch", new TouchCommand(),
                "pwd", new PwdCommand(),
                "mkdir", new MkdirCommand(),
                "ls", new LsCommand(),
                "cd", new CdCommand(),
                "rm", new RmCommand()
        );

        FileSystem fileSystem = new FileSystem(myCommands);

        List<String> results = new ArrayList<>();
        for (String command : commands) {
            results.add(fileSystem.executeCommand(command));
        }
        return results;
    }
}
