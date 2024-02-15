package jp.ac.ccmc.form_sample;

import lombok.Data;

@Data
public class UserMessage {
    private String name;
    private String gender;
    private String age;
    private String address;
    private String body;
}