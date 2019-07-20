<?php

if(isset($_POST["signup"]))
{
    $first_name=$_POST["first_name"];
    $last_name=$_POST["last_name"];
    $username=$_POST["username"];
    $password=$_POST["password"];
    $email=$_POST["email"];

try{
    $user=new User(0, $first_name, $last_name, $email, $username, $password, "user", "NC");
    if(User::verify_email($email)==true){
    $user->insert_into_table();
    $message="signup Succesful";
}
}
catch(Exception $e){
  $message = $e->getMessage();
}
}
 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <h1>Sign Up</h1>
    <form class="" method="post">
      <!-- <input type="number" name="rand" value="<?php echo $rand; ?>" hidden> -->
      <input type="text" name="first_name" placeholder="First Name" required>
      <input type="text" name="last_name" placeholder="Last Name" required>
      <input type="text" name="username" placeholder="Username" required>
      <input type="password" name="password" placeholder="Password" required>
      <input type="email" name="email" placeholder="Email" required>
      <button type="submit" name="signup">Signup</button>
    </form>

  </body>
</html>
