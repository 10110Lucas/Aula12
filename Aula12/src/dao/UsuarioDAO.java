package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;
import criptoAES.CryptoAES;

public class UsuarioDAO {
	
	public void novoUsuario(Usuario usuario) throws Exception{
		String sMsgClara = usuario.getSenha();
		String sMsgDecifrada = null;
	      byte[] bMsgClara = null;
	      byte[] bMsgCifrada = null;
	      byte[] bMsgDecifrada = null;
		
	    bMsgClara = sMsgClara.getBytes("ISO-8859-1");

	    // Instancia um objeto da classe CryptoAES
	    CryptoAES caes = new CryptoAES();
	    // Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
	    caes.geraChave(new File("chave.simetrica"));
	    // Gera a cifra AES da mensagem dada, com a chave simetrica dada
	    caes.geraCifra(bMsgClara, new File("chave.simetrica"));
	    // Recebe o texto cifrado
	    bMsgCifrada = caes.getTextoCifrado();
	    // Converte o texto byte[] no equivalente String
	    String sMsgCifrada = null;
	    sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));
	    System.out.println("\nTeste: "+sMsgCifrada);
	    usuario.setSenha(sMsgCifrada);
	    
		String sql = "INSERT INTO usuario (nome, senha) VALUES ( ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					System.out.println("--- Classe UsuarioDAO, usuario criado !---");
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		caes.geraDecifra(bMsgCifrada, new File("chave.simetrica"));
		   // recebe o texto decifrado
		      bMsgDecifrada = caes.getTextoDecifrado();
		   // Converte o texto byte[] no equivalente String
		      sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
		      System.out.println("Decifrando Senha: "+sMsgDecifrada);
	}
	
	public boolean validar(Usuario usuario) {
		String sql = "SELECT nome, senha FROM usuario WHERE nome = ? and senha = ?";
		try{
			Connection conn = ConnectionFactory.obtemConexao();
			try(PreparedStatement ps = conn.prepareStatement(sql);){
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getSenha());
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}catch(SQLException e2) {
				System.out.print(e2.getStackTrace());
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
