package edu.austral.ingsis.clifford;

public class LsCommand implements Commands{
    @Override
    public void execute(FileSystemComponent fileSystemComponent, String args) {
        if (fileSystemComponent == null) {
            System.out.println("No such file or directory");
            return;
        }
        StringBuilder childrenNames = new StringBuilder();
        for (FileSystemComponent child : fileSystemComponent.getChildren()) {
            childrenNames.append(child.getName()).append(" ");
        }
        System.out.println(childrenNames.toString().trim());
    }
}
