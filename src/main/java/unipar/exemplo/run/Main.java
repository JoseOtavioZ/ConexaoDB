package unipar.exemplo.run;

import unipar.exemplo.entity.Produto;
import unipar.exemplo.repository.produto.RepositoryProduto;

public class Main {
    public static void main(String[] args)
    {
        RepositoryProduto repo = new RepositoryProduto();
        repo.buscarProduto();

        Produto energetico = new Produto();
        energetico.setCodigo(3);
        energetico.setNome("SUCO");
        energetico.setEan("4234234234");
        energetico.setPreco(8d);

        repo.inserirProduto(energetico);

        //ReposirotyCliente repocliente =new ReposirotyCliente();
        //repocliente.buscarCliente();
    }
}
