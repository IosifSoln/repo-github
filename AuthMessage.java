

package server;

import javax.swing.*;
import java.sql.*;

public class AuthMessage {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static String login;
    private static String password;
    private static String nick;

    private boolean authenticated = false;
    private static final String INSERT_NEW_USER = "INSERT INTO users(login, password,nick) VALUES(?, ?, ?);";
    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String OPEN_SESSION = "UPDATE users set session = 'online' WHERE nick = ?;";
    private static Connection connection;

    public static void connectionToData() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void register(String login, String password, String email, String name, String surname, Date birthday, String group, String status) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nick);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void login(String login, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            setValues(resultSet);
            preparedStatement = connection.prepareStatement(OPEN_SESSION);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setValues(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                login = resultSet.getString("login");
                nick = resultSet.getString("nick");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
