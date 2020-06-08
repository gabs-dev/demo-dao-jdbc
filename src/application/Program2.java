package application;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDaoJDBC departmentDao = DaoFactory.createDepartmentDao();
        Scanner input = new Scanner(System.in);

        System.out.println("=== TEST 1: department findById ===");
        System.out.println("Enter a department ID: ");
        int id = input.nextInt();
        Department d = departmentDao.findById(id);
        if (d != null) {
            System.out.println(d);
        } else {
            System.err.println("No departments found!");
        }

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        //Department newDepartment = new Department(null, "Construction");
        //departmentDao.insert(newDepartment);
        //System.out.println("Inserted! New ID = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        try {
            Department dep = departmentDao.findById(6);
            dep.setName("Test");
            departmentDao.update(dep);
            System.out.println("Update completed!");
        } catch (DbException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("No department found!");
        }

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.println("Enter a department Id: ");
        id = input.nextInt();
        try {
            departmentDao.deleteById(id);
            System.out.println("Delete completed!");
        } catch (DbException e) {
            System.err.println(e.getMessage());
        }

        input.close();

    }

}
