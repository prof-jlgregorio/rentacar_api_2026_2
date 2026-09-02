package br.com.jlgregorio.rentacar.exception;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CustomExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

}
