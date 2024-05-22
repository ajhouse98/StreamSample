package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        ArrayList<Person> names = new ArrayList<>();

        names.add(new Person("Cynthia", "Ortiz", 36));
        names.add(new Person("Gabriel", "Reyes", 45));
        names.add(new Person("Brenda", "Fisher", 56));
        names.add(new Person("Roberto", "Soto", 27));
        names.add(new Person("Veronica", "Rojas", 18));
        names.add(new Person("Ernesto", "Morales", 79));
        names.add(new Person("Natalie", "Castillo", 10));
        names.add(new Person("Armando", "Flores", 30));
        names.add(new Person("Yesenia", "Ramirez", 27));
        names.add(new Person("Miguel", "Mendoza", 25));



        System.out.print("Search by name: ");
        String nameSearched = userInput.nextLine();

        List<Person> namesMatched = names.stream()
                .filter(name -> name.firstName.contains(nameSearched))
                .collect(Collectors.toList());

        System.out.println("Name matched: " + namesMatched);

        double averageAge = names.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum) / (double) names.size();

        System.out.println("Average age: " + averageAge);

        List<Person> sortedByAge = names.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());

        Person youngest = sortedByAge.isEmpty() ? null : sortedByAge.get(0);
        Person oldest = sortedByAge.isEmpty() ? null : sortedByAge.get(sortedByAge.size() - 1);

        System.out.println("Oldest person: " + oldest);
        System.out.println("Youngest person: " + youngest);


    }
}
