package com.skoogle.desktop.dto;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public class SchoolRequestDto {

    private String name;
    private AddressDto address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
