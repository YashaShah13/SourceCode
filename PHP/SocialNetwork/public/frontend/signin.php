<?php
require_once '../../includes/init.php';
//if(isset($_SESSION["is_signedin"])&&$_SESSION["is_signedin"]==true)
//require_once '../layouts/header.php';

?>
<?php

if(!(isset($_SESSION["is_signedin"])&&$_SESSION["is_signedin"]==true)){
require_once 'signup.php';
}
if(isset($_POST["signin"])){

  $email=$_POST["email"];
  $password=$_POST["password"];

  //header("Location: pin.php");
try {
    $current_user = new User(0, "NFN", "NLN", $email, "NUN", $password, "user", "NC");
    $current_user->verify_password($password);
    //var_dump($current_user);
    $_SESSION["is_signedin"]=true;
    $_SESSION["current_user"]=$current_user;
    header("Location: about.php");
}catch (Exception $e) {
  $message = $e->getMessage();
}

}

 ?>

    <h2>Signin</h2>
    <form method="post" >
      <input type="email" name="email" placeholder="Email" required>
      <input type="password" name="password" placeholder="Password" required>
      <button type="submit" name="signin">Signin</button>
    </form>

    <?php
    if(isset($message)){
      echo "
      <script>alert('".$message."');</script>
      ";
    }


    ?>

  </body>
</html>
