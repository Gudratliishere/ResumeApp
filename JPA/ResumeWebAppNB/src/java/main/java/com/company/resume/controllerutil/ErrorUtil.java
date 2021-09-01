/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.company.resume.controllerutil;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author x
 */
public class ErrorUtil
{

    public static void sendError(HttpServletResponse resp, Exception ex)
    {
        try
        {
            ex.printStackTrace();
            resp.sendRedirect("error?msg=" + ex.getMessage());
        } catch (IOException ex1)
        {
            ex1.printStackTrace();
        }
    }
}
