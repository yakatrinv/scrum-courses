import dao.*;
import dataTest.TestData;
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
        TestData testData = new TestData();
        User user = testData.getUser("root", "12345");
        Student student = testData.getStudent("Max", "Petrukevich");
        Teacher teacher = testData.getTeacher("Gennadi", "Vlasik");
        Course course = testData.getCourse("JD-2");
        Task task = testData.getTask("Task_09");
        Review review = testData.getReview(9, "Well done");

        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        course.getStudents().add(student);


        task.getStudentSet().add(student);
        student.getCourseSet().add(course);
        student.getTasks().add(task);
        student.getReviews().add(review);
        task.getReviewSet().add(review);
        review.getTasks().add(task);
        review.getStudentHashSet().add(student);

        dao.save(user);
        dao.save(student);

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();

    }
}
