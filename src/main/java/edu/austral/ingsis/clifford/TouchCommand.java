package edu.austral.ingsis.clifford;

public class TouchCommand implements Commands{
    public String execute(FileSystem fileSystem, String args) {
        FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
        fileSystemComponent.addFileSystemComponent(new File(args, fileSystemComponent));
        return "'" + args + "' " + "file created";
    }
}
