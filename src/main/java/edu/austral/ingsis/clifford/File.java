package edu.austral.ingsis.clifford;

import java.util.List;

public record File(String name, FileSystemComponent father) implements FileSystemComponent {

  @Override
  public List<FileSystemComponent> getChildren() {
    throw new UnsupportedOperationException("Files don´t have children!");
  }

  @Override
  public void add(FileSystemComponent component) {
    throw new UnsupportedOperationException("Files can´t add files!");
  }

  @Override
  public void remove(String name) {
    throw new UnsupportedOperationException("Files can´t remove files!");
  }
}
