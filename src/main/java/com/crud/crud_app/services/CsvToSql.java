package com.crud.crud_app.services;

import com.crud.crud_app.entity.Player;
import com.crud.crud_app.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class CsvToSql {

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void loadCsvData() {
        try (Reader reader = new InputStreamReader(new ClassPathResource("Player.csv").getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())){

            for(CSVRecord record: csvParser){
                Player player = new Player();
                player.setPlayerID(record.get("playerID"));
                player.setBirthYear(record.get("birthYear"));
                player.setBirthMonth(record.get("birthMonth"));
                player.setBirthDay(record.get("birthDay"));
                player.setBirthCountry(record.get("birthCountry"));
                player.setBirthState(record.get("birthState"));
                player.setBirthCity(record.get("birthCity"));
                player.setDeathYear(record.get("deathYear"));
                player.setDeathMonth(record.get("deathMonth"));
                player.setDeathDay(record.get("deathDay"));
                player.setDeathCountry(record.get("deathCountry"));
                player.setDeathState(record.get("deathState"));
                player.setDeathCity(record.get("deathCity"));
                player.setNameFirst(record.get("nameFirst"));
                player.setNameLast(record.get("nameLast"));
                player.setNameGiven(record.get("nameGiven"));
                player.setWeight(record.get("weight"));
                player.setHeight(record.get("height"));
                player.setBats(record.get("bats"));
                player.setThrws(record.get("throws"));
                player.setDebut(record.get("debut"));
                player.setFinalGame(record.get("finalGame"));
                player.setRetroID(record.get("retroID"));
                player.setBbrefID(record.get("bbrefID"));
                playerRepository.save(player);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
