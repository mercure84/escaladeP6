package com.escaladeP6.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


@Repository
@Transactional
public class AppRoleDAO extends JdbcDaoSupport {

    @Autowired
    public AppRoleDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public List<String> getRoleNames (int membreId){

        String sql = " Select r.Role_Name " +
                " from User_Role ur, App_Role r "
                +" where ur.role_id = r.role_id and ur.membre_id = ?" ;


        Object[] params = new Object[]{membreId};

        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

        return roles;
    }


}
