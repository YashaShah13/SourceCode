<?php
/**
 *
 */
class User extends DbObject{
  public $_attributes = array(
    "id" => null,
    "first_name" => null,
    "last_name" => null,
    "email" => null,
    "username" => null,
    "password" => null,
    "type" => null,
    "comment" => "NC"
  );

  protected static $_table = "users";

  function __construct(
    $id = 0,
    $first_name = "NFN",
    $last_name = "NLN",
    $email = "noreply@ourdomain.com",
    $username = "FN",
    $password = "FN",
    $type = "user",
    $comment = "NC"
  ){
    $arguments = func_get_args();
    try {
      parent::__construct($arguments);
    } catch (Exception $e) {
      throw $e;
    }
  }

  //magical getter is executed automagically once someone try to
  //get any attribute of this class

  public function verify_password(){
    $results = static::return_existing_db_enties(["email"=>$this->_attributes["email"]]);

    if($results->rowCount() === 1){

      $row = $results->fetch(PDO::FETCH_ASSOC);

      if(password_verify($this->password, $row["password"])) {

      $this->instanciate_from_db(["email"=>$this->_attributes["email"]]);

      }
    }else{
      throw new Exception("Invalid email or password");
    }
  }

  protected function _set_id($id){
    if(is_int($id)){
      $this->_attributes["id"] = $id;
    }else{
      throw new Exception("Invalid id.");
    }
  }

  protected function _set_first_name($first_name){
    if(ctype_alpha($first_name)){
      $this->_attributes["first_name"] = filter_var(trim($first_name), FILTER_SANITIZE_STRING);
    }else{
      throw new Exception("Invalid First Name.");
    }
  }

  protected function _set_last_name($last_name){
    if(ctype_alpha($last_name)){
      $this->_attributes["last_name"] = filter_var(trim($last_name), FILTER_SANITIZE_STRING);
    }else{
      throw new Exception("Invalid Last Name.");
    }
  }

  protected function _set_email($email){
    if(filter_var($email, FILTER_VALIDATE_EMAIL)){
      $this->_attributes["email"] = filter_var(trim($email), FILTER_SANITIZE_EMAIL);

      if(!($this->check_email($this->_attributes["email"])));
    }else{
      throw new Exception("Invalid Email.");
    }
  }

  protected function _set_username($username){
    if(is_string($username)){
      $this->_attributes["username"] = filter_var(trim($username), FILTER_SANITIZE_STRING);
    }else{
      throw new Exception("Invalid Username.");
    }

  }

  protected function _set_password($password){
    if(trim($password) != ""){

      $this->_attributes["password"] = password_hash(trim($password), PASSWORD_DEFAULT);
    }else{
      throw new Exception("Invalid Password.");
    }
  }

  protected function _set_type($type){
    if($type == "user" || $type == "admin"){
      $this->_attributes["type"] = filter_var($type, FILTER_SANITIZE_STRING);
    }else{
      throw new Exception("Invalid Type.");
    }
  }

  protected function _set_comment($comment){
    if(is_string($comment)){
      $this->_attributes["comment"] = filter_var(trim($comment), FILTER_SANITIZE_STRING);
    }else{
      throw new Exception("Invalid Comment.");
    }

  }

}


?>
