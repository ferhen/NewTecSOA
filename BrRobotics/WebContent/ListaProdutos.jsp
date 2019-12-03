<%-- 
    Document   : ListaPizzas
    Created on : 18/07/2013, 12:17:48
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.brrobotics.modelo.Robo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb BrRobotics - Menu</title>
    </head>
    <body style="width: 750px">

        <jsp:include page="cabecalho.jspf"/>
        
        
        
        <h1>BR Robotics - Venda de robôs</h1>
        <div>
            <p>Bem vindo à BR Robotics!<br>
                Escolha um dos nosso produtos abaixo.<br>


            </p>

        </div>
        <h3 align="center">Nossos Robôs !!!</h3>
        <jsp:useBean id= "CardapioBean" class= "com.brrobotics.modelo.Cardapio" scope="session"/>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Ação</th>
            </tr>
            <c:forEach var="produto" items= "${CardapioBean.cardapio}" >
                <tr>
                    <td><c:out value= "${produto.codigo}" /></td>
                    <td>
                        <c:if test="${produto.codigo == 1}"> <img src="images/domestic.jpg" width="60" height="60" alt="domestico"/> 
                        </c:if>
                        <c:if test="${produto.codigo == 2}"> <img src="images/medic.jpg" width="60" height="60" alt="medico"/>
                        </c:if>
                        <c:if test="${produto.codigo == 3}"> <img src="images/security.jpg" width="60" height="60" alt="seguranca"/>
                        </c:if>
                                             

                        <c:out value= "${produto.nome}" />
                    </td>
                    <td><c:out value= "${produto.descricao}" /></td>
                    <td><c:out value= "${produto.preco}" /></td>
                    <td>
                        <input type="button" value="Adicionar ao carrinho" onclick= "javascript:document.location = 'ServletController?cmd=AdicionarItem&codigo=${produto.codigo}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br />
        
        <br> <a href='ListaPedidos.jsp'> Visualizar pedidos</a><br><br>
        <jsp:include page="rodape.jspf" />



    </body>
</html>
