package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LsCommand implements Commands {
  @Override
  public String execute(FileSystem fileSystem, String args) {
    FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
    if (fileSystemComponent == null) {
      return "No such file or directory";
    }

    String order = getOrderArgument(args);

    List<String> childrenNames = new ArrayList<>();
    for (FileSystemComponent child : fileSystemComponent.getChildren()) {
      childrenNames.add(child.getName());
    }

    sortChildrenNames(childrenNames, order);

    StringBuilder result = new StringBuilder();
    for (String name : childrenNames) {
      if (!result.toString().contains(name)) result.append(name).append(" ");
    }

    return result.toString().trim();
  }

  private String getOrderArgument(String args) {
    if (args != null && args.contains("--ord=")) {
      if (args.contains("asc")) {
        return "asc";
      } else if (args.contains("desc")) {
        return "desc";
      }
    }
    return "";
  }

  private void sortChildrenNames(List<String> names, String order) {
    if ("".equals(order)) return;
    if ("desc".equals(order)) {
      names.sort(Comparator.reverseOrder());
    } else {
      Collections.sort(names);
    }
  }
}
