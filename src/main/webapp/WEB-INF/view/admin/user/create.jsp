<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" pageEncoding="UTF-8" %>

        <!DOCTYPE html>
        <html lang="en">
        <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
                crossorigin="anonymous">

            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.min.js"
                integrity="sha384-7qAoOXltbVP82dhxHAUje59V5r2YsVfBafyUDxEdApLPmcdhBPg1DKg1ERo0BZlK"
                crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.7.1.js"
                integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        </head>

        <body>
            <div class="container mt-5">
                <h1>Tạo mới User</h1>

                <form:form action="/admin/user/create" method="post" modelAttribute="newUser">
                    <div class="form-group">
                        <label path="username">Tài khoản</label>
                        <form:input path="username" class="form-control"></form:input>
                    </div>
                    <div class="form-group">
                        <label path="age">Tuổi</label>
                        <form:input path="age" class="form-control"></form:input>
                    </div>
                    <div class="form-group">
                        <label path="phoneNumber">Số điện thoại</label>
                        <form:input path="phoneNumber" class="form-control"></form:input>
                    </div>
                    <div class="form-group">
                        <label path="address">Địa chỉ</label>
                        <form:input path="address" class="form-control"></form:input>
                    </div>
                    <div class="mt-2">
                        <form:button class="btn btn-primary" type="submit">
                            Tạo mới
                        </form:button>
                    </div>
                </form:form>
            </div>
        </body>

        </html>