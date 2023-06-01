package unipar.exemplo.repository.cliente;

import unipar.exemplo.connection.ConnectionGenerico;

import java.sql.ResultSet;

public class ReposirotyCliente
{
    public void inserirCliente(){}
    public void alterarCliente(){}
    public void deletarCliente(){}
    public void buscarCliente()
    {
        ConnectionGenerico connection = new ConnectionGenerico();
        try
        {
            connection.getConnection();
            String query="SELECT * FROM clientes";

            ResultSet result = connection.statement.executeQuery(query);

            while(result.next())
            {
                Integer IdCliente = result.getInt("IdCliente");
                String nome = result.getString("nome");
                String cnpj = result.getString("cnpj");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                String situacao= result.getString("situacao");
                String cidade= result.getString("Cidade");
                String estado= result.getString("estado");
                Double credito=result.getDouble("credito");

                System.out.println("Cadastro produto");
                System.out.println("IdCliente :" + IdCliente);
                System.out.println("Nome :"+nome);
                System.out.println("cnpj :"+cnpj);
                System.out.println("telefone :" +telefone);
                System.out.println("email :"+email);
                System.out.println("Situação :"+situacao);
                System.out.println("cidade :"+cidade);
                System.out.println("estado :"+estado);
                System.out.println("credito"+credito);
            }
            connection.closeConnection();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
