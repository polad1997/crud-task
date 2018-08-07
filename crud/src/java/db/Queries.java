/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author hp
 */
public class Queries {

    static final String INSERT = "insert into developers (Dev_ID , Name , Surname , Email) values ('?' , '?' , '?' , '?')";
    static final String UPDATE = "update developers set Name = ? , Surname = ? , Email=? where Dev_ID= ? ;";
    static final String DELETE = "delete from developers where Dev_ID=?";
    static final String SELECT = "select * from developers;";
}
