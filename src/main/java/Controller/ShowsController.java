package Controller;

import dao.ShowsDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Show;

@WebServlet("/shows")
public class ShowsController extends HttpServlet {

    private final String LAYAOUT_PATH = "/WEB-INF/layout/index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("id") != null) {
                editPage(request, response);
            } else {
                listPage(request, response);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            redirectToIndexUrl(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String queryParams = request.getParameter("accion");
            if (queryParams != null) {
                switch (queryParams) {
                    case "insertar":
                        insertShowAction(request, response);
                        break;
                    case "modificar":
                        editShowAction(request, response);
                        break;
                    case "eliminar":
                        deleteShowAction(request, response);
                        break;
                }
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            redirectToIndexUrl(request, response);
        }
    }

    private void listPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Show> shows = new ShowsDAO().findAll();
        shows.forEach(System.out::println);

        request.setAttribute("routerView", "shows/listar.jsp");
        request.setAttribute("shows", shows);
        request.setAttribute("totalShows", totalShows(shows));
        request.setAttribute("maximumCollection", maximumCollection(shows));
        request.getRequestDispatcher(LAYAOUT_PATH).forward(request, response);
    }

    private void editPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Show show = new ShowsDAO().findBy(id);
        if (show == null) {
            throw new Exception("No hay resultados");
        }
        request.setAttribute("routerView", "shows/_id.jsp");
        request.setAttribute("show", show);
        request.getRequestDispatcher(LAYAOUT_PATH).forward(request, response);
    }

    private void insertShowAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        String band = request.getParameter("band");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String direction = request.getParameter("direction");
        String observation = request.getParameter("observation");
        String eventDate = request.getParameter("event_date");

        Show show = new Show(band, capacity, price, direction, observation, eventDate);
        int registrosMod = new ShowsDAO().insert(show);

        System.out.println("Registros insertados: " + registrosMod);
    }

    private void editShowAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String band = request.getParameter("band");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        System.out.println("precio: " + request.getParameter("price"));

        double price = Double.parseDouble(request.getParameter("price"));
        String direction = request.getParameter("direction");
        String observation = request.getParameter("observation");
        String eventDate = request.getParameter("event_date");

        int registrosMod = new ShowsDAO().update(id, band, capacity, price, direction, observation, eventDate);

        System.out.println("Registros actualizados: " + registrosMod);
    }

    private void deleteShowAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int registrosMod = new ShowsDAO().delete(id);
        System.out.println("Registros eliminados: " + registrosMod);
    }

    private void redirectToIndexUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * Redireccion 302 a la URL shows http://localhost:8080/{proyecto}/shows
         * para que la URL no queden los queryString
         */
        response.sendRedirect(request.getContextPath() + "/shows");

    }

    private int totalShows(List<Show> shows) {
        int totalShows = 0;
        for (int i = 0; i < shows.size(); i++) {
            totalShows += shows.get(i).getCapacity();
        }
        return totalShows;
    }

    private double maximumCollection(List<Show> shows) {
        double maximumCollection = 0;
        for (int i = 0; i < shows.size(); i++) {
            maximumCollection += shows.get(i).getCapacity() * shows.get(i).getPrice();
        }
        return maximumCollection;
    }
}
