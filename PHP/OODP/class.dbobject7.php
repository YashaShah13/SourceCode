<?php
/**
 *
 */
abstract class DbObject{

  function __construct($arguments){
    $keys = array_keys($this->_attributes);
    for ($i=0; $i < count($this->_attributes); $i++) {
      try {
        $this->__set($keys[$i], $arguments[$i]);
      } catch (Exception $e) {
        throw $e;
      }
    }
  }

  public function __get($attribute){
    if(array_key_exists($attribute, $this->_attributes)){
      return $this->_attributes[$attribute];
    }else{
      throw new Exception("Invalid Attribute: " . $attribute);
    }
  }

  public function __set($attribute, $value){
    if(array_key_exists($attribute, $this->_attributes)){
      $setter_function = "_set_".$attribute;
      try {
        $this->$setter_function($value);
      } catch (Exception $e) {
        throw $e;
      }
    }else{
      throw new Exception("Invalid Attribute: " . $attribute);
    }
  }

  //password hash cannont be passed and instantiate when there is a
  //unique db entry
  public function instanciate_from_db($key_value_pairs){
    global $db;
    
    $result = $this->return_existing_db_enties($key_value_pairs);
    // return $result;
    if($result->rowCount() === 1){
      $row = $result->fetch(PDO::FETCH_ASSOC);

      foreach ($row as $key => $value) {
        $this->_attributes[$key] = $value;
      }
      // return $this;
    }else{
      throw new Exception("Either no db entery or entry is not unique");
    }
  }

  protected static function return_existing_db_enties($key_value_pairs){//no password allowed
    global $db;
    $values = array();
    $sql = "SELECT * FROM " . static::$_table;
    if(!empty($key_value_pairs)){
      $sql .= " WHERE ";
      foreach ($key_value_pairs as $key => $value) {
        $sql .= $key . "= ? AND ";
        $values[] = $value;
      }
      $sql = substr($sql, 0, -5);
    }
    $sql .=  ";";
    try {
      $statement = $db->prepare($sql);
      $statement->execute($values);
      return $statement;
    } catch (Exception $e) {
      throw $e;
    }

  }

  public function insert_into_table(){
    global $db;
    $valuees = array();
    $sql1 = "INSERT INTO " . static::$_table . " (";
    $sql2 = ") VALUES (";

    foreach ($this->_attributes as $key => $value) {
      if($key != "id"){
        $sql1 .= $key . ", ";
        $sql2 .= "?, ";
        $valuees[] = $value;
      }
    }
    $sql1 = substr($sql1, 0, -2);
    $sql2 = substr($sql2, 0, -2);
    $sql = $sql1 . $sql2 . "); ";

    try {
      $db->beginTransaction();
      $statement = $db->prepare($sql);
      $statement->execute($valuees);
      $this->_attributes["id"] = $db->lastInsertId();
      $db->commit();
    } catch (Exception $e) {
      throw $e;
    }
  }

}




?>
