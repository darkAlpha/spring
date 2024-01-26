package org.mura.asyncservice.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ModelDTO {

    private String id;
    private String messageId;
    private String message;
    private LocalDate createDate;
    private String status;

}
