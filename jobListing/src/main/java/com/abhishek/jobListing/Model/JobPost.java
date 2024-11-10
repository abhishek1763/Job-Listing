package com.abhishek.jobListing.Model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "jobs")
public class JobPost {
    private String desc;
    private String exp;
    private String profile;
    private String[] techs;

    public JobPost() {
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "desc='" + desc + '\'' +
                ", exp='" + exp + '\'' +
                ", profile='" + profile + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
