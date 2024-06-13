package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.LsCommand;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MyTests {
    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem(Map.of("ls", new LsCommand()));
        fileSystem.executeCommand("ls hola");
    }
}
