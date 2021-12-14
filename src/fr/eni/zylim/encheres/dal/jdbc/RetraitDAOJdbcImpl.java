package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String INSERT = "insert into RETRAITS (rue, code_postal, ville) values (?,?,?)";
	
	@Override
	public Retrait insert(Retrait retrait) throws SQLException {
	
	Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement statement = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, retrait.getNo_article());
			statement.setString(2, retrait.getRue());
			statement.setString(3, retrait.getCode_postal());
			statement.setString(4, retrait.getVille());
			
			
			statement.executeUpdate();
			
			
		return retrait;
	}

}
