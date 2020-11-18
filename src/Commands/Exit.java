package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWorkCollection;

public class Exit implements CommandWithoutArg {
    String name = "exit";
    LabWorkCollection labWorkCollection = new LabWorkCollection();

    @Override
    public void execute(Object o) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return name;
    }
}