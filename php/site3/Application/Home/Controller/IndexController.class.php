<?php
namespace Home\Controller;
use Think\Controller;
class IndexController extends Controller {
    public function index(){
        $db = M('user');
        $result = $db->select();
        dump($result);
    }

    public function show() {

    }
}
