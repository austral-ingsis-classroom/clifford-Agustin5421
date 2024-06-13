package edu.austral.ingsis.clifford;

import java.util.Map;

public class FileSystem {
    private final Map<String, Commands> commands;
    private FileSystemComponent currentFile;

    public FileSystem(Map<String, Commands> commands) {
        this.commands = commands;
    }

    public FileSystemComponent getCurrentFile() {
        return currentFile;
    }

    public void executeCommand(String command) {
        String baseCommand = command.split(" ")[0];
        String args = command.substring(baseCommand.length()).trim();
        commands.get(baseCommand).execute(currentFile, args);
    }
}
