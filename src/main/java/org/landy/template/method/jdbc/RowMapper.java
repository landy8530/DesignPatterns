package org.landy.template.method.jdbc;

import java.sql.ResultSet;

/**
 * Created by Tom on 2018/3/11.
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;

}
