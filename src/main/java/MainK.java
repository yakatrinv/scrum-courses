import dao.DAO;
import dao.DaoImpl;
import dataTest.TestData;
import entity.Course;
import entity.Review;
import entity.Student;
import entity.Task;
import entity.Teacher;
import entity.User;
import utils.HibernateUtil;

import java.util.Set;

public class MainK {
    private static final Set<User> users =TestData.fillUsers();
    private static final Set<Student> students=TestData.fillStudents();
    private static final Set<Student> studentsJD2=TestData.fillStudentsJD2();
    private static final DAO<Object> dao = new DaoImpl<>();

    public static void main(String[] args) {
        firstCourse();
        secondCourse();

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();
    }

    private static void firstCourse() {
        for (User user : users) {
            dao.save(user);
            System.out.println(user.getId());
        }

        Teacher teacher = TestData.getTeacherCore();
        Course course = TestData.getCourseCore();
        course.setTeacher(teacher);

        Task task = TestData.getTask();
        Review reviewCore = TestData.getReviewCore();


        task.getReviewSet().add(reviewCore);
        reviewCore.getTasks().add(task);

        for (Student student : students) {
            course.getStudents().add(student);
            task.getStudentSet().add(student);
            reviewCore.getStudentHashSet().add(student);

            student.getTasks().add(task);
            student.getReviews().add(reviewCore);
        }

//        dao.save(task);
        dao.save(course);
    }

    private static void secondCourse() {
//        studentsJD2 = TestData.fillStudentsJD2();

        Teacher teacherJD2 = TestData.getTeacherJD2();
        Course courseJD2 = TestData.getCourseJD2();
        courseJD2.setTeacher(teacherJD2);

        Task taskJD2 = TestData.getTaskJD2();
        Review reviewJD2 = TestData.getReviewJD2();


        taskJD2.getReviewSet().add(reviewJD2);
        reviewJD2.getTasks().add(taskJD2);

        for (Student studentJD2 : studentsJD2) {
            courseJD2.getStudents().add(studentJD2);
            taskJD2.getStudentSet().add(studentJD2);
            reviewJD2.getStudentHashSet().add(studentJD2);

            studentJD2.getTasks().add(taskJD2);
            studentJD2.getReviews().add(reviewJD2);
        }
        dao.save(courseJD2);
//        dao.save(taskJD2);
    }
}
