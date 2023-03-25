package com.besedo.business;


import com.besedo.model.Data;
import org.springframework.data.domain.Pageable;

import java.util.Map;


public interface DataService {

    void save(Data data);

    Map<String, Object> findDataList(String id, String email, String title, String body, Pageable pageable, boolean csv);
}
