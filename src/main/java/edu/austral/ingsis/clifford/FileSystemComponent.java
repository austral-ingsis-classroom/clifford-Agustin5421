package edu.austral.ingsis.clifford;

import java.util.List;

public interface FileSystemComponent {
  List<FileSystemComponent> getChildren();

  String getName();

  void setFather(FileSystemComponent father);

  FileSystemComponent getFather();

  void addFileSystemComponent(FileSystemComponent component);

  void removeFileSystemComponent(String name);

  String typeToString();
}
