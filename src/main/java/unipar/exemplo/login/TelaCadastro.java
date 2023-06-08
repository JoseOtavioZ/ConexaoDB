package unipar.exemplo.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unipar.exemplo.repository.cliente.RepositoryCliente;
import unipar.exemplo.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
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
    public JPanel panelCadastro;
    public JPanel panelPrincipal;
    private JScrollPane tabelaCadastro;

    public TelaCadastro() {

        cadastrarDadosProduto();
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Aqui vou criar um novo produto e vou coletar todos os campos

                try {
                    Cliente novoCadastro = new Cliente();
                    novoCadastro.setCodigo(Utils.convertInteger(textIdCliente));
                    novoCadastro.setNome(textNome.getText());
                    novoCadastro.setCnpj(textCnpj.getText());
                    novoCadastro.setTelefone(textTelefone.getText());
                    novoCadastro.setEmail(textEmail.getText());
                    if (comboBox1.getSelectedIndex() == 0) {
                        novoCadastro.setSituacao("Ativo");
                    } else {
                        novoCadastro.setSituacao("inativo");
                    }
                    novoCadastro.setCidade(textCidade.getText());
                    novoCadastro.setEstado(textEstado.getText());
                    novoCadastro.setCredito(Utils.convertDouble(textCredito));

                    RepositoryCliente repositoryCliente = new RepositoryCliente();

                    repositoryCliente.inserirCliente(novoCadastro);

                    cadastrarDadosProduto();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

    private void cadastrarDadosProduto() {
        table1.setModel(new DefaultTableModel(null, new Object[]
                {
                        "Codigo", "Nome", "CNPJ", "Telefone", "E-mail", "Situação", "Cidade", "Estado", "Credito"
                }));
        RepositoryCliente repositoryCliente = new RepositoryCliente();
        List<Cliente> listaClientesBanco = repositoryCliente.buscarCliente();

        DefaultTableModel tabelac = (DefaultTableModel) table1.getModel();

        listaClientesBanco.forEach(cliente ->
        {
            tabelac.addRow(new Object[]
                    {
                            cliente.getCodigo(), cliente.getNome(), cliente.getCnpj(), cliente.getTelefone(), cliente.getEmail(), cliente.getSituacao(), cliente.getCidade(), cliente.getEstado(), cliente.getCredito()
                    });
        });
    }
}
