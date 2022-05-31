package service;

import model.Manage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageServiceImpl implements ManageService {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List findAll() {
        List<Manage> manages = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from manage");) {
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String province = rs.getString("province");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                Manage clazz = findById(classId);

                manages.add(new Manage(id, name, age, province, sex, email,clazz)); //thêm đối tượng là danh sách
            }
        } catch (SQLException e) {
        }
        return manages;
    }

    @Override
    public void add(Manage manage) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into manage(id,name,age,email,sex,province) values (?, ?,?,?,?,?)");) {
            preparedStatement.setInt(1, manage.getId());
            preparedStatement.setString(2, manage.getName());
            preparedStatement.setInt(3, manage.getAge());
            preparedStatement.setString(4, manage.getEmail());
            preparedStatement.setString(5, manage.getSex());
            preparedStatement.setString(6, manage.getProvince());
            preparedStatement.setInt(7, manage.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public Manage findById(int id) {
        Manage manage = new Manage();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from manage where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int findId = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String province = rs.getString("province");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                Manage clazz = findById(classId);

                manage = new Manage(findId, name, age, province, sex, email,clazz);
            }
        } catch (SQLException e) {
        }
        return manage;
    }


    @Override
    public boolean update(Manage manage) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from manage where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public List<Manage> findAllByClass(int Id) {
        List<Manage> manages = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from manage where classId = ?");) {
            preparedStatement.setInt(1, Id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String province = rs.getString("province");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                Manage clazz = findById(classId);
                manages.add(new Manage(id, name, age, province, sex, email,clazz));
            }
        } catch (SQLException e) {
        }
        return manages;
    }

    @Override
    public List<Manage> findAllByNameContains(String findName) {
        List<Manage> manages = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from manage where name like ?");) {
            preparedStatement.setString(1, "%" + findName + "%");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String province = rs.getString("province");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                Manage clazz = findById(classId);
                manages.add(new Manage(id, name, age, province, sex, email,clazz));
            }
        } catch (SQLException e) {
        }
        return manages;
    }
}
