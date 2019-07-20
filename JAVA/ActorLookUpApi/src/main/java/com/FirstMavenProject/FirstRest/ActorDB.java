package com.FirstMavenProject.FirstRest;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class ActorDB {

	private ArrayList<Actor> actors;
	private Connection connection = null;

	public ActorDB(){
		
		actors = new ArrayList<>();
		System.out.println("actorst Created....");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "yash1234");
			Statement prepatedStatement = connection.createStatement();
			ResultSet resultSet = prepatedStatement.executeQuery("select * from sakila.actor");

			while (resultSet.next()) {

				actor a = new Actor();
				a.setActorID(resultSet.getInt(1));
				a.setFirstName(resultSet.getString(2));
				a.setLastName(resultSet.getString(3));

				actors.add(a);

			}

			System.out.println("actorst loaded.....");
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public ArrayList<Actor> getActors() {

		return actors;

	}

	public actor getActor(int id) {

		System.out.println("inside actor.getActor method");
		for (actor a : actors) {

			if (a.getActorID() == id)
				return a;

		}
		return null;
	}

	public void addActor(actor a) {

		try {

			PreparedStatement prepatedStatement = connection.prepareStatement("insert into sakila.actor values (?,?,?)");
			prepatedStatement.setInt(1, a.getActorID());
			prepatedStatement.setString(2, a.getFirstName());
			prepatedStatement.setString(3, a.getLastName());
			prepatedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateActor(actor a) {

		try {
			PreparedStatement prepatedStatement = connection
					.prepareStatement("update  sakila.actor set first_name=?,last_name=? where actor_id=?");
			prepatedStatement.setString(1, a.getFirstName());
			prepatedStatement.setString(2, a.getLastName());
			prepatedStatement.setInt(3, a.getActorID());
			prepatedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("e");
		}

	}
}
