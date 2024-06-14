package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
  private final List<FileSystemComponent> children;
  private final String name;
  private FileSystemComponent father;

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
  public String name() {
    return name;
  }

  @Override
  public FileSystemComponent father() {
    return father;
  }

  @Override
  public void add(FileSystemComponent component) {
    children.add(component);
  }

  @Override
  public void remove(String name) {
    children.removeIf(fileSystemComponent -> fileSystemComponent.name().equals(name));
  }
}
