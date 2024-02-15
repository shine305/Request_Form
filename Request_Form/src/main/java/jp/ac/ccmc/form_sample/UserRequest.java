package jp.ac.ccmc.form_sample;
import lombok.Data;
@Data
public class UserRequest {
    private String name;
    private String seat;
    private String age;
    private String address;
    private String body;
    private String email;
    private String phone;
    private Boolean isStudent;
}
