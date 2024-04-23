import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

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
    
    public void venderProduto(Integer id) throws SQLException {
        conexao.conectar();
        
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
        
        pstmt.setString(1, "Vendido");
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        
        System.out.println("Produto vendido.");
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();
        
         try {
            conexao.conectar();
            
            String sql = "SELECT * FROM produtos WHERE status = ?";
            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            
            pstmt.setString(1, "Vendido");
            ResultSet rs = pstmt.executeQuery();
            
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
                
                System.out.println(produto.getId());
                System.out.println(produto.getNome());
                System.out.println(produto.getValor());
                System.out.println(produto.getStatus());
                
                System.out.println("\n_________________________\n");
                
                produtosVendidos.add(produto);
            }
        } catch(SQLException sqle) {
            System.out.println( "Erro ao efetuar consulta: " + sqle.getMessage());
            produtosVendidos.clear();
        }
         
        return produtosVendidos;
    }
}

