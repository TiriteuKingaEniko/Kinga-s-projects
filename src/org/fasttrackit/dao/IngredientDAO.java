package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBhelpers;

import org.fasttrackit.pojo.Ingredient;

public class IngredientDAO {

	// delete ingredient

	public void deleteIngredient(Ingredient ingredient) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		String deleteIngredient = "delete from ingredient  where id=?";
		PreparedStatement ps = con.prepareStatement(deleteIngredient);
		ps.setInt(1, ingredient.getId());
		ps.executeUpdate();
		helper.closeConnection(con);
	}

	// update ingredient
	public void updateIngredient(Ingredient ingredient) throws SQLException {

		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String updateIngredient = "update ingredient set name=? , unit=? where id=?";
		PreparedStatement ps = con.prepareStatement(updateIngredient);

		ps.setString(1, ingredient.getName());
		ps.setString(2, ingredient.getUnit());

		ps.setInt(3, ingredient.getId());

		ps.executeUpdate();
		helper.closeConnection(con);
	}

	// returneaza ingredient dupa ingredient id

	public Ingredient findIngredientById(int id) throws SQLException {
		Ingredient i = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from ingredient where id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			String name = rs.getString("name");
			String unit = rs.getString("unit");

			i = new Ingredient(id, name, unit);

		}
		helper.closeConnection(con);
		return i;
	}

	// creeaza o lista cu numele ingredienteleor
	public ArrayList<Ingredient> getIngredientList() throws SQLException {
		ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from ingredient order by name";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String unit = rs.getString("unit");

			Ingredient i = new Ingredient(id, name, unit);
			IngredientList.add(i);
		}

		helper.closeConnection(con);
		return IngredientList;

	}

	// afisare lista de ingrediente

	public ArrayList<Ingredient> getIngredients() throws SQLException {
		ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from ingredient order by name";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String unit = rs.getString("unit");

			Ingredient i = new Ingredient(id, name, unit);
			IngredientList.add(i);
		}

		helper.closeConnection(con);
		return IngredientList;

	}

	// adauga ingredient nou - verificare sa nu fie duplicat(sa mai fie ingredient
	// cu aceasi nume), altfel nu adauga inca odata
	public void addIngredient(Ingredient ingredient) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		if (checkIngredient(ingredient)) {
			String insertIngredient = "insert into ingredient (name, unit)" + "values(?,?)";
			PreparedStatement ps = con.prepareStatement(insertIngredient);

			ps.setString(1, ingredient.getName());
			ps.setString(2, ingredient.getUnit());

			ps.executeUpdate();
		}

		helper.closeConnection(con);

	}

//verifica sa nu mai fie ingredient cu aceasi nume si unitate de masura

	public boolean checkIngredient(Ingredient ingredient) throws SQLException {
		boolean check = true;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		String sqlString = "select * from ingredient where name=? and unit=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, ingredient.getName());
		stmt.setString(2, ingredient.getUnit());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			check = false;
		}
		helper.closeConnection(con);
		return check;
	}

//returneaza ingredient dupa nume

	public Ingredient findIngredient(String name) throws SQLException {
		Ingredient i = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from ingredient where name=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			int id = rs.getInt("id");
			String unit = rs.getString("unit");

			i = new Ingredient(id, name, unit);

		}
		helper.closeConnection(con);
		return i;
	}

//sterge ingredient dupa nume
	public void deleteIngredient(String name) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String deleteIngredient = "delete from ingredient where name=?";
		PreparedStatement ps = con.prepareStatement(deleteIngredient);
		ps.setString(1, name);

		ps.executeUpdate();
		helper.closeConnection(con);
	}

}
