package com.naveen.githubdemo.model;

//import java.util.UUID;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
//@Table(name = "demo_data")
public class DemoData {

    //@Id
    //@Column(name = "id")
    private String id;

    //@Column(name = "name")
    private String name;

    //@Column(name = "description")
    private String description;
}