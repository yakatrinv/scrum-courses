import dao.*;
import entity.*;

public class Main {
    public static void main(String[] args) {

        DaoUser daoUser = new DaoUserImpl();
        DaoStudent daoStudent = new DaoStudentImpl();
        DaoTeacher daoTeacher = new DaoTeacherImpl();
        DaoCourse daoCourse = new DaoCourseImpl();
        DaoTask daoTask =new DaoTaskImpl();
        DaoReview daoReview = new  DaoReviewImpl();

        User user = new User();
        user.setLogin("root");
        user.setPassword("12345");

        Student student = new Student();
        student.setName("Max");
        student.setSurname("Petrukevich");
        Student student1 = new Student();
        student1.setName("Oleg");
        student1.setSurname("Avdeenko");

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

        daoUser.save(user);
        daoStudent.save(student1);
        daoStudent.save(student);
        daoTeacher.save(teacher);
        daoCourse.save(course);
        daoTask.save(task);
        daoReview.save(review);

    }
}
