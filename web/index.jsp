<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Form</title>
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

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input, select, textarea, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }

        input:focus, select:focus, textarea:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 4px rgba(0, 123, 255, 0.2);
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px;
            border-radius: 4px;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .back-link {
            text-align: center;
            margin: 20px 0;
            display: inline-block;
            color: #007bff;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Patient Form</h1>
    <div class="container">
        <a href="index.jsp" class="back-link">Back to Home</a>
        <s:form method="post" action="SaveAct">
            <s:hidden name="p.id" value="%{p.id}" />
            
            <div class="form-group">
              
                <s:textfield name="p.p_name" label= "Patients Name"/>
            </div>
            
            <div class="form-group">
               
                <s:textfield name="p.complaints"  label= "Patients Complaints"/>
            </div>
            
            <div class="form-group">
           
                <s:select name="p.p_type" list="{'Outsource', 'Employee'}"  label= "Patients Type" />
            </div>
            
            <div class="form-group">
               
                <s:textarea name="p.narration"  label= "Patients Narration"/>
            </div>
            
            <div class="form-group">
             
                <s:textfield name="p.nurse"  label= "Patients Nurse On Duty "/>
            </div>
            
            <div class="form-group">
                <s:if test="%{isEdit}">
                    <button type="submit">Update Data</button>
                </s:if>
                <s:else>
                    <button type="submit">Save Data</button>
                </s:else>
            </div>
        </s:form>

        <s:form method="post" action="Act">
            <div class="form-group">
                <button type="submit">View Tables List</button>
            </div>
        </s:form>
    </div>
</body>
</html>
