package com.example.AeroParker.dto;

import java.util.Objects;

public class SiteDTO {

    private String siteName;


    public SiteDTO() {
    }

    public SiteDTO(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public SiteDTO siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SiteDTO)) {
            return false;
        }
        SiteDTO siteDTO = (SiteDTO) o;
        return Objects.equals(siteName, siteDTO.siteName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(siteName);
    }

    @Override
    public String toString() {
        return "{" +
            " siteName='" + getSiteName() + "'" +
            "}";
    }

}