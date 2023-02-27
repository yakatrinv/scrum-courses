package dataTest;

import entity.*;

import java.util.HashSet;
import java.util.Set;

public class TestData {

    public static User getUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public static Student getStudent(String name, String surname) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        return student;
    }

    public Teacher getTeacher(String name, String surname) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSurname(surname);
        return teacher;
    }

    public Course getCourse(String description) {
        Course course = new Course();
        course.setDescription(description);
        return course;
    }
    public Task getTask(String description){
        Task task = new Task();
        task.setDescription(description);
        return task;
    }

    public Review getReview(Integer mark, String taskReview){
        Review review = new Review();
        review.setMark(mark);
        review.setReview(taskReview);
        return review;
    }

    public static Set<User> fillUsers() {
        Set<User> users = new HashSet<>();

        users.add(getUser("Administrator", "admin"));
        users.add(getUser("Vlasik", "vlasik"));

        users.add(getUser("Petrusevich", "petrusevich"));
        users.add(getUser("Avdeenko", "avdeenko"));
        users.add(getUser("Golovij", "golovij"));
        users.add(getUser("Lipski", "lipski"));
        users.add(getUser("Yaroshevich", "yaroshevich"));

        return users;
    }

    public static Set<Student> fillStudents() {
        Set<Student> students = new HashSet<>();

        students.add(getStudent("Maksim", "Petrusevich"));
        students.add(getStudent("Artem", "Lipski"));
        students.add(getStudent("Katerina", "Yaroshevich"));

        return students;
    }

    public static Set<Student> fillStudentsJD2() {
        Set<Student> students = new HashSet<>();

        students.add(getStudent("Maksim", "Petrusevich"));
        students.add(getStudent("Oleg", "Avdeenko"));
        students.add(getStudent("Matvei", "Golovij"));
        students.add(getStudent("Artem", "Lipski"));
        students.add(getStudent("Katerina", "Yaroshevich"));

        return students;
    }

    public static Course getCourseCore() {
        Course course = new Course();
        course.setDescription("Java Core");
        return course;
    }

    public static Task getTask(){
        Task task = new Task();
        task.setDescription("Task 09");
        return task;
    }

    public static Teacher getTeacherCore() {
        Teacher teacher = new Teacher();
        teacher.setName("Gennadi");
        teacher.setSurname("Vlasik");
        return teacher;
    }

    public static Review getReviewCore(){
        Review review = new Review();
        review.setMark(9);
        review.setReview("Review task Java Core, read me");
        return review;
    }

    public static Course getCourseJD2() {
        Course course = new Course();
        course.setDescription("JD2");
        return course;
    }

    public static Task getTaskJD2(){
        Task task = new Task();
        task.setDescription("Task 09 JD2");
        return task;
    }

    public static Teacher getTeacherJD2() {
        Teacher teacher = new Teacher();
        teacher.setName("Gennadi");
        teacher.setSurname("Vlasik");
        return teacher;
    }

    public static Review getReviewJD2(){
        Review review = new Review();
        review.setMark(9);
        review.setReview("Review task Java JD2, read me");
        return review;
    }
}
