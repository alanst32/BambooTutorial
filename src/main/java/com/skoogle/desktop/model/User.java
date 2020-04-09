package com.skoogle.desktop.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Document("User")
public class User implements Serializable {

    private static final long serialVersionUID = 7526472295622446147L;

    public static final String COLLECTION_NAME = "User";

    // import java.util.UUID
    // val uuid = UUID.randomUUID

    @Id
    @Field("id")
    private String id;

    @Field("name")
    private String name;

    private String crendential;

    private String schoolId;

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

    public String getCrendential() {
        return crendential;
    }

    public void setCrendential(String crendential) {
        this.crendential = crendential;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
