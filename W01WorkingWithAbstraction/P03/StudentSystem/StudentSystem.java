package W01WorkingWithAbstraction.P03.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void parseCommand(String[] args) {

        String argument = args[0];
        if (argument.equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (argument.equals("Show")) {
            String name = args[1];
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder sb = new StringBuilder();
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());
                sb.append(view);
                if (student.getGrade() >= 5.00) {
                    sb.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    sb.append(" Average student.");
                } else {
                    sb.append(" Very nice W03ExerciseInheritance.person.");
                }

                System.out.println(sb);
            }
        }
    }
}
