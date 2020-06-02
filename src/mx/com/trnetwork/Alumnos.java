package mx.com.trnetwork;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alumnos
 
*/
public class Alumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String folder;
	
	
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		folder=config.getInitParameter("folder");
		super.init(config);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Alumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/menu.jsp").include(request,response);////////////////////////////// checar  para poner menu en la parte inicial de la tabla.
		
		
		File myCsv=new File(folder+"/alumnos.csv");
		FileReader fr = new FileReader(myCsv);
		BufferedReader br = new BufferedReader(fr);   // lee la cadena de bytes
		String linea;                                //hacer la variable donde se guardara cada linea
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		//writer.println("<jsp:include page="+"'menu.jsp'"+"></jsp:include>");
		writer.println("<table>");
		writer.println("<thead>\r\n" + 
				"		\r\n" + 
				"			<tr>\r\n" + 
				"				<td>Matricula</td>\r\n" + 
				"				<td>Nombre</td>\r\n" + 
				"				<td>ApellidoPaterno</td>\r\n" + 
				"				<td>ApellidoMaterno</td>\r\n" + 
				"				<td>Grado</td>\r\n" + 
				"				<td>Grupo</td>\r\n" + 
				"				<td>Carrera</td>\r\n" + 
				"			</tr>\r\n" + 
				"	</thead>"+
				"<tbody>");
		while( (linea=br.readLine()) != null ) {      // lee linea por linea hasta encontrar un  valor nulo
			String[] partesLinea = linea.split(",");  //divide las cadenas donde ya  no encuentre un "," 
			writer.println("<tr>");
			
			for(int j=0;j<partesLinea.length;j++) {
				
				writer.println("<td>"+partesLinea[j]+"</td>");
						//+"<td>"+partesLinea[j]+"</td>"
						//+"<td>"+partesLinea[j]+"</td>"
						
				
				}
			writer.println("</tr>");
			
		}
		writer.println("</tbody></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula=request.getParameter("matricula");
		PrintWriter w = response.getWriter();
		w.print("Tu Matricula es: "+ matricula);
		
		String nombre=request.getParameter("nombre");
		PrintWriter wn = response.getWriter();
		wn.print("\nTu Nombre es: "+ nombre);
		
		String apellidoPaterno=request.getParameter("apellidoPaterno");
		PrintWriter wap = response.getWriter();
		wap.print("\nTu Apellido Paterno es: "+ apellidoPaterno);
		
		String apellidoMaterno=request.getParameter("apellidoMaterno");
		PrintWriter wam = response.getWriter();
		wam.print("\nTu Apellido Materno es: "+ apellidoMaterno);
		
		String grado=request.getParameter("grado");
		PrintWriter wg = response.getWriter();
		wg.print("\nTu Grado es: "+ grado);
		
		String grupo=request.getParameter("grupo");
		PrintWriter wgru = response.getWriter();
		wgru.print("\nTu Grupo es: "+ grupo);
		
		String carrera=request.getParameter("carrera");
		PrintWriter wc = response.getWriter();
		wc.print("\nTu Carrera es: "+ carrera);
		
		//Matricula // Nombre, Apellido Paterno, Apellido Materno, Grado, Grupo, Carrera
		
		FileWriter pw= new FileWriter(folder+"/alumnos.csv", true);
		pw.append(matricula+","+nombre+","+apellidoPaterno+","+apellidoMaterno+","+grado+","+grupo+","+carrera+"\n");
		pw.flush();
		pw.close();
		
		response.sendRedirect(request.getContextPath()+"/alumnos");
	}

}
