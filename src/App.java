import entity.StudentEntity;
import repository.StudentRepository;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Creating a student repo
        StudentRepository repo = new StudentRepository();

        //Saving a student
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(3);
//        studentEntity.setNic("200130715542");
//        StudentName studentName = new StudentName("Harron", "Binde");
//        studentEntity.setName(studentName);
//        List<String> mobiles = new ArrayList<>();
//        mobiles.add("0772558427");
//        mobiles.add("0748757232");
//        studentEntity.setMobiles(mobiles);
//
//        repo.saveStudent(studentEntity);

        // get student
        StudentEntity studentEntity1 = repo.getStudent(3);
        System.out.println(studentEntity1.toString());

        //update Student

        studentEntity1.getName().setFirstName("Aiden");
        studentEntity1.getName().setLastName("Makram");
        studentEntity1.setNic("85764846V");
        repo.updateStudent(studentEntity1);

        //Again get student after updating
        studentEntity1 = repo.getStudent(3);
        System.out.println(studentEntity1.toString());

        repo.deleteStudent(studentEntity1);
    }
}