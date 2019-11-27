package com.brrobotics.ws;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BrRoboticsServiceExceptionMapper implements 
ExceptionMapper<Throwable> {

	@Override
    public Response toResponse(Throwable e) {

        String msg = e.getMessage() != null ? e.getMessage() : "ERRO PROCESSANDO A REQUISICAO";

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR) //
                .entity("{\"erro:\":\"" + msg + "\"}").type("application/json;charset=UTF-8") //
                .build();
    }
}
