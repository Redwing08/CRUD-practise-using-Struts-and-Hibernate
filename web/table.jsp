<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f8f9fa;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #007bff;
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        button, .action-btn {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        .btn-edit {
            background-color: #28a745;
            color: white;
        }

        .btn-edit:hover {
            background-color: #218838;
        }

        .btn-delete {
            background-color: #dc3545;
            color: white;
        }

        .btn-delete:hover {
            background-color: #c82333;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        button {
            background-color: #007bff;
            color: white;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Patient List</h1>
    
  <s:form action="Act" method="post" id="filterForm">
      <s:select 
        name="type" 
        list="{'All', 'Outsource', 'Employee'}" 
        label="Patient Type" 
        onchange="document.getElementById('filterForm').submit();" />
</s:form>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Patient Name</th>
            <th>Chief Complaints</th>
            <th>Patient Type</th>
            <th>Narration</th>
            <th>Nurse</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="patients">
            <tr>
                <td><s:property value="id" /></td>
                <td><s:property value="p_name" /></td>
                <td><s:property value="complaints" /></td>
                <td><s:property value="p_type" /></td>
                <td><s:property value="narration" /></td>
                <td><s:property value="nurse" /></td>
                <td>
                    <s:url id="EditAct" action="EditAct">
                        <s:param name="id" value="%{id}" />
                    </s:url>
                    <a href="<s:property value='%{EditAct}'/>" class="action-btn btn-edit">Edit</a>

                    <s:url id="DeleteAct" action="DeleteAct">
                        <s:param name="id" value="%{id}" />
                    </s:url>
                    <a href="<s:property value='%{DeleteAct}'/>" class="action-btn btn-delete">Delete</a>
                </td>
            </tr>
        </s:iterator>
    </tbody>
</table>

</body>
</html>
