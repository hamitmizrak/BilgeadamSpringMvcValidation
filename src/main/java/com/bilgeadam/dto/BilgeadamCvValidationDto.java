package com.bilgeadam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//validation anonation: @NotEmpty, @Size,@Min,Max,@Pattern,@Email
public class BilgeadamCvValidationDto {

//    userName;
//    userMiddleName;
//    userSurname;
//    userAddress;
//    userEmailAddress;
//    userAge;
//    userPhone;
//    userMessage;
//    creationDate;

    //object variable
    @NotEmpty(message = "adı boş geçemezsiniz")
    private String userName;

    private String userMiddleName;

    @NotEmpty(message = "soyadını boş geçemezsiniz")
    private String userSurname;

    @NotEmpty(message = "adresi boş geçemezsiniz")
    private String userAddress;

    @NotEmpty(message = "email adresini boş geçemezsiniz")
    @Email(message = "uygun olmayan formatta mail yazdınız")
    private String userEmailAddress;


    @Min(value = 18,message = "18 yaşından küçükler başvuramaz")
    @Max(value = 45,message = "45 yaşından büyükler başvuramaz")
    private int userAge;

    @NotEmpty(message = "telefon girmek zorunludur.")
    @Pattern(regexp ="[0-9\\s]{12}")
    private String userPhone;

    @NotEmpty(message = "mesaj girmek zorunludur.")
    @Size(min = 1,max = 10)
    private String userMessage;

    private Date creationDate=new Date(System.currentTimeMillis());





}
