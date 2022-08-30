package control;

import model.BeanProducts;
import model.DaoProducts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts",
        urlPatterns = {
                "/list-products", //get
                "/save-products", //post
                "/save-name", //post
                "/update-status", //post
                "/delete-product", //post
                "/update-name",
                "/see-product",
                "/reset" //post


        }
)
public class ServletProducts extends HttpServlet {
    int iteams = 0 ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String option = request.getServletPath();
        DaoProducts products = new DaoProducts();

        switch (option) {
            case "/list-products":

                List<BeanProducts> listProducts = products.listProducts();
                iteams = listProducts.size();
                request.setAttribute("list", listProducts);
                double selling = products.selling();
                double canceled = products.totalCanceled();
                float neto = (float) (selling-canceled);


                request.setAttribute("selling", selling);
                request.setAttribute("canceled", canceled);
                request.setAttribute("neto",neto);
                request.getRequestDispatcher("/WEB-INF/view/list-products.jsp").forward(request, response);


                break;
            case "/see-product":
                String idString1 = request.getParameter("id") != null ? request.getParameter("id") : "0";
                BeanProducts beanProducts = products.seeProduct(Integer.parseInt(idString1));
                request.setAttribute("product", beanProducts);
                request.getRequestDispatcher("/WEB-INF/view/updateNameProduct.jsp").forward(request, response);
                break;


            default:
                System.out.println("ñaaaaaaaaaa");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String option = request.getServletPath();
        DaoProducts products = new DaoProducts();


        switch (option) {
            case "/save-products":

                try {

                    String id_productsString = request.getParameter("id_products") != null ? (request.getParameter("id_products")) : "0";
                    String priceString = request.getParameter("price")!= null ?(request.getParameter("price")) : "0";
                    double price = Double.parseDouble(priceString);

                    BeanProducts products1 = new BeanProducts();
                    products1.setId_products(Integer.parseInt(id_productsString));
                    products1.setPrice(price);

                    boolean result = products.saveProducts(products1);
                    response.sendRedirect("list-products?result-save=" + (result ? "ok" : "error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-products");
                }
                break;

            case "/update-status":

                String idString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                BeanProducts products1 = new BeanProducts();
                products1.setId_products(Integer.parseInt(idString));
                products1.setStatus(0);

                boolean result = products.disabledStatus(products1);
                response.sendRedirect("list-products?result-update=" + (result ? "ok" : "error"));
                break;

            case "/reset":
                boolean result1 = false;
                for (int i = 1; i <= iteams; i++) {
                     result1 = products.reset(i);

                }

                response.sendRedirect("list-products?result-delete=" + (result1 ? "ok" : "error"));
                break;

            case "/save-name":
                String name = request.getParameter("name")!= null ?(request.getParameter("name")) : "";

                boolean result2 = products.saveProduct(name);
                response.sendRedirect("list-products?result-save=" + (result2 ? "ok" : "error"));
                break;

            case "/delete-product":
                String id = request.getParameter("id")!= null ?(request.getParameter("id")) : "0";
                boolean result3 = products.deleteProduct(Integer.parseInt(id));
                response.sendRedirect("list-products?result-deleteProduct=" + (result3 ? "ok" : "error"));
                break;

            case "/update-name":
                String name1 = request.getParameter("name")!= null ?(request.getParameter("name")) : "";
                String idString1 = request.getParameter("id") != null ? request.getParameter("id") : "0";
                BeanProducts products2 = new BeanProducts();

                products2.setId_products(Integer.parseInt(idString1));
                products2.setName(name1);

                boolean result4 = products.disabledStatus(products2);
                response.sendRedirect("list-products?result-update=" + (result4 ? "ok" : "error"));
                break;


            default:
                System.out.println("ña post");

        }

    }
}
