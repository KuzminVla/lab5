package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWork;
import Stuff.LabWorkCollection;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class PrintDescending implements CommandWithoutArg {
    String name = "print_descending";
    LabWorkCollection collection = new LabWorkCollection();

    @Override
    public void execute(Object o) throws FileNotFoundException {
        try {
            if (collection.getSize() == 0) System.out.println("Коллекция пустая,выводить нечего.");
            else {
                System.out.println("Элементы в порядке убывания по кол-ву часов,необходимх на обучение.");
                HashSet<LabWork> set =  new HashSet<>(LabWorkCollection.getCollection());
                int size=set.size();
                for (int i = 0; i<size; i++) {
                    LabWork labWork = set.iterator().next();
                    for (LabWork labWork1 : set)
                        if (labWork.compareTo(labWork1) <= 0) {
                            labWork = labWork1;
                        }
                    System.out.println(labWork.getInfo());
                    set.remove(labWork);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getName() {
        return name;
    }
}
