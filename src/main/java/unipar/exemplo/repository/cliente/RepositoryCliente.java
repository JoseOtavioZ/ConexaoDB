package unipar.exemplo.repository.cliente;

import unipar.exemplo.connection.ConnectionGenerico;
import unipar.exemplo.entity.Produto;
import unipar.exemplo.login.Cliente;
import unipar.exemplo.utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCliente
{
    public void inserirCliente(Cliente cliente) throws SQLException {
        ConnectionGenerico connection = new ConnectionGenerico();

        connection.getConnection();

        String query = "INSERT INTO CLIENTES (IDCLIENTE,NOME,CNPJ,TELEFONE,EMAIL,SITUACAO,CIDADE,ESTADO,CREDITO)VALUES("+cliente.getCodigo()+",'"+cliente.getNome()+"','"+cliente.getCnpj()+"','"+cliente.getTelefone()+"','"+cliente.getEmail()+"','"+cliente.getSituacao()+"','"+cliente.getCidade()+"','"+cliente.getEstado()+"',"+cliente.getCredito()+")";

        Integer retorno = connection.statement.executeUpdate(query);

        connection.closeConnection();
    }
    public void alterarCliente(){}
    public void deletarCliente(){}
    public List<Cliente> buscarCliente()
    {
        ConnectionGenerico connection = new ConnectionGenerico();
        try
        {
            List<Cliente> listaRetornoCliente = new ArrayList<>();
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

                Cliente clienteBanco = new Cliente();
                clienteBanco.setCodigo(IdCliente);
                clienteBanco.setNome(nome);
                clienteBanco.setCnpj(cnpj);
                clienteBanco.setTelefone(telefone);
                clienteBanco.setEmail(email);
                clienteBanco.setSituacao(situacao);
                clienteBanco.setCidade(cidade);
                clienteBanco.setEstado(estado);
                clienteBanco.setCredito(credito);

                listaRetornoCliente.add(clienteBanco);
            }
            connection.closeConnection();

            return listaRetornoCliente;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

}
