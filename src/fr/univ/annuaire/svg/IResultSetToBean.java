package fr.univ.annuaire.svg;

import java.sql.SQLException;

public interface IResultSetToBean<T> {
	T toBean(java.sql.ResultSet rs) throws SQLException;
}
