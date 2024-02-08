package com.elif.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
//Normalde Enum'da değişken tanımlamazdık. Burada değişken tanımladık. Her özelliği bir enumun içerisine verdik. Hata veriyordu ilk yazdığımızda
//Lombok anotasyonu ekledik getter ve allArgsCons
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(1000,"Kontroller katmanında tanımsız gelen hata oluştu. Lütfen tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Kullanıcı adı zaten kayıtlı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_REGISTRATION(2000,"Kullanıcı adı zaten kayıtlı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(2001,"Kullanıcı adı ya da parola hatalı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(1001,"Girilen paratmetreler hatalıdır. Lütfen düzelterek tekrar deneyiniz.",HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
