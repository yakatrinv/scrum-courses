import dao.DAO;
import dao.DaoImpl;
import entity.Course;
import entity.Review;
import entity.Student;
import entity.Task;
import entity.Teacher;
import entity.User;
import utils.HibernateUtil;

public class MainK {
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
        student.setName("Oleg");
        student.setSurname("Avdeenko");

        Teacher teacher = new Teacher();
        teacher.setName("Gennadi");
        teacher.setSurname("Vlasik");

        Course course = new Course();
        course.setDescription("JD-2");
        course.setTeacher("Vlasik G.");

        Task task = new Task();
        task.setDescription("Task_09");

        Review review = new Review();
        review.setGrade(9);
        review.setReview("Well done");

        dao.save(user);
        dao.save(student);
        dao.save(student1);
        dao.save(teacher);
        dao.save(course);
        dao.save(task);
        dao.save(review);

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();
    }
}
