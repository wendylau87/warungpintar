package com.warungpintar.simpleapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.warungpintar.simpleapi.model.Greet;
import com.warungpintar.simpleapi.service.FileService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileServiceImpl implements FileService {
    private static final String FILENAME = "history.json";

    @Override
    public boolean save(Greet greet) {
        try{
            Gson gson = new Gson();
            List<Greet> greets = this.readAll();
            File file = new File(FILENAME);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            greets.add(greet);
            String jsonString = gson.toJson(greets);
            writer.write(jsonString);
            writer.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public List<Greet> readAll() {
        List<Greet> greets = null;
        try{
            Gson gson = new Gson();
            File file = new File(FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(FILENAME);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String jsonString = new String(data, "UTF-8");
            greets = gson.fromJson(jsonString, new TypeToken<List<Greet>>(){}.getType());
            if(greets == null){
                greets = new ArrayList<>();
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return greets;
    }



}
