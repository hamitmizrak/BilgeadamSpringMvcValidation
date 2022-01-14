package com.bilgeadam.validationdata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BilgeadamCvValidation {

    //object variable
    private String userName;
    private String userSurname;
    private String userAddress;
    private String userEmailAddress;
    private int userAge;
    private String userPhone;
    private Date creationDate;


}
