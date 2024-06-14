package edu.austral.ingsis.clifford;

import java.util.Arrays;
import java.util.List;

public class CdCommand implements Commands{
    @Override
    public String execute(FileSystem fileSystem, String args) {
        FileSystemComponent fileSystemComponent = fileSystem.getCurrentFile();
        if (args.equals(".")) {
            return "Already at directory: '" + fileSystemComponent.getName() + "'";
        } else if (args.equals("..")) {
            if (fileSystemComponent.getFather() != null) {
                fileSystem.setCurrentFile(fileSystemComponent.getFather());
                return "moved to directory '" + fileSystem.getCurrentFile().getName() + "'";
            } else {
                return "Already at root directory, can't move up.";
            }
        } else {
            FileSystemComponent targetDirectory = navigateTo(fileSystemComponent, args);
            if (targetDirectory != null) {
                fileSystem.setCurrentFile(targetDirectory);
                return "moved to directory '" + fileSystem.getCurrentFile().getName() + "'";
            } else {
                return "'"+args+"' directory does not exist";
            }
        }
    }



    private FileSystemComponent navigateTo(FileSystemComponent currentDirectory, String path) {
        FileSystemComponent tempDirectory = currentDirectory;

        if (path.startsWith("/")) {
            while (tempDirectory.getFather() != null) {
                tempDirectory = tempDirectory.getFather();
            }
            path = path.substring(1);
        }

        String[] parts = path.split("/");

        while (tempDirectory != null && parts.length > 0) {
            List<FileSystemComponent> children = tempDirectory.getChildren();
            boolean found = false;
            for (FileSystemComponent child : children) {
                if (child.getName().equals(parts[0])) {
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