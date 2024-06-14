package edu.austral.ingsis.clifford;

import java.util.List;
import java.util.Objects;

public final class File implements FileSystemComponent {
    private final String name;
    private final FileSystemComponent father;

    public File(String name, FileSystemComponent father) {
        this.name = name;
        this.father = father;
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("Files do not have children!");
    }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Files cannot add files!");
    }

    @Override
    public void remove(String name) {
        throw new UnsupportedOperationException("Files cannot remove files!");
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public FileSystemComponent father() {
        return father;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (File) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.father, that.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, father);
    }

    @Override
    public String toString() {
        return "File[" +
                "name=" + name + ", " +
                "father=" + father + ']';
    }

}
