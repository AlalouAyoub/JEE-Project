package web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import loc.IVoiture;
import loc.VoitureImpl;
import location.reservation;
import location.voiture;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	IVoiture location;
	public void init() throws ServletException{
		location = new VoitureImpl();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
			String path=request.getServletPath();
			List<voiture> voitures = new ArrayList<>();
			List<voiture> voitures1 = new ArrayList<>();
			List<voiture> voitures2= new ArrayList<>();
			List<voiture> voitures3= new ArrayList<>();
			if (path.equals("/index.do"))
			{
				request.getRequestDispatcher("voitures.jsp").forward(request,response);
			}
			else if (path.equals("/chercher.do") || path.equals("/chercher_admin.do"))
			{
				VoitureModele model= new VoitureModele();
				String motCle=request.getParameter("motCle");
				String active=request.getParameter("active");
				String date_m=request.getParameter("date_min");
				String date_f=request.getParameter("date_fin");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				Date date_min=null;
				Date date_fin=null;
				try {
					date_min = format.parse(date_m);
					date_fin = format.parse(date_f);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.setF(motCle);
				model.setA(active);
				model.setDate_min(date_m);
				model.setDate_fin(date_f);
				if (date_fin != null && date_min!=null) {
					if (date_fin.after(date_min)==false) {
						model.setCheck(0);
					}else {
						voitures = location.datedf(date_m.replace('T',' '),date_f.replace('T',' '));
						model.setCheck(1);
						}
				}
				else if (date_fin == null && date_min!=null) {
					model.setCheck(3);
				}
				else {
					model.setCheck(0);
				}
				
				if (motCle.length()>0 && active.length()>0) {
					voitures1 = location.voitureParf(motCle);
					voitures2=location.voiturePara(active);
					if (model.getCheck()==1) {voitures = location.inter(voitures,voitures1);voitures = location.inter(voitures,voitures2);}
					else if (model.getCheck()==2) {voitures = location.inter(voitures2,voitures1);}
				}
				else if (motCle.length() == 0){
					voitures = location.voiturePara(active);
				}
				else if (active.length() == 0){
					voitures = location.voitureParf(motCle);
				}
				model.setVoitures(voitures);
				request.setAttribute("model", model);
				if (path.equals("/chercher.do")) {
					request.getRequestDispatcher("voitures.jsp").forward(request,response);
				}
				else if (path.equals("/chercher_admin.do")) {
					request.getRequestDispatcher("voitures_1.jsp").forward(request,response);
				}
				
			}
			else if (path.equals("/save.do") && request.getMethod().equals("POST"))
			{
				String nom=request.getParameter("nom");
				String active=request.getParameter("active");
				int prix=Integer.parseInt(request.getParameter("prix"));
				String desc=request.getParameter("Description");
				String date_m=request.getParameter("date_min");
				String date_f=request.getParameter("date_fin");
				String image=request.getParameter("CarI");
				voiture v = new voiture(nom,image,desc,prix,active,date_m,date_f);
				v=location.save(v);
				response.sendRedirect("chercher_admin.do?motCle=&active=&date_min=&date_fin=");
			}
			else if (path.equals("/supprimer.do")) {
				int id=Math.round(Float.parseFloat(request.getParameter("id")));
				location.delete(id);
				response.sendRedirect("chercher_admin.do?motCle=&active=&date_min=&date_fin=");
			}
			else if (path.equals("/editer.do")) {
				voiture voitures_id ;
				int id=Math.round(Float.parseFloat(request.getParameter("id")));
				voitures_id=location.voitureParid(id);
				request.setAttribute("voiture", voitures_id);
				request.getRequestDispatcher("editerVoiture.jsp").forward(request,response);
			}
			else if (path.equals("/update.do") ) {
				int id=Math.round(Float.parseFloat(request.getParameter("id")));
				String nom=request.getParameter("nom");
				String active=request.getParameter("active");
				int prix=Integer.parseInt(request.getParameter("prix"));
				String desc=request.getParameter("description");
				String date_m=request.getParameter("date_debut");
				String date_f=request.getParameter("date_fin");
				String image=request.getParameter("CarI");
				location.update(id, nom, image, desc, prix, active, date_m, date_f);
				response.sendRedirect("chercher_admin.do?motCle=&active=&date_min=&date_fin=");
			}
			else if (path.equals("/admin.do") && request.getMethod().equals("POST")) {
				String nom=request.getParameter("nom");
				String mdp=request.getParameter("mdp");
				if (nom.equals("admin") && mdp.equals("admin")) {
					response.sendRedirect("voitures_1.jsp");
					
				}
				else {
					request.setAttribute("a", 1);
					request.getRequestDispatcher("login.jsp").forward(request,response);
				}
			}
			else if (path.equals("/reserver.do")){
				voiture voitures_id ;
				int id=Math.round(Float.parseFloat(request.getParameter("id")));
				voitures_id=location.voitureParid(id);
				request.setAttribute("voiture", voitures_id);
				request.getRequestDispatcher("confirmation.jsp").forward(request,response);
			}
			else if (path.equals("/Confirmation_r.do")){
				int id=Math.round(Float.parseFloat(request.getParameter("ID")));
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				String tel=request.getParameter("tel");
				location.switch_a(id);
				location.save_r(id, nom, prenom, tel);
				request.getRequestDispatcher("voitures.jsp").forward(request,response);
			}
			else if (path.equals("/mes_r.do")){
				List<reservation> mes_r = new ArrayList<reservation>();
				mes_r=location.mes_r();
				System.out.println(mes_r);
				request.setAttribute("reservations", mes_r);
				request.getRequestDispatcher("reservations.jsp").forward(request,response);
			}
			else if (path.equals("/annuler_r.do")) {
				int id=Math.round(Float.parseFloat(request.getParameter("id")));
				location.annuler_r(id);
				location.switch_a_n(id);
				response.sendRedirect("mes_r.do");
			}
			else
			{
			response.sendError(Response.SC_NOT_FOUND);
			}

}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	
}