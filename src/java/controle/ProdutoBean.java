/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Produto;

/**
 *
 * @author cesardias
 */
@ManagedBean
public class ProdutoBean {

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the produtoDAO
     */
    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    /**
     * @param produtoDAO the produtoDAO to set
     */
    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void adicionar() throws SQLException {
        getProdutos().add(getProduto());
        getProdutoDAO().salvar(getProduto());
        setProduto(new Produto());
    }

    public void listar() throws SQLException {
        produtos = produtoDAO.buscar();
    }

}
