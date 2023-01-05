/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author pakutsing
 */
public class MatDetail {

    private String product_id;
    private String product_mat_no;
    private String product_mat_barcode;
    private String product_mat_name_th;
    private String product_color_id;
    private String product_size_id;
    private String product_sale_price;

    public MatDetail() {
        super();
    }

    public MatDetail(String product_id, String product_mat_no, String product_mat_barcode, String product_mat_name_th, String product_color_id, String product_size_id, String product_sale_price) {
        this.product_id = product_id;
        this.product_mat_no = product_mat_no;
        this.product_mat_barcode = product_mat_barcode;
        this.product_mat_name_th = product_mat_name_th;
        this.product_color_id = product_color_id;
        this.product_size_id = product_size_id;
        this.product_sale_price = product_sale_price;
    }

    public String getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(String product_color_id) {
        this.product_color_id = product_color_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_mat_barcode() {
        return product_mat_barcode;
    }

    public void setProduct_mat_barcode(String product_mat_barcode) {
        this.product_mat_barcode = product_mat_barcode;
    }

    public String getProduct_mat_name_th() {
        return product_mat_name_th;
    }

    public void setProduct_mat_name_th(String product_mat_name_th) {
        this.product_mat_name_th = product_mat_name_th;
    }

    public String getProduct_mat_no() {
        return product_mat_no;
    }

    public void setProduct_mat_no(String product_mat_no) {
        this.product_mat_no = product_mat_no;
    }

    public String getProduct_sale_price() {
        return product_sale_price;
    }

    public void setProduct_sale_price(String product_sale_price) {
        this.product_sale_price = product_sale_price;
    }

    public String getProduct_size_id() {
        return product_size_id;
    }

    public void setProduct_size_id(String product_size_id) {
        this.product_size_id = product_size_id;
    }
}
