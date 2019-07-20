<?php
// Import PHPMailer classes into the global namespace
// These must be at the top of your script, not inside a function
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require_once 'vendor/autoload.php';


function send_my_email($to, $subject, $body, $password){
  $mail = new PHPMailer(true);                              // Passing `true` enables exceptions
  try {
      //Server settings
      //$mail->SMTPDebug = 2;                                 // Enable verbose debug output
      $mail->isSMTP();                                      // Set mailer to use SMTP
      $mail->Host = 'smtp.gmail.com';                       // Specify main and backup SMTP servers
      $mail->SMTPAuth = true;                               // Enable SMTP authentication
      $mail->Username = 'yashphy';                       // SMTP username
      $mail->Password = $password;                           // SMTP password
      $mail->SMTPSecure = 'ssl';                            // Enable TLS encryption, `ssl` also accepted
      $mail->Port = 465;                                    // TCP port to connect to

      //Recipients
      $mail->setFrom('yashphy@gmail.com', 'yashphy');

      $mail->addAddress($to, 'Customer');     // Add a recipient
      //$mail->addAddress('ellen@example.com');               // Name is optional
      $mail->addReplyTo('yashashah13@gmail.com', 'yashashah13');
      //$mail->addCC('cc@example.com');
      //$mail->addBCC('bcc@example.com');

      //Attachments
      //$mail->addAttachment('/var/tmp/file.tar.gz');         // Add attachments
      //$mail->addAttachment('/tmp/image.jpg', 'new.jpg');    // Optional name

      //Content
      $mail->isHTML(true);                                  // Set email format to HTML
      $mail->Subject = $subject;
      $mail->Body    = $body;//html body
      //incase html is not supported
      $mail->AltBody = $body;

      $mail->send();
      return 'Email has been sent';
  } catch (Exception $e) {
      //echo 'Message could not be sent. Mailer Error: ', $mail->ErrorInfo;
      throw $e;
  }
}






 ?>
