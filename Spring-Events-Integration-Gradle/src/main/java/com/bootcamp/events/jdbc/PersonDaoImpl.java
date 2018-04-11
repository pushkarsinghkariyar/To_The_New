package com.bootcamp.events.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;


/**
 * Created by nidhi on 28/3/17.
 */
public class PersonDaoImpl implements PersonDao {

    private DataSource dataSource;

    private SimpleJdbcInsert jdbcTemplate;
    //private NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new SimpleJdbcInsert(dataSource).withTableName("Persons");
        //jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(Person p) {
        String sql = "INSERT INTO Persons " +
                "(id, name, surname) VALUES (:pid, :firstName, :surName)";

//    Map<String,Object> paramMap=new HashMap<String,Object>();
//    paramMap.put("id",p.getPid());
//    paramMap.put("name",p.getFirstName());
//    paramMap.put("surname",p.getSurName());

//    MapSqlParameterSource source=new MapSqlParameterSource();
//    source.
//    source.addValue("pid",p.getPid())
//        .addValue("firstName",p.getFirstName())
//        .addValue("surName",p.getSurName());


        //jdbcTemplate.execute(new BeanPropertySqlParameterSource(p));
        //jdbcTemplate.execute(source);
        //jdbcTemplate.update(sql,new BeanPropertySqlParameterSource(p));
        //jdbcTemplate.queryForList("select * from Persons");


    }

    @Override
    public Person getAllPersons() {
        return null;
    }
}