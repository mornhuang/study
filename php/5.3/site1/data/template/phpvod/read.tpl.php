<script type="text/javascript">
function showstar()
{
var videostar = Math.round(<?php echo $video['star'];?> / 2);
var startip = new Array("很差劲","一般般","值得一看","推荐","力荐")
$("#showstar").empty();
for(var i=1;i<=5;i++)
{
pic = "<?php echo $imgpath;?>/star/"+(i<=videostar?"star1.png":"star2.png");
$("#showstar").append("<img title=\""+startip[i-1]+"\" src=\""+pic+"\" onmouseover=\"changestar("+i+");\" onmouseout=\"changestar("+videostar+");\" onclick=\"sendstar("+i+");\" />");
}	
}
function changestar(n)
{
if($("#showstar img").length > 0)
{
var stars = $("#showstar img");
for (var i=1;i<=5;i++)
{
pic = "<?php echo $imgpath;?>/star/"+(i<=n?"star1.png":"star2.png");
stars.eq(i-1).attr("src",pic);
}
}
}
function sendstar(n)
{
if(n>=1 && n<=5)
{
$.ajax({
type:"POST",
url:"ajax.php",
data:"action=videostar&vid=<?php echo $video['vid'];?>&starnum="+n,
success:function(data,st){alert(data);}
});			
}
}	
$("#showstar").ready(function(){
showstar();
});
</script>

<div class="navpath blue">当前位置: <?php echo $navpath;?></div><?php $adcode = ad('nav'); if($adcode!='') { ?><div class="adnav"><?php echo $adcode;?></div><?php } ?>

<div class="w960 mt10 fl">
<div class="w700 fl">
<dl class="box">
<dt>
<span class="fr defaultcolor fz12">
<!-- <a href="javascript:window.external.addFavorite('<?php echo $db_wwwurl;?>/read.php?vid=<?php echo $video['vid'];?>','<?php echo $video['subject'];?>');">收藏</a> -->
<a href="javascript:;" onclick='$.ajax({type:"POST",url:"ajax.php",data:"action=add_favorite&vid=<?php echo $video['vid'];?>", success:function(msg){alert(msg);}});'>收藏</a>
&nbsp; <a href="report.php?vid=<?php echo $vid;?>">举报</a>
<?php if($editvideo=='1') { ?>
&nbsp; <a href="post.php?action=modify&vid=<?php echo $video['vid'];?>">编辑</a>
<?php } if($delvideo=='1') { ?>
&nbsp; <a href="post.php?action=del&vid=<?php echo $video['vid'];?>" onclick="return window.confirm('您确定要删除视频 <?php echo $video['subject'];?> 吗？');">删除</a>
<?php } ?>					
</span>
视频详细信息
</dt>
<dd class="p10 w678">

<div class="videopic"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>" /></div>
<div class="videoinfo">

<div id="showstar"></div>
<h2><?php echo $video['subject'];?></h2>
<p class="line"><?php echo $video['class_name'];?> <span class="gray">(栏目)</span> &nbsp; <?php echo $video['nation_name'];?> <span class="gray">(地区)</span> &nbsp; <?php echo $video['serialise']>0 ? '连载至第'.$video['serialise'].'集' : '完结'; ?> <span class="gray">(状态)</span> &nbsp; <?php echo $video['author'];?> <span class="gray">(会员)</span></p>
<p>演员: <?php echo $video['playactor_link'];?></p>
<p>导演: <?php echo $video['director_link'];?></p>
<p>标签: <?php echo $video['tag_link'];?></p>
<p>年代: <?php echo $video['year'];?></p>
<p>评分: <?php echo $video['star'];?> (<?php echo $video['usernth'];?>人参与评分)</p>
<p>人气: <?php echo $video['hits'];?></p>
<p>发布时间: <?php echo get_date($video['postdate'], 'Y-m-d H:i'); ?> &nbsp; 更新时间: <?php echo get_date($video['lastdate'], 'Y-m-d H:i'); ?></p>
<p>备注: <?php echo $video['memo'];?></p>					
</div>

<div class="videointro">
<div class="caption">视频简介</div>
<div class="content"><?php echo $video['synopsis'];?></div>
</div>

<?php if($vr['buy_video']['result']!='1') { ?>
<div class="sale_msg mt10">您必须支付 <span class="stylecolor"><?php echo $vr['buy_video']['data']['sale_value'];?> <?php echo $vr['buy_video']['data']['sale_type_caption'];?></span> 才能观看视频。 <a href="javascript:;" onclick='$.ajax({type:"POST",url:"ajax.php",data:"action=buy_video&vid=<?php echo $video['vid'];?>", success:function(msg){if(msg!="1") alert(msg); else {alert("恭喜，购买成功！"); window.location.reload();}}});'>[付费购买]</a></div>
<?php } if($vr['need_credit']['result']!='1') { ?>
<div class="need_msg mt10">您必须拥有 <span class="stylecolor"><?php echo $vr['need_credit']['data']['need_value'];?> <?php echo $vr['need_credit']['data']['need_type_caption'];?></span> 以上才能观看视频。</div>
<?php } if($vr['buy_video']['result']=='1' && $vr['need_credit']['result']=='1') { if(is_array($urldb)) { foreach($urldb as $playgroup => $msg) { ?><div class="videourls">
<div class="caption"><span class="fr"><?php echo $msg['player'];?></span>播放组<?php echo $msg['playgroup'];?></div>
<div class="content"><?php if(is_array($msg['urls'])) { foreach($msg['urls'] as $key => $v) { ?><a href="play.php?vid=<?php echo $video['vid'];?>&playgroup=<?php echo $msg['playgroup'];?>&index=<?php echo $key;?>" target="_blank" title="<?php echo $v['caption'];?>"><?php echo $v['caption'];?></a><?php } } ?><div class="cb"></div>							
</div>
</div><?php } } } if($db_reply=='1') { ?>
<div class="videoreply">
<div class="caption">视频评论</div>
<div class="content">
<form method="post" name="replyform" action="reply.php?action=add" id="login" onsubmit="return false;">
<input type="hidden" name="vid" id="vid" value="<?php echo $video['vid'];?>" />
<input type="hidden" name="cid" id="cid" value="<?php echo $video['cid'];?>" />
<div class="showedit"><?php echo create_kindeditor('content','658','200'); ?></div>
<div class="fr">
<input type="button" value="提 交" onclick="post_reply();" class="button1" />
<input type="button" value="重 写" onclick="KE.html('');" class="button2" />
</div>
<?php if($db_gdcheck & 4) { ?>
<div class="fl">
<div class="fl"><label for="gdcode">验证码：</label></div>
<div class="fl"><input type="input" id="gdcode" name="gdcode" size="6" class="text" /></div>
<div class="gdimg fl"><img src="ck.php?admin=1&nowtime=<?php echo $timestamp;?>" align="absmiddle" style="cursor:pointer;" id="ckcode" onclick="this.src='ck.php?admin=1&nowtime='+new Date().getTime();" alt="看不清楚，换一张" title="看不清楚，换一张" /></div>
</div>
<?php } ?>
<div class="cb"></div>								
</form>	
<a name="replylist"></a>
<div id="replylist">正在加载评论，请稍候...</div>					
</div>					
</div>

<script type="text/javascript">
function post_reply()
{
len = KE.count('text');
if(len < <?php echo $db_postmin;?> || len > <?php echo $db_postmax;?>)
{
alert('内容尺寸必须在 <?php echo $db_postmin;?> - <?php echo $db_postmax;?> 之间, 当前长度: '+len);
}
else
{
var gdcheck = $("#gdcode").length > 0 ? true : false;
vid = $("#vid").attr("value");
cid = $("#cid").attr("value");
content = KE.html();
var datastr = {"vid":vid,"cid":cid,"content":content};

if(gdcheck)
{
if($("#gdcode").val()=="")
{
alert("请输入验证码");
$("#gdcode").focus();
return false;								
}
else
{
var gdcode = $("#gdcode").val();
}
}

if(gdcode == undefined)
var datastr = {"vid":vid,"cid":cid,"content":content};
else
var datastr = {"vid":vid,"cid":cid,"content":content,"gdcode":gdcode};					

$.ajax({
type:"POST",
url:"reply.php?action=add",
data:datastr,
success:function(msg){
if(gdcheck)
{
$("#gdcode").attr("value","");
$("#ckcode").attr("src","ck.php?admin=1&nowtime="+new Date().getTime()); //更换验证码										
} 

if(msg!='success' && msg!='')
{
alert(msg);
}
else
{
KE.html('');
get_reply(vid);									
}
}
});				
}			
}

function get_reply(vid)
{
var parampage = arguments[1];
var page = parampage ? parampage : 1;
  
$.ajax({
type:"POST",
url:"reply.php",
data:"vid="+vid+"&page="+page,
success:function(msg){
$("#replylist").html(msg);
if(parampage) location.hash="#replylist"; //如果参数包含页码，则跳转到#replylist标记
}
});
}

get_reply(<?php echo $vid;?>);
</script>
<?php } ?>															

</dd>		
</dl>


</div>
<div class="w245 fr">
<dl class="box">
<dt>栏目排行 </dt>
<dd class="h395 numbg">
<ul class="vl"><?php $i=1; $videodb = pv_loop('video',"cid=$video[cid]|showsub=1|order=hits DESC|limit=10"); if(is_array($videodb)) { foreach($videodb as $video) { if($i==1) { ?>
<li class="l1">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/><span class="num1"></span></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video['hits'];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'], 'Y-m-d H:i'); ?></p>							
</li>					
<?php } else { ?>
<li>
<span class="fr"><?php echo $video['hits'];?></span>
<span class="sj"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></span>
</li>					
<?php } $i++; } } ?></ul>				
</dd>			
</dl><?php $videodb = pv_loop('video',"cid=$video[cid]|best=2|showsub=1|order=lastdate DESC,postdate DESC|limit=3"); if(!empty($videodb)) { ?>
<dl class="box mt10">
<dt>栏目推荐</dt>
<dd>
<ul class="vl"><?php if(is_array($videodb)) { foreach($videodb as $key => $video) { ?><li class="l1<?php if($key>0) { ?> mt10<?php } ?>">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video['hits'];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'], 'Y-m-d H:i'); ?></p>							
</li><?php } } ?></ul>			
</dd>
</dl>
<?php } ?>		
</div>
</div>
