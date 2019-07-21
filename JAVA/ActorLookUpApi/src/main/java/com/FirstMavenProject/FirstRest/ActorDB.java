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
			Statement prepatedStatement = (Statement) connection.createStatement();
			ResultSet resultSet = prepatedStatement.executeQuery("select * from sakila.actor");

			while (resultSet.next()) {

				Actor actor = new Actor();
				actor.setActorID(resultSet.getInt(1));
				actor.setFirstName(resultSet.getString(2));
				actor.setLastName(resultSet.getString(3));

				actors.add(actor);

			}

			System.out.println("actorst loaded.....");
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public ArrayList<Actor> getActors() {

		return actors;

	}

	public Actor getActor(int id) {

		System.out.println("inside actor.getActor method");
		for (Actor actor : actors) {

			if (actor.getActorID() == id)
				return actor;

		}
		return null;
	}

	public void addActor(Actor actor) {

		try {

			PreparedStatement prepatedStatement = connection.prepareStatement("insert into sakila.actor values (?,?,?)");
			prepatedStatement.setInt(1, actor.getActorID());
			prepatedStatement.setString(2, actor.getFirstName());
			prepatedStatement.setString(3, actor.getLastName());
			prepatedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateActor(Actor actor) {

		try {
			PreparedStatement prepatedStatement = connection
					.prepareStatement("update  sakila.actor set first_name=?,last_name=? where actor_id=?");
			prepatedStatement.setString(1, actor.getFirstName());
			prepatedStatement.setString(2, actor.getLastName());
			prepatedStatement.setInt(3, actor.getActorID());
			prepatedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("e");
		}

	}
}
