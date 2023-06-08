package unipar.exemplo.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Integer codigo;
    private String nome;
    private String cnpj;
    private String Telefone;
    private String email;
    private String situacao;
    private String cidade;
    private String estado;
    private Double credito;

}
