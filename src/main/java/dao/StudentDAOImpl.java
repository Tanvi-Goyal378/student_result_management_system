package com.studentapp.dao;

import com.studentapp.model.Student;
import com.studentapp.util.DBUtil;
import java.sql.*;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student s) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student VALUES (?, ?, ?)");
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
            System.out.println("Student Added!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Student getStudent(int id) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM student WHERE studentId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void updateStudent(Student s) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE student SET name=?, course=? WHERE studentId=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getStudentId());
            ps.executeUpdate();
            System.out.println("Student Updated!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM student WHERE studentId=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted!");
        } catch (Exception e) { e.printStackTrace(); }
    }
}

