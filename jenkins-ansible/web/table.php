<!DOCTYPE html>
<html>
<head>
<title>Table</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>

  <div class="container">
    <table class="table">
      <thead>
        <tr class="table-dark">
          <th scope="col">ID</th>
          <th scope="col">NAME</th>
          <th scope="col">LASTNAME</th>
          <th scope="col">AGE</th>
        </tr>
      </thead>
      <tbody>
          <?php
            $con = mysqli_connect("db_mysql", "root","1234","people");
            if($con->connect_error){
                echo "Connection failed.";
                die("Connection failed: " . $con->connect_error);
            }
            $sql = "SELECT id, name, lastname, age FROM register WHERE age = 25";
            $result = $con->query($sql);
            if($result->num_rows > 0){
                while($row = $result->fetch_assoc()){
                    echo "
                    <tr>
                     <th scope='row'>".
                      $row["id"].
                     "</th>
                     <td>".
                      $row["name"].
                     "</td>
                     <td>".
                      $row["lastname"].
                     "</td>
                     <td>".
                      $row["age"].
                     "</td>
                    </tr>";
                }
            } else {
                echo "0 results";
            }
            $con->close();
          ?>
      </tbody>
    </table>
  </div>

</body>
</html>
