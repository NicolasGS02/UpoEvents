<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Nuevo Evento</title>
    <style>
        /* Contenedor centrado en la página */
        .wrapper {
            width: 90%;
            max-width: 400px;
            margin: 50px auto;      /* 50px desde el top, auto a los lados para centrar */
            padding: 20px;
            background-color: #fff;  /* Opcional, para resaltar la zona */
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            border-radius: 4px;
            box-sizing: border-box;
        }
        /* Título centrado */
        .wrapper h1 {
            text-align: center;
            margin-top: 0;
            margin-bottom: 20px;
            color: #333;
        }
        /* Tabla del formulario centrada dentro del wrapper */
        .form-table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto;  /* centra la tabla horizontalmente */
        }
        .form-table td.label-cell {
            width: 100px;
            text-align: right;
            padding-right: 10px;
            vertical-align: top;
            color: #555;
            font-weight: bold;
        }
        .form-table td.field-cell input[type="text"],
        .form-table td.field-cell textarea {
            width: 100%;
            padding: 6px 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .form-table td.field-cell textarea {
            resize: vertical;
            height: 80px;
        }
        .form-table td {
            padding: 8px 0;
        }
        /* Zona de botones centrada */
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        .buttons .btn {
            display: inline-block;
            padding: 8px 16px;
            border-radius: 3px;
            font-size: 14px;
            cursor: pointer;
            text-decoration: none;
            color: #fff;
            border: none;
        }
        .buttons .btn-primary {
            background-color: #007bff;
        }
        .buttons .btn-primary:hover {
            background-color: #0056b3;
        }
        .buttons .btn-secondary {
            background-color: #6c757d;
            margin-left: 10px;
        }
        .buttons .btn-secondary:hover {
            background-color: #5a6268;
        }
        .error {
            color: #dc3545;
            font-size: 13px;
            margin-bottom: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <!-- Título centrado -->
        <h1>Crear Evento para:<br/><s:property value="organizacionNombre"/></h1>

        <!-- Mensajes de error (si existen) -->
        <s:if test="hasFieldErrors()">
            <div class="error">
                <s:fielderror fieldName="evento.capacidad"/><br/>
                <s:fielderror fieldName="evento.informacion"/><br/>
                <s:fielderror fieldName="evento.ubicacion"/><br/>
                <s:fielderror fieldName="fechaEvento"/>
            </div>
        </s:if>

        <s:form action="crearEvento" method="post">
            <!-- Campo oculto para la organización -->
            <s:hidden name="evento.idOrganizacion" value="%{idOrganizacion}"/>

            <!-- Tabla centrada que alinea label y campo en paralelo -->
            <table class="form-table">
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="evento.capacidad" id="capacidad" label="Capacidad"/>
                    </td>
                </tr>
                <tr>
                    <td class="label-cell">
                        <s:textarea name="evento.informacion" id="informacion" label="Información"/>
                    </td>
                </tr>
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="evento.ubicacion" id="ubicacion" label="Ubicación"/>
                    </td>
                </tr>
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="fechaEvento" id="fecha" placeholder="YYYY-MM-DD" label="Fecha"/>
                    </td>
                </tr>
            </table>

            <!-- Botones centrados debajo del formulario -->
            <div class="buttons">
                <button type="submit" class="btn btn-primary">Guardar Evento</button>
                <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                   class="btn btn-secondary">Cancelar</a>
            </div>
        </s:form>
    </div>
</body>
</html>
