package com.besedo.repository;

import com.besedo.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Data, Integer> {

    Data save(Data data);

    Page<Data> findAll(Pageable pageable);

    @Query("SELECT list from Data AS list "
            + "WHERE list.id = :id "
            + " OR list.email = :email "
            + " OR list.title = :title "
            + " OR list.body like %:body% "
    )
    Page<Data> findDataList(@Param("id") String id, @Param("email") String email, @Param("title") String title,
                            @Param("body") String body, Pageable pageable);


}
