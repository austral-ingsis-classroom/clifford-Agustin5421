package edu.austral.ingsis.clifford;

public class PwdCommand implements Commands {
  @Override
  public String execute(FileSystem fileSystem, String args) {
    StringBuilder path = new StringBuilder();
    FileSystemComponent currentFile = fileSystem.getCurrentFile();
    while (currentFile.father() != null) {
      path.insert(0, "/" + currentFile.name());
      currentFile = currentFile.father();
    }

    return path.toString();
  }
}
