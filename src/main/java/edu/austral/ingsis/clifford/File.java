package edu.austral.ingsis.clifford;

import java.util.List;

public class File implements FileSystemComponent {
    private final String name;
    private FileSystemComponent father;

    public File(String name) {
        this.name = name;
    }

    public File(String name, FileSystemComponent father) {
        this.name = name;
        this.father = father;
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("Files don´t have children!");
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
        throw new UnsupportedOperationException("Files can´t add files!");
    }

    @Override
    public String typeToString() {
        return "file";
    }
}
