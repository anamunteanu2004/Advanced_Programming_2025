package com.exemplu;

import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testRepo();
    }

    private void testRepo() {
        RepositoryService service = new RepositoryService();
        Repository repo = service.load("/home/Desktop/laborator_AP/L5/repo.txt");

        //adaugam imagini noi
        repo.add(new Image("Duke", "2025-03-28", List.of("java", "duke"), "c:/images/duke.png"));
        repo.add(new Image("Java Logo", "2025-03-28", List.of("logo", "java"), "c:/images/java_logo.png"));


        System.out.println(repo);

        service.view(repo.findImageByName("Duke")); //deschide imaginea

        String filePath = "/home/Desktop/laborator_AP/L5/updated_repo.txt";

        service.save(repo, filePath);
    }
}
