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

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();
    }

    private static void fillTestData() {
        DAO<User> daoUser = new DaoUserImpl();
        DAO<Student> daoStudent = new DaoStudentImpl();
        DAO<Course> daoCourse = new DaoCourseImpl();
        DAO<Teacher> daoTeacher = new DaoTeacherImpl();
        DAO<Task> daoTask = new DaoTaskImpl();
        DAO<Review> daoReview = new DaoReviewImpl();

        TestData testData = new TestData();
        User user = testData.getUser("root", "12345");
        Student student = testData.getStudent("Max", "Petrukevich");
        Teacher teacher = testData.getTeacher("Gennadi", "Vlasik");
        Course course = testData.getCourse("JD-2");
        Task task = testData.getTask("Task_09");
        Review review = testData.getReview(9, "Well done");

        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        teacher.getReviewHashSet().add(review);
        course.getStudents().add(student);
        course.getTaskHashSet().add(task);
        student.getCourseSet().add(course);
        student.getTasks().add(task);
        student.getReviews().add(review);
        task.getStudentSet().add(student);
        task.setTaskCourse(course);
        task.getReviewSet().add(review);
        review.setReviewTeacher(teacher);

        daoUser.save(user);
        daoStudent.save(student);

    }
}
