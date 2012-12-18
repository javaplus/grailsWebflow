<html>
<head>

</head>

<body onload="setFocus()">

<h1> Crusty Page</h1>

<g:form>
	
	<!--  this will get the exception message if one exists-->
	${flowExecutionException?.cause?.cause?.message}
	Choose Crust: <g:textField name="crust" value="${crust}" autofocus="autofocus"/>
	
	<g:submitButton name="next" value="Next"/>


</g:form>



</body>

</html>