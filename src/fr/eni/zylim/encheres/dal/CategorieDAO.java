package fr.eni.zylim.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.zylim.encheres.bo.Categorie;

public interface CategorieDAO {

	public Categorie getById(int categerieId) throws SQLException;
	public List<Categorie> getAll() throws SQLException;
}
