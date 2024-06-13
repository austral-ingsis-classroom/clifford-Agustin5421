package edu.austral.ingsis.clifford;

import java.util.List;

public class Directory implements FileSystemComponent{
    private final List<FileSystemComponent> children;
    private final String name;
    private FileSystemComponent father;

    public Directory(List<FileSystemComponent> children, String name) {
        this.children = children;
        this.name = name;
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setFather(FileSystemComponent father) {
        this.father = father;
    }

    @Override
    public FileSystemComponent getFather() {
        return father;
    }

    @Override
    public String addFile(FileSystemComponent file) {
        children.add(file);
        return "'" + file.getName() + "' " + file.typeToString();
    }

    @Override
    public String typeToString() {
        return "directory";
    }
}
