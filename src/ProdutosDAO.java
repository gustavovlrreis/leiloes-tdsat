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


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        
        try {
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
        
        return listagem;
    }
    
    
    
        
}

