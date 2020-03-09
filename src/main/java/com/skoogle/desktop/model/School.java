package com.skoogle.desktop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Document("School")
public class School {

    public static final String COLLECTION_NAME = "School";

    // import java.util.UUID
    // val uuid = UUID.randomUUID

    @Id
    @Field("id")
    private String id;

    @Field("name")
    private String name;

    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
