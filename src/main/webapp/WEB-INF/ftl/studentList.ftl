<html>
	<head>
		<title></title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
			</tr>
			<#list studentList as student>
			<#if student_index%2==0>
			<tr style="background-color:white">
			<#else>
			<tr style="background-color:blue">
			</#if>
				<td>${student_index}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
			</tr>
			</#list>
		</table>
	</body>
</html>