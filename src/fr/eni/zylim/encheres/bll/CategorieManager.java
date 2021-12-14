package fr.eni.zylim.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.zylim.encheres.bo.Categorie;
import fr.eni.zylim.encheres.dal.CategorieDAO;
import fr.eni.zylim.encheres.dal.jdbc.CategorieDAOJdbcImpl;

public class CategorieManager {

	private static CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();
	
	public static Categorie selectionnerCategorieById(int categorieId) throws SQLException {
			return categorieDAO.getById(categorieId);
		}
	
	public static List<Categorie> selectionnerToutesLesCategories() throws SQLException{
		return categorieDAO.getAll();
	}

}
