<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script src="js/jquery.rating.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

$.noConflict();

$.ajaxSetup ({ cache: false });

$(document).ready(function(){

	$.getJSON("http://localhost:8080/deputados", 
    {}, 
    function(data) {
        var body = document.getElementsByTagName("body")[0];


        var tbl     = document.createElement("table");
        var tblBody = document.createElement("tbody");	
    	
  		var tamanho = data.tamanho -1;


    	

    	for (var i=0;i<=tamanho;i++)
    	{
            var row = document.createElement("tr");

            
            var cell1 = document.createElement("td");
            var cellText1 = document.createTextNode(data['deputado'+i].nome);
            cell1.appendChild(cellText1);
            row.appendChild(cell1);
    		        	
            var cell2 = document.createElement("td");
            var cellText2 = document.createTextNode(data['deputado'+i].partido);
            cell2.appendChild(cellText2);
            row.appendChild(cell2);

            var cell3 = document.createElement("td");
            var cellText3 = document.createTextNode(data['deputado'+i].estado);
            cell3.appendChild(cellText3);
            row.appendChild(cell3);


    		tblBody.appendChild(row);
    	}

     
        tbl.appendChild(tblBody);

        body.appendChild(tbl);

        tbl.setAttribute("border", "1");
    });
});

</script>

<title>Apresentação de parlamentares</title>
</head>
<body>
<h1>Lista de deputados</h1>
</body>
</html>