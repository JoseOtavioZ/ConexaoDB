package unipar.exemplo.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unipar.exemplo.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelaCadastro {

    private JTextField textIdCliente;
    private JTextField textNome;
    private JTextField textCnpj;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JComboBox comboBox1;
    private JTextField textCidade;
    private JTextField textEstado;
    private JTextField textCredito;
    private JButton CADASTRARButton;
    private JTable table1;
    private JPanel PanelCadastro;

    public TelaCadastro() {
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Aqui vou criar um novo produto e vou coletar todos os campos
                Cliente novoCadastro= new Cliente();
                novoCadastro.set (Utils.convertInteger(textIdCliente));



            }
        });
    }
}
