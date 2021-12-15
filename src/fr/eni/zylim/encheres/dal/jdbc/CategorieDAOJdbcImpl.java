package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.zylim.encheres.bo.Categorie;
import fr.eni.zylim.encheres.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO{

	private static final String GET_ALL = "select * from CATEGORIES";
	private static final String GET_BY_ID = "select * from CATEGORIES where no_categorie=?";
	
			
	@Override
	public Categorie getById(int categerieId) throws SQLException {
		Categorie categorie = null;

		Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement statement = cnx.prepareStatement(GET_BY_ID);
			statement.setInt(1, categerieId);

			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				categorie= new Categorie();
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}		
		return categorie;
		}

	@Override
	public List<Categorie> getAll() throws SQLException {
		List<Categorie> categories = new ArrayList<Categorie>();

		Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement statement = cnx.prepareStatement(GET_ALL);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				categories.add(categorie);
			}
			return categories;
	}
}



