/**
 * 
 */
package fr.eni.zylim.encheres.dal;

import java.sql.SQLException;

import fr.eni.zylim.encheres.bo.Retrait;

/**
 * @author ikram
 *
 */
public interface RetraitDAO {

	public Retrait insert (Retrait retrait) throws SQLException;

	public Retrait selectionnerByNoArticle(int noArticle) throws SQLException;
	}

