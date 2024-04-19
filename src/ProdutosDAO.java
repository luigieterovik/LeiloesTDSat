import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutosDAO {
    conectaDAO conexao = new conectaDAO();
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException {
        conexao.conectar();
        
        String nome = produto.getNome();
        int valor = produto.getValor();
        String status = produto.getStatus();
        
        Statement stmt = conexao.conn.createStatement();
        String sql;                
        sql = "insert into produtos (nome, valor, status) values ('" + nome + "', '" + valor + "', '" + status + "')";
        stmt.executeUpdate(sql);
        System.out.println("Dados inseridos.");
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        try {
            conexao.conectar();
            
             String sql = "select * from produtos";
            Statement stmt = conexao.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int valor = rs.getInt("valor");
                String status = rs.getString("status");
                
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(id);
                produto.setNome(nome);
                produto.setValor(valor);
                produto.setStatus(status);
                
                listagem.add(produto);
            }
        } catch(SQLException sqle) {
            System.out.println( "Erro ao efetuar consulta: " + sqle.getMessage());
            listagem.clear();
        }
            
        return listagem;
    }    
}

