package edu.austral.ingsis.clifford;

import java.util.Arrays;
import java.util.List;

public class RmCommand implements Commands{
    @Override
    public String execute(FileSystem fileSystemComponent, String args) {
        FileSystemComponent fileSystem = fileSystemComponent.getCurrentFile();
        List<String> arguments = Arrays.asList(args.split(" "));
        List<FileSystemComponent> children = fileSystem.getChildren();

        boolean recursive = isRecursive(arguments);
        String name = getName(arguments);

        for (FileSystemComponent child : children) {
            if (child.getName().equals(name)) {
                if (child instanceof File || recursive) {
                    fileSystem.removeFileSystemComponent(child.getName());
                    return "'" + name + "' " + "removed";
                }
                else {
                    return "cannot remove '" + name + "', is a directory";
                }
            }
        }
        return "No such file or directory";
    }

    private boolean isRecursive(List<String> arguments) {
        return arguments.contains("--recursive");
    }

    private String getName(List<String> arguments) {
        if (arguments.contains("--recursive")) {
            return arguments.get(1);
        }
        return arguments.get(0);
    }
}
