<html>
	<head>
		<title>你好</title>
	</head>
	<body>
		<p>${myval!"myval为null"}</p>
		<#if myval??>
		<p>myval不为空</p>
		<#else>
		<p>myval为空</p>
		</#if>
		<#include "data.ftl">
	</body>
</html>