package com.skoogle.desktop.dto;

import java.io.Serializable;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public class SchoolUserDto implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    private String user;
    private String credential;
    private String name;
    private String schoolId;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
