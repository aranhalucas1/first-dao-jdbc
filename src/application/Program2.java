package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department dp = departmentDao.findById(4);
		System.out.println(dp);
		
		System.out.println("=== TEST 2: Department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("=== TEST 3: Department insert ===");
		Department department = new Department(6, "Life");
		departmentDao.insert(department);
		System.out.println("Inserted! Id: " + department.getId());
		
		System.out.println("=== TEST 4: Department update");
		dp = departmentDao.findById(4);
		dp.setName("Rola");
		departmentDao.update(dp);
		System.out.println("Updated!");
		 
		System.out.println("=== TEST 2: Department delete ===");
		System.out.println("ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Done!, id " + id + " deleted");
		
	}

}
