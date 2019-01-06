package src;

import src.core.EmergencyManagementSystem;
import src.core.ManagementSystem;
import src.engines.Engine;
import src.interpreters.CommandInterpreter;
import src.interpreters.Interpreter;
import src.io.ConsoleReader;
import src.io.ConsoleWriter;
import src.io.Reader;
import src.io.Writer;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);
        Runnable runnable = new Engine(reader,writer,interpreter);
        runnable.run();
    }
}
