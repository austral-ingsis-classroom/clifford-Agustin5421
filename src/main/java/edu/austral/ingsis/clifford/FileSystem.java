package edu.austral.ingsis.clifford;

import java.util.Map;

public class FileSystem {
    private final Map<String, Commands> commands;
    private FileSystemComponent currentFile;

    public FileSystem(Map<String, Commands> commands) {
        this.commands = commands;
        this.currentFile = new Directory("/");
    }

    public FileSystemComponent getCurrentFile() {
        return currentFile;
    }

    public String executeCommand(String command) {
        String baseCommand = command.split(" ")[0];
        String args = command.substring(baseCommand.length()).trim();
        return commands.get(baseCommand).execute(this, args);
    }

    public void setCurrentFile(FileSystemComponent currentFile) {
        this.currentFile = currentFile;
    }
}
