package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
  private final List<FileSystemComponent> children;
  private final String name;
  private FileSystemComponent father;

  public Directory(List<FileSystemComponent> children, String name) {
    this.children = children;
    this.name = name;
  }

  public Directory(List<FileSystemComponent> children, String name, FileSystemComponent father) {
    this.children = children;
    this.name = name;
    this.father = father;
  }

  public Directory(String name) {
    this.children = new ArrayList<>();
    this.name = name;
  }

  public Directory(String name, FileSystemComponent father) {
    this.children = new ArrayList<>();
    this.name = name;
    this.father = father;
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
  public void addFileSystemComponent(FileSystemComponent component) {
    children.add(component);
  }

  @Override
  public void removeFileSystemComponent(String name) {
    children.removeIf(fileSystemComponent -> fileSystemComponent.getName().equals(name));
  }

  @Override
  public String typeToString() {
    return "directory";
  }
}
