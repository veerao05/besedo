package com.besedo.business.impl;

import com.besedo.business.DataService;
import com.besedo.model.Data;
import com.besedo.repository.DataRepository;

import com.besedo.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class DataServiceImpl implements DataService {

    private static final Logger logger = LogManager.getLogger(DataServiceImpl.class);

    @Autowired
    private DataRepository dataRepository;

    @Override
    public void save(Data data) {
        dataRepository.save(data);
    }

    @Override
    public Map<String, Object> findDataList(String id, String email, String title, String body, Pageable pageable, boolean csv) {

        Page<Data> pageResultData;
        if (id == null & email == null & title == null & body == null) {
            pageResultData = dataRepository.findAll(pageable);
        } else {
            pageResultData = dataRepository.findDataList(id, email, title, body, pageable);
        }

        return convertToDomainPageResult(pageResultData, csv);
    }

    private Map<String, Object> convertToDomainPageResult(final Page<Data> pageResult, boolean csv) {
        Map<String, Object> response = new HashMap<>();
        if (csv) {
            response.put("result", CsvUtils.convertToCSV(pageResult.getContent()));
        } else {
            response.put("result", pageResult.getContent());
        }
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());

        logger.debug("Response data::" + response);
        return response;
    }


 /*   public List<Data> find(String id, String email) {

        Data data = Data.builder().id(id).email(email).build();
        System.out.println(data);
        return dataRepository.findAll(Example.of(data));
    }


    private ExampleMatcher dataMatcher() {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("body", contains().ignoreCase());
        return matcher;
    }*/
}
