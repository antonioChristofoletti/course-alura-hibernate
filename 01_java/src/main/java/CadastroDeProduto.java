import modelo.Produto;
import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1L);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("celulares");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal preco = produtoDao.buscarPrecoPorNome("Xaomi Redmi");
        System.out.println("Preco do produto: " + preco);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("Xaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}