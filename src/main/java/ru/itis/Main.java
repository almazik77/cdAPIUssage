package ru.itis;

import com.beust.jcommander.JCommander;
import ru.itis.models.ContestInfo;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        JCommander.newBuilder()
                .addObject(new Commander())
                .build()
                .parse(args);

        DataRepository dataRepository = new DataRepository(Commander.filePath);
        ContestInfo contestInfo = null;
        DataFromAPI fromAPI = new DataFromAPI();

        boolean canFindPropertiesFile = true;

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("codeforcesAPI.properties"));
        } catch (IOException e) {
            System.out.println("Cant find properties");
            canFindPropertiesFile = false;
        }
        String apiKey = properties.getProperty("apiKey");
        String secret = properties.getProperty("secret");

        try {
            for (Long contestId : Commander.ids) {
                System.out.println("Parsing contest with id = " + contestId);
                if (canFindPropertiesFile)
                    contestInfo = fromAPI.sendGet(contestId, apiKey, secret);
                else contestInfo = fromAPI.sendGet(contestId);
                dataRepository.save(contestInfo);
            }

        } finally {
            fromAPI.close();
            dataRepository.close();
            Files.delete(Paths.get(Commander.filePath));
            Files.move(Paths.get(Commander.filePath + ".new"), Paths.get(Commander.filePath));
        }

    }
}
