package application;

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

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        input.close();

    }

}
