package unipar.exemplo.repository.produto;

import unipar.exemplo.connection.ConnectionGenerico;

import java.sql.ResultSet;

public class RepositoryProduto
{

    public void inserirProduto(){}
    public void alterarProduto(){}
    public void deletarProduto(){}
    public void buscarProduto()
    {
        ConnectionGenerico connection = new ConnectionGenerico();

        try
        {
            connection.getConnection();
            String query="SELECT * FROM produtos";

            ResultSet result = connection.statement.executeQuery(query);

            while(result.next())
            {
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");

                System.out.println("Cadastro produto");
                System.out.println("Código :" + codigo);
                System.out.println("Nome :"+nome);
                System.out.println("EAN :"+ean);
                System.out.println("Preço :" +preco);
            }
            connection.closeConnection();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
