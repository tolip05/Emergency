package src.interpreters;

import src.anotations.InjectArgs;
import src.anotations.InjectType;
import src.commands.Executable;
import src.core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private final String PACKAGE = "src.commands.";
    private final String COMMAND_SUFIX = "Command";

    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String line)
            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        String[]params = line.split("\\|+");
        String commandName = params[0];
        Class<Executable>executableClass =
                (Class<Executable>) Class.forName(PACKAGE + commandName + COMMAND_SUFIX);
        Constructor<Executable>executableConstructor =
                executableClass.getDeclaredConstructor(ManagementSystem.class);
       Executable executable = executableConstructor.newInstance(this.managementSystem);
        this.injectDependencies(executable,params);
       return executable;
    }

    private void injectDependencies(Executable executable, String[] params) throws IllegalAccessException {

        Field[]fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectArgs.class)){
                field.setAccessible(true);
                field.set(executable,params);
                break;
            }else if (field.isAnnotationPresent(InjectType.class)){
                field.setAccessible(true);
                field.set(executable,params[1]);
                break;
            }
        }
    }
}
