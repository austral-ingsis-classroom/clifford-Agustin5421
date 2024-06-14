package edu.austral.ingsis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.clifford.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MyTests {
  @Test
  public void test() {
    FileSystem fileSystem =
        new FileSystem(
            Map.of(
                "ls",
                new LsCommand(),
                "mkdir",
                new MkdirCommand(),
                "touch",
                new TouchCommand(),
                "cd",
                new CdCommand()));
    assertEquals("", fileSystem.executeCommand("ls"));
    assertEquals("'folder1' directory created", fileSystem.executeCommand("mkdir folder1"));
    fileSystem.executeCommand("touch file.txt");
    fileSystem.executeCommand("ls");
    assertEquals("Moved to directory: 'folder1'", fileSystem.executeCommand("cd folder1"));
    fileSystem.executeCommand("ls");
    fileSystem.executeCommand("mkdir newFolder");
    assertEquals(
        fileSystem.executeCommand("mkdir anotherFolder"), "'anotherFolder' directory created");
    fileSystem.executeCommand("ls");
    System.out.println("done");

    fileSystem.executeCommand("cd ..");
    fileSystem.executeCommand("ls");
  }

  @Test
  public void pwdTest() {
    FileSystem fileSystem =
        new FileSystem(
            Map.of(
                "ls",
                new LsCommand(),
                "mkdir",
                new MkdirCommand(),
                "touch",
                new TouchCommand(),
                "cd",
                new CdCommand(),
                "pwd",
                new PwdCommand()));
    assertEquals("", fileSystem.executeCommand("ls"));
    assertEquals("'folder1' directory created", fileSystem.executeCommand("mkdir folder1"));
    assertEquals("Moved to directory: 'folder1'", fileSystem.executeCommand("cd folder1"));
    assertEquals("/root/folder1", fileSystem.executeCommand("pwd"));
  }
}
