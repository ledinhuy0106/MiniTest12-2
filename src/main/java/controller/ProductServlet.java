package controller;

import model.Product;
import service.IProductDAO;
import service.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "orderByQuantity":
                showListOrderByName(request,response);
                break;
                case "edit":
                showEditForm(request,response);
                break;
                case "delete":
                delete(request,response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("product/pEdit.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showListOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/pList.jsp");
        List<Product> products = productDAO.sortByQuantity();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/pCreate.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/pList.jsp");
        List<Product> products = new ArrayList<>();
        if(name==null){
            products = productDAO.findAll();
        }
        else {
            products =productDAO.findByName(name);
        }
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    saveProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                editProduct(request,response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product=new Product(id,name,price,quantity);
        productDAO.edit(id,product);
        response.sendRedirect("/products");
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        productDAO.add(new Product(id , name , price,quantity));
        response.sendRedirect("/products");
    }
}
