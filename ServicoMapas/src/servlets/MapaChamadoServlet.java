package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapaChamadoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		double lat = -8.0372619;
		double lng = -34.8713684;
		int zoom = 13;
		
		boolean showMarker = false;
		
		if (req.getParameter("lat") != null && req.getParameter("lng") != null) {
			try {
				lat = Double.parseDouble(req.getParameter("lat"));
				lng = Double.parseDouble(req.getParameter("lng"));
				
				zoom = 17;
				showMarker = true;
			} finally{}
		}
		
		resp.getWriter().write("<!DOCTYPE html>");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<script src=\"http://maps.googleapis.com/maps/api/js\"></script>");
		resp.getWriter().write("<script>");
		resp.getWriter().write("function initialize() {");
		resp.getWriter().write("var mapProp = {");
		resp.getWriter().write("center:new google.maps.LatLng(" + lat + "," + lng + "),");
		resp.getWriter().write("zoom:"+ zoom + ",");
		resp.getWriter().write("mapTypeId:google.maps.MapTypeId.ROADMAP");  
		resp.getWriter().write("};");
		resp.getWriter().write("var map=new google.maps.Map(document.getElementById(\"googleMap\"), mapProp);");
		
		if (showMarker) {
			resp.getWriter().write("new google.maps.Marker({");
			resp.getWriter().write("position: new google.maps.LatLng(" + lat + "," + lng + "),");
			resp.getWriter().write("map: map,");      
			resp.getWriter().write("title: \"Local do Chamado\"");      
			resp.getWriter().write("});");      
		}
		
		resp.getWriter().write("}");    
		resp.getWriter().write("google.maps.event.addDomListener(window, 'load', initialize);");  
		resp.getWriter().write("</script>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<div id=\"googleMap\" style=\"width:500px;height:380px;\"></div>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
	}
}
