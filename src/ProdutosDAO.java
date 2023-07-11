/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        
        try {
        
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) "
                    + "VALUES(?,?,?)");
            
            prep.setString(1,produto.getNome());
            prep.setInt(2,produto.getValor());
            prep.setString(3,produto.getStatus());
            
            prep.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            
            return false;
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        try {
            conn = new conectaDAO().connectDB();
            listagem = new ArrayList<>();
            prep = conn.prepareStatement("SELECT * from produtos");
            resultset = prep.executeQuery();
            //verificar se a consulta encontrou o funcionário com a matrícula informada
            while (resultset.next()){ // se encontrou o funcionário, vamos carregar os dados
                ProdutosDTO produtosDTO = new ProdutosDTO();
                produtosDTO.setId(resultset.getInt("id"));
                produtosDTO.setNome(resultset.getString("nome"));
                produtosDTO.setValor(resultset.getInt("valor"));
                produtosDTO.setStatus(resultset.getString("status"));
                listagem.add(produtosDTO);
            }
            return listagem;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " - " + ex.getMessage());
            return null;
        }
    }
    
    
    
        
}

