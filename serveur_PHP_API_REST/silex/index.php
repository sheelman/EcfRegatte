<?php
require_once __DIR__ . '/vendor/autoload.php';
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
$app = new Silex\Application();
$app['debug'] = true;
$pdo = new PDO('mysql:dbname=regatteTest;host=localhost;charset=utf8', 'admin', 'admin', array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
$app->get('/', function(){
	return new Response(json_encode("Hello world"), 200, array( 'Content-Type' => 'application/json' ));
	//return json_encode("Hello world");
});
$app->get('/course/{id}', function() use ($pdo){
	$sql = "SELECT * FROM course WHERE id_regatte = :id";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(":id", $id);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->get('/challenge/', function() use ($pdo){
	$sql = "SELECT * FROM challenge";
	$stmt = $pdo->prepare($sql);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->get('/regatte/{id}', function($id) use ($pdo){
	$sql = "SELECT * FROM regatte WHERE id_challenge = :id";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(":id", $id);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->get('/voilier/', function() use ($pdo){
	$sql = "SELECT * FROM voilier";
	$stmt = $pdo->prepare($sql);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->run();