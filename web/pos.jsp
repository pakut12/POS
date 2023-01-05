<%-- 
    Document   : index
    Created on : 5 ม.ค. 2566, 8:17:03
    Author     : pakutsing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file = "share/header.jsp" %>
    </head>
    <body>
        <%@ include file = "share/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-8">
                    <div class="card mt-5 border-dark " >
                        <div class="card-header bg-dark text-white ">
                            ค้นหาสินค้า
                        </div>
                        <div class="card-body">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-12 col-md-12 mx-auto mt-3">
                                        <div class="row g-6 align-items-center">
                                            <div class="col-4 text-end">
                                                <label for="mat_barcode" class="col-form-label ">ค้นหา</label>
                                            </div>
                                            <div class="col-5">
                                                <input type="text" id="mat_barcode" class="form-control form-control-sm" >
                                            </div>
                                            <div class="col-3">
                                                <button class="btn btn-sm btn-success" id="get_matdetail">+ เพิ่ม</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <div id="table_product" class="mt-5">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-4">
                    <div class="card mt-5 border-dark " >
                        <div class="card-header bg-dark text-white ">
                            ตะกร้าสินค้า
                        </div>
                        <div class="card-body">
                            <div class="container">
                                <div class="table-responsive">
                                    <div class="" style="height: 30vh;">
                                        <table class="table overflow-auto" id="table_sumproduct" >
                                            <thead>
                                                <tr>
                                                    <th scope="col">สินค้า</th>
                                                    <th scope="col">ราคา</th>
                                                    <th scope="col">จำนวน</th>
                                                </tr>
                                            </thead>
                                            <tbody id="">
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                </div>
                                <div class="row mt-3">
                                    <div class="d-flex justify-content-between">
                                        <div class="text-center">
                                            <button class="btn btn-sm btn-success">พิมพ์ใบชำระสินค้า</button>
                                        </div>
                                        <div class="">
                                            ยอดรวม 0 
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
    <footer>
        <%@ include file = "share/footer.jsp" %>
    </footer>
    <script>
        function getproduct(){
            $.ajax({
                type:"post",
                url:"Product",
                data:{
                    type:"searchproduct",
                    barcode:$("#mat_barcode").val()
                },
                success:function(msg){
                    $("#table_product").html(msg);
                    var table = $('#tb_product').DataTable();
                    var prodect = table.rows(0).data()[0][2];
                    var price = table.rows(0).data()[0][5];
                    var html = '<tr><td>'+prodect+'</td><td>'+price+'</td><td>'+prodect+'</td></tr>';
                    $('#table_sumproduct').append(html);
                }
            })
        }
        
        $( document).ready(function() {
            $("#pospage").addClass("active");
            $("#get_matdetail").click(function(){
                getproduct();
            });
        });
    </script>
</html>
