package com.besedo.controller;

import com.besedo.business.DataService;
import com.besedo.model.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(path = "/data")
public class DataController {

    private static final Logger logger = LogManager.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    /**
     * Method to post the  data
     *
     * @param data
     * @return ResponseEntity<Data>
     */

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Data> addData(@Valid @RequestBody Data data) {
        try {
            dataService.save(data);
            logger.debug("Data inserted successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Method to get data with pagination filter,size and csv reports
     *
     * @param id
     * @param email
     * @param title
     * @param body
     * @param page
     * @param size
     * @param csv
     * @return ResponseEntity<Object>
     */

    @GetMapping()
    public ResponseEntity<Object> getAllData(@RequestParam(required = false) String id,
                                             @RequestParam(required = false) String email,
                                             @RequestParam(required = false) String title,
                                             @RequestParam(required = false) String body,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size,
                                             @RequestParam(required = false) boolean csv) {
        Pageable paging = PageRequest.of(page, size);
        Map<String, Object> data = dataService.findDataList(id, email, title, body, paging, csv);
        if (csv) {
            logger.debug("CSV Data fetched successfully");
            return ResponseEntity.ok(data.get("result"));
        } else {
            logger.debug("Data fetched successfully");
            return ResponseEntity.ok(data);
        }
    }

}
