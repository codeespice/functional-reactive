package com.example.functional.reactive.unit9;

import com.example.functional.reactive.unit6.Book;

import javax.xml.catalog.Catalog;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsAction {
    public static void main(String[] args){
        Path path = Paths.get("/Users/adwaita/RadhaKrishna/Development/Install/git_repo/functional-reactive/src/main/java/com/example/functional/reactive/unit9/EmployeeData.txt");
        try(Stream<String> lines = Files.lines(path);) {

            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeeList = employees.collect(Collectors.toList());
            employeeList.forEach(System.out::println);


            // get all the departments
          Set<String> designations =   employeeList.stream()
                    .map(employee->employee.getDesignation())
                    .distinct()
                  .collect(Collectors.toSet());
          System.out.println("Designations::::");
            designations.forEach(System.out::println);

            //to collection method
            /*TreeSet<Employee> emplyeesSorted = employeeList.stream()
                    .collect(Collectors.toCollection(()->new TreeSet<Employee>()));*/
            TreeSet<Employee> emplyeesSorted = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println("Sorted::::");
            emplyeesSorted.forEach(System.out::println);


            //to map
           Map<Integer,String> employeesNames= employeeList.stream()
                    .collect(Collectors.toMap(employee->employee.getId(),employee->employee.getName()));
            System.out.println("Employees Name::::");
            employeesNames.keySet().forEach(key->System.out.println(employeesNames.get(key)));

            //Partitiion
           Map<Boolean,List<Employee>> genderList = employeeList.stream()
                    .collect(Collectors.partitioningBy(employee->employee.getGender()=='M'));
            System.out.println("Male Employees::::");
            genderList.get(true).stream().forEach(System.out::println);
            System.out.println("Female Employees::::");
            genderList.get(false).stream().forEach(System.out::println);


            //Employees Sorted
            System.out.println(" Employees Sorted::::");
            employeeList.stream()
                    .sorted()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            //Group By Designation
            System.out.println("Group By Designation::::");
           Map<String,List<Employee>> groupedByEmployees = employeeList.stream()
                    .collect(Collectors.groupingBy(employee->employee.getDesignation()));
            groupedByEmployees.keySet().forEach(key->System.out.println(groupedByEmployees.get(key)));

            //Collectors.joining
            String employeeNames = employeeList.stream()
                    .map(employee->employee.getName())
                    .collect(Collectors.joining(","));
            System.out.println("Employee Names in plain String::::");
            System.out.println( employeeNames);

            //Count number of employees with each Designation
            Map<String,Long> result = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(employee->employee.getDesignation(), Collectors.counting()
                            ));

            System.out.println("Count by Designation::::");
            result.keySet().forEach(key->{
                System.out.println (key+":"+result.get(key));

            });

                //Sum of salaries for each department
           Map<String,Double> departmentSalary=  employeeList.stream()
                    .collect(
                            Collectors.groupingBy(employee->employee.getDesignation(),
                            Collectors.summingDouble(employee->employee.getSalary()
                            )));

            System.out.println("Department Salary::::");
            departmentSalary.keySet().forEach(key->{
                System.out.println (key+":"+departmentSalary.get(key));

            });

            //Max salaried employee
         Map<String,Optional<Employee>> maxSalariedEmployee=  employeeList.stream()
                    .collect( Collectors.groupingBy(employee->employee.getDesignation(),
                            Collectors.maxBy(Comparator.comparing(employee->employee.getSalary())))
                    );

            System.out.println("maxSalaried Employee in each Department :::");
            maxSalariedEmployee.keySet().forEach(key->{
                System.out.println (key+":"+maxSalariedEmployee.get(key).get());

            });

            //Maximum salary by department
           /* employeeList.stream()
                    .collect(
                            Collectors.groupingBy(employee->employee.getDesignation(),
                                    Collectors.mapping(employee->employee.getSalary(),    //use mapping to take object and return salary,mapping takes down stream collector
                                            Collectors.maxBy(Comparator.comparing(salary->salary))))); //Compare only salary


            */
        /*    Map<String, Optional<Double>> maxSalaries =
                    employeeList.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            e -> e.getDesignation(),
                                            Collectors.mapping(
                                                    e -> e.getSalary(),
                                                    Collectors.maxBy(Comparator.comparing(Function.identity()))
                                            )
                                    )
                            );


            System.out.println("Maximum Salary  in each Department :::");
            maxSalaries.keySet().forEach(key->{
                System.out.println (key+":"+maxSalaries.get(key));

            });*/


        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
