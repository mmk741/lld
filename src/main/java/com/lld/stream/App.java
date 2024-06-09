package com.lld.stream;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // TODO
        // QnA
//        1. List all distinct project in non-ascending order.
        System.out.println("************************1************************");

        List<Project> project1 = employeeList.stream().flatMap(emp->emp.getProjects().stream()).distinct()
                .sorted((p1,p2)->p2.getName().length()-p1.getName().length()).collect(Collectors.toList());













        List<Project> project = employeeList.stream().flatMap(x -> x.getProjects().stream()).distinct()
                .sorted(Comparator.comparing(Project::getName).reversed())
                .collect(Collectors.toList());
        project1.forEach(System.out::println);
//        2. Print full name of any employee whose firstName starts with ‘A’.
        System.out.println("************************2************************");
        List<String>  employeeNAme = employeeList.stream().filter(e -> e.getFirstName().charAt(0) == 'A').
                map(e -> e.getFirstName() + e.getLastName()).collect(Collectors.toList());
        employeeNAme.forEach(System.out::println);


//
//        3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        System.out.println("************************3************************");

        List<Employee> employee = employeeList.stream().filter(x -> x.getId().substring(0,4).
                equalsIgnoreCase("2023")).collect(Collectors.toList());
employee.forEach(e->System.out.println(e.toString()));
//
//        4. Sort employees based on firstName, for same firstName sort by salary.
        System.out.println("************************4************************");
        List<Employee> empNameSalarySort = employeeList.stream().
                sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary)).collect(Collectors.toList());
        empNameSalarySort.forEach(e->System.out.println(e.toString()));

//
//        5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        System.out.println("************************5************************");


        Optional<Integer> first = employeeList.stream().map(e->e.getSalary()).distinct().
                sorted((Integer x1,Integer x2)->x2-x1).skip(2).findFirst();
        List<Employee> thirdHighSalary = employeeList.stream().filter(e -> e.getSalary() == first.orElse(-1)).collect(Collectors.toList());
thirdHighSalary.forEach(e->System.out.println(e.toString()));

//
//        6. Print min salary.
        System.out.println("************************6************************");
        Optional<Integer> minSal = employee.stream().map(Employee::getSalary).sorted().findFirst();
        System.out.println("Min salary : "+minSal.orElse(-1));




//
//        8. List of people working on more than 2 projects.
        System.out.println("************************8************************");
        List<Employee> empMoreThanOneProject = employeeList.stream().filter(x -> x.getProjects().size() > 2).collect(Collectors.toList());
        empMoreThanOneProject.forEach(e->System.out.println(e.toString()));


//
//        9. Count of total laptops assigned to the employees.
        System.out.println("************************9************************");
        long count = employeeList.stream().mapToInt(Employee::getTotalLaptopsAssigned).sum();
        System.out.println(count);

//
//        10. Count of all projects with Robert Downey Jr as PM.
        System.out.println("************************10************************");
        long robert_downey_jr = employeeList.stream().flatMap(e -> e.getProjects().stream()).distinct().filter(e -> e.getProjectManager().equalsIgnoreCase("Robert Downey Jr")).count();
        System.out.println(robert_downey_jr);
//
//        11. List of all projects with Robert Downey Jr as PM.
        System.out.println("************************11************************");
        List<Project> robert_downey_jr1 = employeeList.stream().flatMap(e -> e.getProjects().stream()).
                distinct().filter(e -> e.getProjectManager().equalsIgnoreCase("Robert Downey Jr")).collect(Collectors.toList());
robert_downey_jr1.forEach(e->System.out.println(e.toString()));

//
//        12. List of all people working with Robert Downey Jr.
        System.out.println("************************12************************");
        List<Employee> employeesWorkingWithTargetManager = employeeList.stream()
                .filter(e -> e.getProjects().stream()
                        .anyMatch(p -> p.getProjectManager().equals("Robert Downey Jr")))
                .collect(Collectors.toList());

        employeesWorkingWithTargetManager.forEach(e->System.out.println(e.toString()));
//
//        13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
        System.out.println("************************13************************");
        Map<String, List<Employee>> collectMap = employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0, 4)));
       collectMap.forEach((year,emp)-> System.out.println(year+" :"+emp.toString()));


//        14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
        System.out.println("************************14************************");
        Map<String, Long> collectMap2 = employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0, 4), Collectors.counting()));
        collectMap2.forEach((year,emp)-> System.out.println(year+" :"+emp));

    }
}