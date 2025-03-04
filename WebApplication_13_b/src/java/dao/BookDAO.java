/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ultis.DBUtils;

/**
 *
 * @author tungi
 */
public class BookDAO implements IDAO<BookDTO, String> {

    @Override
    public boolean create(BookDTO entity) {
        String sql = "INSERT INTO tblBooks"
                + " (BookID,Title,Author,PublishYear,Price,Quantity) "
                + "  VALUES(?, ?, ?, ? ,? , ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getBookId());
            ps.setString(2, entity.getTitle());
            ps.setString(3, entity.getAuthor());
            ps.setInt(4, entity.getPublishYear());
            ps.setDouble(5, entity.getPrice());
            ps.setInt(6, entity.getQuantity());
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public List<BookDTO> readAll() {
        return null;
    }

    @Override
    public BookDTO readbyID(String id) {
        return null;
    }

    @Override
    public boolean update(BookDTO entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<BookDTO> search(String searchTerm) {
        return null;
    }

    public List<BookDTO> searchByTitle(String searchTerm) {
        List<BookDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM tblBooks WHERE title LIKE ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookDTO b = new BookDTO(
                        rs.getString("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("PublishYear"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity")
                );
                result.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public List<BookDTO> searchByTitle2(String searchTerm) {
        List<BookDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM tblBooks WHERE title LIKE ? AND quantity>0";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookDTO b = new BookDTO(
                        rs.getString("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("PublishYear"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity")
                );
                result.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public boolean updateQuantityToZero(String str_bookid) {
        String sql = "UPDATE tblBooks SET Quantity=0 WHERE BookID=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, str_bookid);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}