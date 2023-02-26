package dataTest;

import entity.*;

public class TestData {

    public User getUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public Student getStudent(String name, String surname) {
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

}
