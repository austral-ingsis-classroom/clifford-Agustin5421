package edu.austral.ingsis.clifford;

import java.util.Arrays;
import java.util.List;

public class CdCommand implements Commands {
  @Override
  public String execute(FileSystem fileSystem, String args) {
    FileSystemComponent file = fileSystem.getCurrentFile();
    if (args.equals(".")) {
      return "Already at directory: '" + file.name() + "'";
    }

    if (args.equals("..")) {
      return travelToFather(fileSystem, file);
    }

    if (args.equals("/")) {
      return getRoot(fileSystem, file);
    }

    FileSystemComponent targetDirectory = navigateTo(file, args);
    if (targetDirectory != null) {
      fileSystem.setCurrentFile(targetDirectory);
      return "moved to directory '" + fileSystem.getCurrentFile().name() + "'";
    } else {
      return "'" + args + "' directory does not exist";
    }
  }

  private static String travelToFather(FileSystem fileSystem, FileSystemComponent file) {
    if (file.father() != null) {
      fileSystem.setCurrentFile(file.father());
      return "moved to directory '" + fileSystem.getCurrentFile().name() + "'";
    } else {
      return "moved to directory '" + fileSystem.getCurrentFile().name() + "'";
    }
  }

  private static String getRoot(FileSystem fileSystem, FileSystemComponent file) {
    while (file.father() != null) {
      file = file.father();
    }
    fileSystem.setCurrentFile(file);
    return "moved to directory '" + fileSystem.getCurrentFile().name() + "'";
  }

  private FileSystemComponent navigateTo(FileSystemComponent currentDirectory, String path) {
    FileSystemComponent tempDirectory = currentDirectory;

    if (path.startsWith("/")) {
      while (tempDirectory.father() != null) {
        tempDirectory = tempDirectory.father();
      }
      path = path.substring(1);
    }

    String[] parts = path.split("/");

    while (tempDirectory != null && parts.length > 0) {
      List<FileSystemComponent> children = tempDirectory.getChildren();
      boolean found = false;
      for (FileSystemComponent child : children) {
        if (child.name().equals(parts[0])) {
          tempDirectory = child;
          found = true;
          break;
        }
      }
      if (!found) {
        return null;
      }
      parts = Arrays.copyOfRange(parts, 1, parts.length);
    }
    return tempDirectory;
  }
}
