<?php require_once '../layouts/header.php'; ?>

<h2>    <?php
echo "first name: ".$user->first_name ."<br>".
"last name: ".$user->last_name."<br>".
"User name: ".$user->username."<br>".
"Email: ".$user->email."<br>".
"User id: ".$user->id
;

     ?>
</h2>
  </body>
</html>
