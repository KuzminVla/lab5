package Stuff;

public class Discipline {
        private String name; //Поле не может быть null, Строка не может быть пустой
        private int selfStudyHours;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSelfStudyHours() {
            return selfStudyHours;
        }

        public void setSelfStudyHours(int selfStudyHours) {
            this.selfStudyHours = selfStudyHours;
        }
    }
