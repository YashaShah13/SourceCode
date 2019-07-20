<?php
  defined("DS") ? null : define("DS", DIRECTORY_SEPARATOR);
  require_once ".." . DS . ".." . DS . "includes" .DS. "init.php";
  require_once "navbar.php";
if(isset($_SESSION["is_signedin"])&&$_SESSION["is_signedin"]==true){
$user=$_SESSION["current_user"];
}
else {
  header("Location: ../frontend/signin.php");
}
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>NavBar</title>
    <link rel="stylesheet" href= "../stylesheets/master.css">
  </head>
  <body>
    <header>
      <img src="../assets/images/100.jpg" alt="">
      <nav>
        <?php echo $html; ?>
      </nav>
    </header>
