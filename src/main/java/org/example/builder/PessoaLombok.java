package org.example.builder;

import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PessoaLombok {

    private String nome;
    private String email;
    private Date dataNascimento;
}
