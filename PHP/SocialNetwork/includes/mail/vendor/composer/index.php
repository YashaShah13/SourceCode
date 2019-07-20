<?php
defined('DS') ? null : define('DS', DIRECTORY_SEPARATOR);
defined('P_ROOT') ? null : define('P_ROOT', dirname($_SERVER['PHP_SELF'], 5));
header('Location: '.P_ROOT.DS.'public'.DS.'common'.DS.'index.php');
?>
