package edu.austral.ingsis.clifford;

public class MkdirCommand implements Commands{
    @Override
    public String execute(FileSystem fileSystem, String args) {
        FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
        fileSystemComponent.addFileSystemComponent(new Directory(args, fileSystemComponent));
        return "'" + args + "' " + "directory created";
    }
}
