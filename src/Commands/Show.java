package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWork;
import Stuff.LabWorkCollection;

import java.util.Iterator;

public class Show implements CommandWithoutArg {
    String name = "show";
    LabWorkCollection collection = new LabWorkCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
        else {
            for (LabWork labWork : LabWorkCollection.getCollection()) {
                System.out.println(labWork.getInfo());
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}