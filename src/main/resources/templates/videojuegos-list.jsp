<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Listado de Videojuegos</h1>
        <button type="submit" class="btn btn-primary">Nuevo</button>
        <hr/>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Categoria</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>LOU2</td>
                    <td>Shooter</td>
                    <td>
                        <div class="btn-group" role="group" >
                            <button type="button" class="btn btn-secondary">Editar</button>
                            <button type="button" class="btn btn-secondary">Eliminar</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Fornite</td>
                    <td>Shooter</td>
                    <td>
                        <div class="btn-group" role="group" >
                            <button type="button" class="btn btn-secondary">Editar</button>
                            <button type="button" class="btn btn-secondary">Eliminar</button>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>