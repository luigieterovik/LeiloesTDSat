import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutosDAO {
    conectaDAO conexao = new conectaDAO();
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conexao.conectar();
        
        String nome = produto.getNome();
        int valor = produto.getValor();
        String status = produto.getStatus();
        
          try {
                Statement stmt = conexao.conn.createStatement();
                String sql;
                sql = "insert into produtos (nome, valor, status) values ('" + nome + "', '" + valor + "', '" + status + "')";
                stmt.executeUpdate(sql);
                System.out.println("Dados inseridos.");
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }    
}

