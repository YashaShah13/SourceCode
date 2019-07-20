<?php
  $this_page = basename($_SERVER["PHP_SELF"]);
  $html = '
          <a href="about.php">profile</a>
          <a href="home.php">friends</a>
          <a href="services.php">Search Friends</a>
          <a href="signout.php">Sign out</a>
          ';

  $dom = new DOMDocument();
  $dom->loadHTML($html);

  $a_tags = $dom->getElementsByTagName('a');
  foreach ($a_tags as $tag) {
    if($tag->getAttribute("href") === $this_page){
      $tag->setAttribute("class", "this-page");

      break;
    }
  }
  $html = $dom->saveHTML();


?>
