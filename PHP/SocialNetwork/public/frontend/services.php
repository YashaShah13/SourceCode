<?php require_once '../layouts/header.php'; ?>

<?php
$search_result=array();
if(isset($_POST["search"])){
  $fname=$_POST["first_name"];
  $lname=$_POST["last_name"];
  $key_value_pairs=["first_name"=>$fname,"last_name"=>$lname];
  $result=DbObject::return_existing_db_enties($key_value_pairs);
  if($result->rowCount()>0){

    for($i=0;$i<$result->rowCount();$i++){
      $row=$result->fetch(PDO::FETCH_ASSOC);
      $search_result[]=$row;
    }
  }
  else {
    $message="No such person";

  }
}

if(isset($_POST["add"]))
{
  $frnd_id=$_POST["id"];
  $result=DbObject::add_friend($user->id,$_POST["id"]);
  $result=DbObject::add_friend($_POST["id"],$user->id);
  //var_dump($result);

}

?>
<h2>Search People</h2>

<form method="post">
  <input type="text" name="first_name" placeholder="First Name" required>
  <input type="text" name="last_name" placeholder="Last Name" required>
  <button type="submit" name="search">Search</button>
</form>

<?php if(sizeof($search_result)>0) {?>
  <?php for($i=0;$i<sizeof($search_result);$i++) {?>
    <?php if(!(DbObject::isaFriend($search_result[$i]["id"]))) {?>
      <form method="post">
        <h2>
          <input type="text" name="id" value="<?php echo $search_result[$i]["id"] ?>" readonly>
          <button type="submit" name="add">Add friend</button>
        </form>
      </h2>
      <h3>
        <?php echo $search_result[$i]["first_name"].$search_result[$i]["last_name"]; ?><br>
        <?php echo $search_result[$i]["email"] ?><br>
        <?php echo $search_result[$i]["username"] ?></h3>

      <?php }}} ?>

      <?php
      if(isset($message)){
        echo "
        <script>alert('".$message."');</script>
        ";
      }

      ?>

    </h2>
  </body>
  </html>
