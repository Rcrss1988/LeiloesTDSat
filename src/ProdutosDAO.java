/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();

        if (conn != null) {
            try {
                String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
                prep = conn.prepareStatement(sql);
                prep.setString(1, produto.getNome());
                prep.setInt(2, produto.getValor());
                prep.setString(3, produto.getStatus());

                int rowsAffected = prep.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar o produto.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto: " + ex.getMessage());
            } finally {
                // Certifique-se de fechar a conexão e os recursos associados.
                if (prep != null) {
                    try {
                        prep.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao fechar a declaração preparada: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados.");
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        conn = new conectaDAO().connectDB();

        if (conn != null) {
            try {
                String sql = "SELECT id, nome, valor, status FROM produtos";
                prep = conn.prepareStatement(sql);
                resultset = prep.executeQuery();

                while (resultset.next()) {
                    int id = resultset.getInt("id");
                    String nome = resultset.getString("nome");
                    int valor = resultset.getInt("valor");
                    String status = resultset.getString("status");

                    ProdutosDTO produto = new ProdutosDTO();
                    produto.setId(id);
                    produto.setNome(nome);
                    produto.setValor(valor);
                    produto.setStatus(status);

                    listagem.add(produto);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar os produtos: " + ex.getMessage());
            } finally {
                // Certifique-se de fechar a conexão e os recursos associados.
                if (resultset != null) {
                    try {
                        resultset.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao fechar o resultado: " + ex.getMessage());
                    }
                }
                if (prep != null) {
                    try {
                        prep.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao fechar a declaração preparada: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados.");
        }

        return listagem;
    }

}
