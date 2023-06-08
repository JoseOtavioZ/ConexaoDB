package unipar.exemplo.login;



import unipar.exemplo.repository.cliente.RepositoryCliente;


import javax.swing.*;

public class MainCadastro
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run()
            {
                createUI();;
            }
        }));
    }
    private static void createUI()
    {
        TelaCadastro formCliente = new TelaCadastro();
        RepositoryCliente repositoryCliente = new RepositoryCliente();
        repositoryCliente.buscarCliente();

        JFrame frame = new JFrame();
        frame.setContentPane(formCliente.panelCadastro);
        frame.setTitle("CADASTRO DE CLIENTES");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
