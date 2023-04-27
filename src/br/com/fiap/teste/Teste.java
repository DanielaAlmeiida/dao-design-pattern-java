package br.com.fiap.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.OracleUsuarioDAO;
import br.com.fiap.model.Usuario;

public class Teste {

	public static void main(String[] args) throws SQLException {

		OracleUsuarioDAO dao = new OracleUsuarioDAO();
		 
		//1) INSERT
		Usuario jose = new Usuario();
		jose.setId(1);
		jose.setNome("José");
		jose.setEmail("jose@gmail.com");
		jose.setSenha("jose123");
		jose.setTelefone("11912123434");
		dao.insert(jose);
		
		Usuario iara = new Usuario();
		iara.setId(2);
		iara.setNome("Iara");
		iara.setEmail("iara@gmail.com");
		iara.setSenha("iara123");
		iara.setTelefone("11937373737");
		dao.insert(iara);
		
		Usuario zac = new Usuario();
		zac.setId(3);
		zac.setNome("Zac");
		zac.setEmail("zac@gmail.com");
		zac.setSenha("zac123");
		zac.setTelefone("11932323232"); 
		dao.insert(zac);
	
		
		//2) SELECT *
		List<Usuario> usuarios = dao.select();	

		for(Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		} 
		
		//2.2) SELECT where
		System.out.println("Select where: " + dao.selectById(3));
		
		//3) DELETE
		dao.delete(1);
		
		//4) UPDATE
		zac.setId(4);
		zac.setNome("Zaque");
		zac.setEmail("zac@gmail.com");
		zac.setSenha("zac123");
		zac.setTelefone("11932323232");
		dao.update(zac);  
		
	}	
}
