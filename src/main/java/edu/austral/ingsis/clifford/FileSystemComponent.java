package edu.austral.ingsis.clifford;

import java.util.List;

public interface FileSystemComponent {
  List<FileSystemComponent> getChildren();

  String name();

  FileSystemComponent father();

  void add(FileSystemComponent component);

  void remove(String name);
}
