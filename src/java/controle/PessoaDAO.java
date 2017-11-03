/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectionFactory;
import model.Pessoa;
import model.Fisico;
import model.Juridico;


/**
 *
 * @author cesardias
 */
public class PessoaDAO {
    

    public void salvar (Pessoa pessoa, Fisico fisico, Juridico juridico) throws SQLException{

        String sql = "INSERT INTO `PESSOA` (`nome`, `email`, `DT_NASC`, `SENHA`, `LOGIN`, `CEP`, `RUA`, `ESTADO`, `COMENTARIO`, `CPF`, `QTD_FILHOS`, `QTD_CIGARROS`, `CNPJ`, `SEXO`, `QTD_FILIAIS`, `QTD_FUNCIONARIOS`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conexao = ConnectionFactory.connect();
       
        PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getDt_nasc());
            ps.setString(4, pessoa.getSenha());
            ps.setString(5, pessoa.getLogin());
            ps.setInt(6, pessoa.getCep());
            ps.setString(7, pessoa.getRua());
            ps.setString(8, pessoa.getEstados());
            ps.setString(9, pessoa.getComentario());
            ps.setString(10, fisico.getCPF());
            ps.setInt(11, fisico.getQtd_filhos());
            ps.setInt(12, fisico.getQtd_cigarros());
            ps.setInt(13, juridico.getCnpj());
            ps.setString(14, fisico.getSexo());
            ps.setInt(15, juridico.getQtd_filiais());
            ps.setInt(16, juridico.getQtd_funcionarios());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
    }
    
    public List<Pessoa> buscar(){
        try {
            Connection conexao = ConnectionFactory.connect();
            PreparedStatement ps = conexao.prepareStatement("select * from Pessoa");
            ResultSet resultSet = ps.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            List<Fisico> fisicos = new ArrayList<>();
            List<Juridico> juridicos = new ArrayList<>();
            while(resultSet.next()){
                Pessoa pessoa = new Pessoa();
                Fisico fisico = new Fisico();
                Juridico juridico = new Juridico();
                pessoa.setId(resultSet.getInt("ID"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setDt_nasc(resultSet.getString("DT_NASC"));
                pessoa.setSenha(resultSet.getString("SENHA"));
                pessoa.setLogin(resultSet.getString("LOGIN"));
                pessoa.setCep(resultSet.getInt("CEP"));
                pessoa.setRua(resultSet.getString("RUA"));
                pessoa.setEstados(resultSet.getString("ESTADO"));
                pessoa.setComentario(resultSet.getString("COMENTARIO"));
                fisico.setCPF(resultSet.getString("CPF"));
                fisico.setQtd_filhos(resultSet.getInt("QTD_FILHOS"));
                fisico.setQtd_cigarros(resultSet.getInt("QTD_CIGARROS"));
                juridico.setCnpj(resultSet.getInt("CNPJ"));
                fisico.setSexo(resultSet.getString("SEXO"));
                juridico.setQtd_filiais(resultSet.getInt("QTD_FILIAIS"));
                juridico.setQtd_funcionarios(resultSet.getInt("QTD_FUNCIONARIOS"));
                
                pessoas.add(pessoa);
                fisicos.add(fisico);
                juridicos.add(juridico);
            }
            //resultSet.close();
            return pessoas;
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
