package com.exemplu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RepositoryService {
    public void save(Repository repo, String path) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (Image img : repo.getImages()) {
                //salvam fiecare imagine pe o linie: Nume,Data,Tag1;Tag2;Tag3,Locatie
                out.write(img.getName() + "," + img.getDate() + "," + String.join(";", img.getTags()) + "," + img.getPath());
                out.newLine(); //trecem la linia următoare
            }
        }
    }

    public void view(Image img) {
        System.out.println("Name: " + img.getName());
        System.out.println("Date: " + img.getDate());
        System.out.println("Tags: " + String.join(", ", img.getTags()));
        System.out.println("Path: " + img.getPath());
    }    

    //incarca imaginile dintr-un fisier text
    public Repository load(String path) throws IOException {
        Repository repo = new Repository();
        
        List<String> lines = Files.readAllLines(Paths.get(path));
        
        for (String line : lines) {
            String[] parts = line.split(","); 
            if (parts.length < 4) continue;
            
            String name = parts[0];
            String date = parts[1];
            List<String> tags = List.of(parts[2].split(";"));
            String location = parts[3];

            Image img = new Image(name, date, tags, location);
            repo.add(img);
        }
        
        return repo;
    }
}
