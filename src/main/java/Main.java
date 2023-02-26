import dao.*;
import entity.*;
import utils.HibernateUtil;

/**
 * Main class.
 */

public class Main {
    public static void main(String[] args) {

        fillTestData();
    }

    private static void fillTestData() {
        DAO<Object> dao = new DaoImpl<>();

        User user = new User();
        user.setLogin("root");
        user.setPassword("12345");

        Student student = new Student();
        student.setName("Max");
        student.setSurname("Petrukevich");
        Student student1 = new Student();
        student1.setName("Oleg");
        student1.setSurname("Avdeenko");
        Student student2 = new Student();
        student2.setName("Katerina");
        student2.setSurname("Yaroshevich");
        Student student3 = new Student();
        student3.setName("Artsiom");
        student3.setSurname("Lipski");
        Student student4 = new Student();
        student4.setName("Matvei");
        student4.setSurname("Goloviy");

        Teacher teacher = new Teacher();
        teacher.setName("Gennadi");
        teacher.setSurname("Vlasik");
        Teacher teacher1 = new Teacher();
        teacher1.setName("Ihar");
        teacher1.setSurname("Blinou");
        Teacher teacher2 = new Teacher();
        teacher2.setName("Alexei");
        teacher2.setSurname("Vasiliev");

        Course course = new Course();
        course.setDescription("JD-2");
        Course course1 = new Course();
        course1.setDescription("Java-core");
        Course course2 = new Course();
        course2.setDescription("Java-industrial");

        Task task = new Task();
        task.setDescription("Task_09");
        Task task1 = new Task();
        task1.setDescription("Task_08");
        Task task2 = new Task();
        task2.setDescription("Task_07");

        Review review = new Review();
        review.setMark(9);
        review.setReview("Well done");
        Review review1 = new Review();
        review1.setMark(8);
        review1.setReview("Well");
        Review review2 = new Review();
        review2.setMark(7);
        review2.setReview("Not bad");


        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        course.getStudents().add(student);
        task.getStudentSet().add(student);
        task.getStudentSet().add(student1);
        student.getCourseSet().add(course);
        student.getTasks().add(task);
        student.getReviews().add(review);
        task.getStudentSet().add(student);
        task.getReviewSet().add(review);
        review.getTasks().add(task);
        review.getStudentHashSet().add(student);

        dao.save(user);
        dao.save(student);
        dao.save(student1);
        dao.save(student2);
        dao.save(student3);
        dao.save(student4);

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();

    }
}
