package com.brrobotics.ws;

import com.brrobotics.dao.DAOPedido;
import com.brrobotics.modelo.Pedido;
//import javax.jws.WebService;
//import javax.jws.WebParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// @WebService(serviceName = "BrRoboticsService")
@Path("/BrRoboticsService")
public class BrRoboticsService {

	private final DAOPedido dao = DAOPedido.getInstance();

	public BrRoboticsService() {
        System.out.println("Webservice REST da BrRobotics criado");
    }
	
	@POST
    @Path("inserirPedido")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Pedido inserirPedido(Pedido pedido) {

		double totalRoboDomestico = pedido.getQtdRoboDomestico() * 900;
        double totalRoboMedico = pedido.getQtdRoboMedico() * 2500;
        double totalRoboSeguranca = pedido.getQtdRoboSeguranca() * 1800;
        
        if (pedido.getQtdRoboDomestico() > 3) {
        	totalRoboDomestico = 0.75 * totalRoboDomestico;
        }
        if (pedido.getQtdRoboMedico() > 3) {
        	totalRoboMedico = 0.9 * totalRoboMedico;
        } 
        if (pedido.getQtdRoboSeguranca() > 3) {
        	totalRoboSeguranca = 0.85 * totalRoboSeguranca;
        }
        
        pedido.setTotalRoboDomestico(totalRoboDomestico);
        pedido.setTotalRoboMedico(totalRoboMedico);
        pedido.setTotalRoboSeguranca(totalRoboSeguranca);

        pedido.setTotal(0.85 * (totalRoboDomestico + totalRoboMedico + totalRoboSeguranca));

        pedido = dao.insert(pedido);

        System.out.println("[BrRoboticsService] - " + pedido);

        return pedido;
    }
}
