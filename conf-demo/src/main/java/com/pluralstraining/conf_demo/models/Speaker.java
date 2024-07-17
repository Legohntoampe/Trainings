package com.pluralstraining.conf_demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;


import java.util.List;

@Entity(name="speakers")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;
    @Lob
    //@Type(type = "org.hybernate.type.BinaryType")// this does not work on the newer hibernate 6.* which is the default that comes with spring 3.* I will have to find a work around for this
    //check to see if removing the @Type annotation works otherwise need to figure out what the replacement for this deprecated code is.
    private byte[] speaker_photo;
    @ManyToMany(mappedBy="speakers")
    private List<Session> sessions;
    public Speaker(){

    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
