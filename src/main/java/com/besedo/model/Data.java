package com.besedo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@lombok.Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}, name = "DATA")
public class Data {

    @Id
    @Column(name = "id")
    @Size(min = 1, max = 100)
    private String id;

    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "title")
    @Size(max = 300)
    private String title;

    @Column(name = "body")
    @Size(max = 10000)
    private String body;

}
