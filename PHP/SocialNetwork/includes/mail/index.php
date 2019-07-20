<?php
defined('DS') ? null : define('DS', DIRECTORY_SEPARATOR);
defined('P_ROOT') ? null : define('P_ROOT', dirname($_SERVER['PHP_SELF'], 3));
header('Location: '.P_ROOT.DS.'public'.DS.'common'.DS.'index.php');
?>
