package fr.univ.annuaire.svg;

import java.sql.SQLException;

public interface IResultSetToBean<T> {
	
	/**
	 * This interface take a resultSet in param and return a bean who will
	 * be construct with the values contains in resultSet.
	 * @param rs
	 * @return bean type who apply this methode
	 * @throws SQLException
	 */
	T toBean(java.sql.ResultSet rs) throws SQLException;
}
