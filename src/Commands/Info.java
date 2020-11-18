package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWorkCollection;

public class Info implements CommandWithoutArg {
    String name = "info";
    LabWorkCollection labWorkCollection = new LabWorkCollection();

    @Override
    public void execute(Object o) {
        System.out.println(labWorkCollection.getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}