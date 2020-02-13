/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ben
 */
public class ShoppingListServlet extends HttpServlet {

    HttpSession session;  
    String userName;
    String addItem;
    String userAction;
    ArrayList<String> itemList = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        userAction = request.getParameter("userAction");
        
       
        System.out.println(userName);
        request.setAttribute("userName", userName);
        
        if (userAction != null && !userAction.equals("")) {
            if (userAction.equals("register")) {            
                userName =(String) request.getAttribute("userName");
                if (userName != null && !userName.equals("")) {
                   session.setAttribute("userName", request.getParameter("userName"));
                   session.setAttribute("itemList", itemList);
                }
               
            }
            else if (userAction.equals("add")) {
                String itemToAdd = (String) request.getAttribute(addItem);
                if (itemToAdd != null && !itemToAdd.equals("")) {
                    itemList = (ArrayList<String>) session.getAttribute("itemList");
                    itemList.add(itemToAdd);
                    session.setAttribute("itemList", itemList);
                }
            }
            else if (userAction.equals("delete")) {
                String radSelect = request.getParameter("radSelect");
                if (radSelect != null && !radSelect.equals("")) {
                    try {
                        int selected = Integer.parseInt(radSelect);
                    
                    itemList = (ArrayList<String>) session.getAttribute("itemList");
                    if (itemList == null) {
                        itemList = new ArrayList<String>();
                        itemList.remove(selected);
                        session.setAttribute("itemList", itemList);
                    }
                    } catch (Exception e) {
                                                       
                    }
                }
            }
        }
        response.sendRedirect("ShoppingList");
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
