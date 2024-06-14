package edu.austral.ingsis.clifford;

public class PwdCommand implements  Commands{
    @Override
    public String execute(FileSystem fileSystem, String args) {
        StringBuilder path = new StringBuilder();
        FileSystemComponent currentFile = fileSystem.getCurrentFile();
        while (currentFile.getFather() != null) {
            path.insert(0, "/" + currentFile.getName());
            currentFile = currentFile.getFather();
        }

        return path.toString();
    }
}
