/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.MatDetail;
import Utility.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pakutsing
 */
public class ProductService {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static int getlastprimarykey() {
        int lastprimarykey = 0;
        try {
            String sql = "SELECT MAX(product_id) as lastprimary FROM `tb_product`";
            conn = ConnectionDB.GetConnectionDBMysql();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lastprimarykey = rs.getInt("lastprimary");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                ConnectionDB.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lastprimarykey;
    }

    public static List<MatDetail> ProductSearch(String barcode) {
        List<MatDetail> list = new ArrayList<MatDetail>();
        try {
            conn = ConnectionDB.GetConnectionDBMysql();
            ps = conn.prepareStatement("SELECT * FROM `tb_product` WHERE product_mat_barcode = ?");
            ps.setString(1, barcode);
            rs = ps.executeQuery();
            int a = 0;
            while (rs.next()) {
                MatDetail item = new MatDetail();
                item.setProduct_mat_no(rs.getString("product_mat_no"));
                item.setProduct_mat_barcode(rs.getString("product_mat_barcode"));
                item.setProduct_mat_name_th(rs.getString("product_mat_name_th"));
                item.setProduct_color_id(rs.getString("product_color_id"));
                item.setProduct_size_id(rs.getString("product_size_id"));
                item.setProduct_sale_price(rs.getString("product_sale_price"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                ConnectionDB.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
