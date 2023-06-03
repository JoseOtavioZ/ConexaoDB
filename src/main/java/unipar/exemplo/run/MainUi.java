package unipar.exemplo.run;

import unipar.exemplo.ui.TelaCadastroProduto;

import javax.swing.*;

public class MainUi
{
//melhor caminho pro trabalho hotel
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createUI();;
            }
        });
    }

    private static void createUI()
    {
        TelaCadastroProduto formProduto = new TelaCadastroProduto();

        JFrame frame = new JFrame();
        frame.setContentPane(formProduto.panelMain);
        frame.setTitle("CADASTRO DE PRODUTOS");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
