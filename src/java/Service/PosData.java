/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.MatDetail;
import Utility.ConnectionDB;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;

/**
 *
 * @author pakutsing
 */
public class PosData {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Boolean AddMat(List<MatDetail> listmat) {
        String sql = generatorsqladdmat(listmat);
        Boolean status = true;
        try {
            conn = ConnectionDB.GetConnectionDBMysql();
            ps = conn.prepareStatement(sql);
            if (ps.executeUpdate() > 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnectionDB.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public static String Getdatetoday() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String stringDate = DateFor.format(date);
        return stringDate;
    }

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

    private static String generatorsqladdmat(List<MatDetail> listmat) {
        String sql = "INSERT INTO `tb_product` (`product_id`, `product_mat_no`, `product_mat_barcode`, `product_mat_name_th`, `product_color_id`, `product_size_id`, `product_sale_price`, `date_create`) VALUES ";
        int primarykey = getlastprimarykey();
        for (int n = 0; n < listmat.size(); n++) {
            if (listmat.size() != n + 1) {
                sql += "('" + (primarykey + n + 1) + "', '" + listmat.get(n).getProduct_mat_no() + "', '" + listmat.get(n).getProduct_mat_barcode() + "', '" + listmat.get(n).getProduct_mat_name_th() + "', '" + listmat.get(n).getProduct_color_id() + "', '" + listmat.get(n).getProduct_size_id() + "', '" + listmat.get(n).getProduct_sale_price() + "', '" + Getdatetoday() + "'),";
            } else {
                sql += "('" + (primarykey + n + 1) + "', '" + listmat.get(n).getProduct_mat_no() + "', '" + listmat.get(n).getProduct_mat_barcode() + "', '" + listmat.get(n).getProduct_mat_name_th() + "', '" + listmat.get(n).getProduct_color_id() + "', '" + listmat.get(n).getProduct_size_id() + "', '" + listmat.get(n).getProduct_sale_price() + "', '" + Getdatetoday() + "')";
            }
        }

        return sql;
    }

    public static List<MatDetail> GetMatFromOraclea() {
        List<MatDetail> list = new ArrayList<MatDetail>();
        try {
            conn = ConnectionDB.getConnectionPGCA();
            ps = conn.prepareStatement("SELECT MAT_NO,MAT_BARCODE,MAT_NAME_TH,COLOR_ID,SIZE_ID,SALE_PRICE FROM BM_PRODUCT_CLASS WHERE PRODUCT_GROUP_ID IN ('4TM26S3567','4TM26S3569','4TW26S3568','4TW26S3570') AND MAT_BARCODE IS NOT NULL");
            rs = ps.executeQuery();
            int a = 0;
            while (rs.next()) {
                MatDetail item = new MatDetail();
                item.setProduct_mat_no(rs.getString("MAT_NO"));
                item.setProduct_mat_barcode(rs.getString("MAT_BARCODE"));
                item.setProduct_mat_name_th(rs.getString("MAT_NAME_TH"));
                item.setProduct_color_id(rs.getString("COLOR_ID"));
                item.setProduct_size_id(rs.getString("SIZE_ID"));
                item.setProduct_sale_price(rs.getString("SALE_PRICE"));
                list.add(item);


            /* debag
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("No : " + a);
            System.out.println(rs.getString("MAT_NO"));
            System.out.println(rs.getString("MAT_BARCODE"));
            System.out.println(rs.getString("MAT_NAME_TH"));
            System.out.println(rs.getString("COLOR_ID"));
            System.out.println(rs.getString("SIZE_ID"));
            System.out.println(rs.getString("SALE_PRICE"));
            System.out.println("------------------------------------------------------------------------------------------------------------");
            a++;
             */


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
