package unipar.exemplo.dbsimples;


import java.sql.*;

public class ConexaoDbSimples
{
    public static void main(String[] args) throws SQLException {
        conectarBancoDeDados();
    }
    public static void conectarBancoDeDados() throws SQLException {

        String url="jdbc:postgresql://localhost:5432/";
        String usersname="postgres";
        String password="adm123";
        String codigoWhere="1";
        try
        {
            //Iniciamos a criação da conexão
            Connection conn = DriverManager.getConnection(url, usersname, password);

            //cria a interface para conexão com o banco
            //nela vamos executar o select, insert, update, delete
            Statement statement =  conn.createStatement();

            //Executar uma querty sql
            ResultSet result = statement.executeQuery("SELECT * FROM produtos where codigo="+ codigoWhere);

            while (result.next()){
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
            conn.close();

        }
        catch(Exception e)
        {
            //Vai exibir o log do exception
            e.printStackTrace();
            System.out.println("DEU ERRO");
        }
    }
}
