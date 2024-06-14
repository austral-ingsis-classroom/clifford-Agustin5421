package edu.austral.ingsis.clifford;

public class PwdCommand implements  Commands{
    @Override
    public String execute(FileSystem fileSystem, String args) {
        StringBuilder path = new StringBuilder();
        while (fileSystem.getCurrentFile().getFather() != null) {
            path.insert(0, "/" + fileSystem.getCurrentFile().getName());
            fileSystem.setCurrentFile(fileSystem.getCurrentFile().getFather());
        }

        return path.toString();
    }
}
