package Commands;

import Stuff.CommandWithObject;
import Stuff.LabWork;
import Stuff.LabWorkCollection;
import Utility.CreateLab;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class UpdateId implements CommandWithObject {
    String name = "update";
    CreateLab createLab = new CreateLab();
    LabWorkCollection collection = new LabWorkCollection();
    @Override
    public boolean check(Object arg) {
        return !collection.isKeyFree((Long) arg);
    }

    @Override
    public LabWork getNewlabwork(Object params) {
        if (!CreateLab.isFromScript) return createLab.create();
        else return CreateLab.labFromScript;
    }

    @Override
    public void execute(Object arg) throws FileNotFoundException {
        try {
            long id = Long.parseLong((String) arg);
            if (this.check(id)) {
                LabWork labWork = this.getNewlabwork(null);
                if (labWork != null) {
                    labWork.setId(id);
                    collection.update( id, labWork);
                    System.out.println("Лабораторная работа с id[" + arg + "] успешно обновлена.");
                }
            } else System.out.println("Лабораторная работа с указанным id не найден.");
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
