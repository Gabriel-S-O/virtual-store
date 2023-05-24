package com.dev.backend.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.dev.backend.Dto.CityDto;
import com.dev.backend.repository.StateRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.City;
import com.dev.backend.repository.CityRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    private static StateService stateService;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    public City insert(City city) {
        city.setCreationDate(new Date());
        City newCity = cityRepository.saveAndFlush(city);
        return newCity;
    }

    public City update(City city) {
        city.setUpdateDate(new Date());
        return cityRepository.saveAndFlush(city);
    }

    public void delete(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("City not found."));
        cityRepository.delete(city);

    }

    public void saveCSV(MultipartFile file) {

        //TODO
        // PELO AMOR DE DEUS REFATORAR E QUEBRAR ESSE MÉTODO EM PARTES!!!!!!!!!!!!

        try {
            BufferedReader fileReader = new BufferedReader(new
                    InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            ArrayList<CityDto> cities = new ArrayList<>();

            City city = new City();

            for (CSVRecord csvRecord : csvRecords) {
                CityDto cityDto = new CityDto(
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("nome"),
                        Long.parseLong(csvRecord.get("estado_id"))
                );
            }

            //TODO
            // Criar um método pra converter cityDTO em city se você ainda respeita a humanidade

            for(CityDto cityDto : cities){
                city.setId(cityDto.getId());
                city.setName(cityDto.getName());
                city.setState(stateService.findById(cityDto.getStateId()));
                insert(city);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
