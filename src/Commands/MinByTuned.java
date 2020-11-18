package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.LabWork;
import Stuff.LabWorkCollection;

import java.io.FileNotFoundException;

public class MinByTuned implements CommandWithoutArg {
    String name ="min_by_tuned_in_works";
    LabWorkCollection collection = new LabWorkCollection();
    @Override
    public void execute(Object o) throws FileNotFoundException {
            try{
                if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
                else {
                    LabWork minLab = null;
                    double minimumPoint = LabWorkCollection.getCollection().iterator().next().getTunedInWorks();
                    System.out.println(minimumPoint);
                    for (LabWork labWork1 : LabWorkCollection.getCollection())
                        if (labWork1.getTunedInWorks() <= minimumPoint) {
                            minLab = labWork1;
                        }
                    if (!(minLab==null)) {
                        System.out.println("Лабораторная с наименьшем значением поля \"Настрой на работу\":");
                        System.out.println(minLab.getInfo());
                    }
                }
            } catch (Exception e) {
                System.out.println("Аргумент команды должен быть типа \"long\"");
            }

    }

    @Override
    public String getName() {
        return name;
    }
}
