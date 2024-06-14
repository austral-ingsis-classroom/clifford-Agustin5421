package edu.austral.ingsis.clifford;

import java.util.List;

public class TouchCommand implements Commands{
    public String execute(FileSystem fileSystem, String args) {
        List<FileSystemComponent> children = fileSystem.getCurrentFile().getChildren();
        for (FileSystemComponent child : children) {
            if (child.getName().equals(args)) {
                fileSystem.getCurrentFile().removeFileSystemComponent(child.getName());
            }
        }

        FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
        fileSystemComponent.addFileSystemComponent(new File(args, fileSystemComponent));
        return "'" + args + "' " + "file created";
    }
}
