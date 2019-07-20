<?php
  require_once 'class.mypdo7.php';
  require_once 'class.dbobject7.php';
  require_once 'class.user7.php';
  try {
    $current_user = new User(0, "NFN", "NLN", "as@gmail.com", "NUN", "as", "user", "NC");
    var_dump($current_user);
    $current_user->verify_password();
    var_dump($current_user);
    ///////////////
    // $key_value_pairs = ["first_name"=>"Peter", "last_name"=>"Don"];
    // $results = User::return_existing_db_enties($key_value_pairs);
    //
    // while ($row = $results->fetch(PDO::FETCH_ASSOC)) {
    //   foreach ($row as $key => $value) {
    //     echo $key ." = " . $value . "<br>";
    //   }
    //   echo "-----------------<br><br>";
    // }
    //
    // echo "<br>";
    //var_dump(User::return_existing_db_entiews($key_value_pairs));
    ////////////////////
    // $current_user = new User(0, "Arjun", "Shibi", "as@gmail.com", "as", "as", "user", "NC");
    // var_dump($current_user);
    // $current_user->insert_into_table();
    // var_dump($current_user);
    //print_r($current_user->insert_into_table());

    //$current_user->mid_name = "K";
  } catch (Exception $e) {
    $message = $e->getMessage();
  }



?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <h1>Learning Classes and Classes</h1>
    <h2>Welcome <?php
                    try {
                      //echo $current_user->username;
                    } catch (Exception $e) {
                      $message = $e->getMessage();
                    }
                    ?>
    </h2>
    <p>Introducing attributes in an array and...</p>
    <p>...magic getter and setter...</p>
    <p>----------</p>
    <p>...adding construct to the class...</p>
    <p>-----------------</p>
    <p>Itroduced the concept of static</p>
    <p>-----------------</p>
    <p>PDO Prepare</p>
    <?php
      if(isset($message)){
        echo "<script>alert('". $message ."')</script>";
      }
    ?>
  </body>
</html>
