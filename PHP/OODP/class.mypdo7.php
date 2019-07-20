<?php
  /**
   *
   */
  class MyPDO extends PDO{

    function __construct($dsn, $username, $password){
      parent::__construct($dsn, $username, $password);
    }

    public function my_exec($sql){
      $result = parent::exec($sql);
      if($result){
        return $result;
      }else{
        throw new Exception("my_exec was unsuccessful");
      }
    }

    public function my_query($sql){
      $result = parent::query($sql);
      if($result->rowCount() > 0){
        return $result;
      }else{
        throw new Exception("No such DB entry");
      }
    }
  }
  $dsn = "mysql:host=127.0.0.1; dbname=oodpfall2018";
  $db = new MyPDO($dsn, "oodpfall2018", "1234");
?>
