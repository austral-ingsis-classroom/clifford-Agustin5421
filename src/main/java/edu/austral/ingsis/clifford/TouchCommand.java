package edu.austral.ingsis.clifford;

import java.util.List;

public class TouchCommand implements Commands {
  public String execute(FileSystem fileSystem, String args) {
    List<FileSystemComponent> children = fileSystem.getCurrentFile().getChildren();
    for (FileSystemComponent child : children) {
      if (child.name().equals(args)) {
        fileSystem.getCurrentFile().remove(child.name());
      }
    }

    FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
    fileSystemComponent.add(new File(args, fileSystemComponent));
    return "'" + args + "' " + "file created";
  }
}
