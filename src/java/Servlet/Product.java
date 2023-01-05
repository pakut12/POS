/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.MatDetail;
import java.io.*;
import java.net.*;
import Service.ProductService;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author pakutsing
 */
public class Product extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String type = request.getParameter("type").trim();
            if (type.equals("searchproduct")) {
                String barcode = request.getParameter("barcode").trim();
                List<MatDetail> list = ProductService.ProductSearch(barcode);
                String html = "";
                html += "<table class='table' id='tb_product'>";
                html += "<thead>";
                html += "<tr>";
                html += "<th >รหัสสินค้า</th>";
                html += "<th >บาร์โค้ดสินค้า</th>";
                html += "<th >รายละเอียดสินค้า</th>";
                html += "<th >สี</th>";
                html += "<th >ไซร์</th>";
                html += "<th >ราคา</th>";
                html += "</tr>";
                html += "</thead>";
                html += "<tbody>";
                html += "<tr>";
                html += "<td>" + list.get(0).getProduct_mat_no() + "</td>";
                html += "<td>" + list.get(0).getProduct_mat_barcode() + "</td>";
                html += "<td>" + list.get(0).getProduct_mat_name_th() + "</td>";
                html += "<td>" + list.get(0).getProduct_color_id() + "</td>";
                html += "<td>" + list.get(0).getProduct_size_id() + "</td>";
                html += "<td>" + list.get(0).getProduct_sale_price() + "</td>";
                html += "</tr>";
                html += "</tbody>";
                html += "</table>";
               
                out.print(html);
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
