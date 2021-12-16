package fr.eni.zylim.encheres.dal.jdbc;

import fr.eni.zylim.encheres.dal.RetraitDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String INSERT = "insert into RETRAITS (no_article, rue, code_postal, ville) values (?,?,?,?)";
	private static final String SELECT_RETRAIT_BY_NO_ARTICLE =  "SELECT * FROM RETRAITS    WHERE no_article = ?";
	
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

	@Override
	public Retrait selectionnerByNoArticle(int noArticle) throws SQLException, DALException {
		Retrait retrait = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(SELECT_RETRAIT_BY_NO_ARTICLE);
			pStmt.setInt(1, noArticle);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				retrait = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		return retrait;
	}
	
	public Retrait map(ResultSet tableResulante) throws SQLException {
		Retrait retrait = null;
		int no_article = tableResulante.getInt("no_article");
		String rue = tableResulante.getString("rue");
		String CodePostal = tableResulante.getString("code_postal");
		String Ville = tableResulante.getString("ville");
		retrait = new Retrait(no_article, rue, CodePostal, Ville);
		return retrait;
	}
	}


