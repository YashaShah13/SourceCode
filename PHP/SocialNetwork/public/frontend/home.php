<?php require_once '../layouts/header.php'; ?>
<?php
if(isset($_POST["remove"]))
{
  DbObject::remove_friend($user->id,$_POST["id"]);
  DbObject::remove_friend($_POST["id"],$user->id);
}

$result=DbObject::return_existing_db_enties(["user_id"=>$user->id],"friends");
$friend_list=array();
for($i=0;$i<$result->rowCount();$i++){
$row=$result->fetch(PDO::FETCH_ASSOC);
$friend_result=DbObject::get_profile($row["friend_id"]);
$friend=$friend_result->fetch(PDO::FETCH_ASSOC);
$friend_list[]=$friend;
}

?>
    <h2>Your Friends</h2>
  <?php   for($i=0;$i<sizeof($friend_list);$i++){ ?>

    <form method="post">
      <input type="text" name="id" value="<?php echo $friend_list[$i]["id"];?>" readonly>
      <button type="submit" name="remove">Remove Friend</button>
    </form>
    <h3><?php echo
        $friend_list[$i]["first_name"].$friend_list[$i]["last_name"]."<br>".
        $friend_list[$i]["username"]."<br>".
        $friend_list[$i]["email"]
    ; ?></h3>

  <?php } ?>

  </body>
</html>
