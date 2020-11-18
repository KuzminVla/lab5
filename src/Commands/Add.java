package Commands;

import Stuff.CommandWithObject;
import Stuff.LabWork;
import Stuff.LabWorkCollection;
import Utility.CreateLab;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Add implements CommandWithObject {
    String name = "add";
    LabWorkCollection labWorkCollection = new LabWorkCollection();
    CreateLab createLab = new CreateLab();
    @Override
    public boolean check(Object arg) {
        return labWorkCollection.isKeyFree((Long) arg);
    }

    @Override
    public LabWork getNewlabwork(Object params) {
        if (!CreateLab.isFromScript) return createLab.create();
        else return CreateLab.labFromScript;
    }

    @Override
    public void execute(Object arg) {
        try {
            long id = Long.parseLong((String) arg);
            if (this.check(id)) {
                LabWork labWork = this.getNewlabwork(null);
                labWork.setId(id);
                labWorkCollection.insert(labWork);
                System.out.println("Лабораторная работа добавлена в коллекцию!");
            } else System.out.println("Указанный ключ занят");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Аргумент команды должен быть типа \"long\"");
        }
        catch (NullPointerException e){
            System.out.println("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
