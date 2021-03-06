<form method="post" name="from" id="postform" action="post.php" enctype="multipart/form-data">
<input type="hidden" name="action" value="<?php echo $action;?>" />
<input type="hidden" value="2" name="step" />

<?php if($action=='modify') { ?>
<input type="hidden" value="<?php echo $video['vid'];?>" name="video[vid]" />
<?php } if(($action=='new' || $action=='modify') && $step!='2') { ?>
<table class="box w958 mt10" id="tp">
<tr><th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> <a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 
<?php if($action=='new') { ?>发布视频<?php } else { ?>编辑视频<?php } ?>
</th></tr>


<?php if($db_gdcheck & 4) { ?>
<tr>
<td>认证码<span style="color:red;">*</span></td>
<td>
<div><input type="input" id="gdcode" name="video[gdcode]" size="6" class="text" /></div>
<div class="mt2"><img src="ck.php?nowtime=<?php echo $timestamp;?>" align="absmiddle" style="cursor:pointer;" id="ckcode" onclick="this.src='ck.php?nowtime='+new Date().getTime();" alt="看不清楚，换一张" title="看不清楚，换一张" /></div>
</td>
</tr>
<?php } ?>

<tr>
<td class="w40">所属类别<span style="color:red;">*</span></td>
<td>
<select name="video[cid]">
<?php echo $_class_opt;?>
</select>
</td>
</tr>

<tr>
<td>国家/地区<span style="color:red;">*</span></td>
<td>
<select name="video[nid]">
<?php echo $_nation_opt;?>
</select>
</td>
</tr>

<tr>
<td>标题<span style="color:red;">*</span></td>
<td>
<input type="text" name="video[subject]" id="subject" size="30" class="text" value="<?php echo $video['subject'];?>" onblur='$.ajax({type:"POST",url:"ajax.php",data:"action=check_video_subject&subject="+this.value, success:function(msg){$("#post_check_subject").html(msg);}});' />
<span id="post_check_subject"></span>
</td>
</tr>

<tr>
<td>标签[<a href="#" onclick="this.blur();alert('其他用户可以通过标签方便的找到这个节目');return false;">说明</a>]</td>
<td>
<input type="text" name="video[tag]" value="<?php echo $video['tag'];?>" class="text" /> (多个标签、演员或导演请用空格或","隔开)
</td>
</tr>

<tr>
<td>领衔主演</td>
<td><input type="text" name="video[playactor]" value="<?php echo $video['playactor'];?>" class="text" /></td>
</tr>

<tr>
<td>导演</td>
<td><input type="text" name="video[director]" value="<?php echo $video['director'];?>" class="text" /></td>
</tr>

<?php if($db_yearstart!='' && $db_yearend!='') { ?>
<tr>
<td>发行年份</td>
<td>
<select name="video[year]">
<option value="" />未知<?php for($i=$db_yearstart;$i<=$db_yearend;$i++) { ?><option value="<?php echo $i;?>"<?php echo $year[$i];?> /><?php echo $i;?><?php } ?></select>
</td>
</tr>
<?php } ?>

<tr>
<td>影片状态</td>
<td>
<select name="video[serialise]">
<option value="0"<?php echo $serialise_0;?>>完结</option>
<option value="1"<?php echo $serialise_1;?>>连载</option>
</select>
</td>
</tr>

<tr>
<td>备注</td>
<td><input type="text" name="video[memo]" value="<?php echo $video['memo'];?>" class="text" /></td>
</tr>

<tr>
<td>内容简介</td>
<td><?php echo create_kindeditor('video[synopsis]',600,200, $video['synopsis']); ?></td>
</tr>


<tr>
<td>海报 <br />允许上传格式: <?php echo $db_picfiletype;?> <br />允许上传大小: <?php echo ceil($db_picmaxsize / 1024); ?>KB</td>
<td>
<div id="preview_fake" style="width: 120px; height: 150px;">
<img id="preview" src="<?php echo $img;?>" style="width: 120px; height: 150px;" />
</div>
<?php if($db_uploadvodpic) { ?>
<div style="margin-bottom: 3px;">图片上传 <input name="video[image]" type="file" size="30" class="text" onchange="onUploadImgChange(this)"/></div>
<?php } ?>
<div>图片地址 <input name="video[imgurl]" type="text" size="30" class="text" />
<input name="video[downimg]" type="checkbox" value="1" />下载图片 [地址必须是以 http://开头的路径]</div>
</td>
</tr>

<?php if($gp_allowsell=='1') { ?>
<tr>
<td>出售视频</td>
<td>会员支付 <input class="text" maxLength="6" size="6" value="<?php echo $sale_value;?>" name="video[sale]">
<select name="video[saletype]"><?php echo $sale_opt;?></select> 才能播放视频
</td>
</tr>
<?php } if($gp_allowencode=='1') { ?>
<tr>
<td>加密视频</td>
<td>会员拥有 <input class="text" maxLength=6 size=6 value="<?php echo $need_value;?>" name="video[need]">
<select name="video[needtype]"><?php echo $need_opt;?></select>	以上才能播放视频
</td>
</tr>
<?php } ?>

<tr><td colspan="2">播放组控制: <a href="#" onclick="add();return false;">添加播放组</a></td></tr><?php if(is_array($video['urls'])) { foreach($video['urls'] as $key => $value) { ?><tr>
<td>视频地址<span style="color:red;">*</span><br />
每行输入一个视频地址<br />
格式：<span style="color: green">视频地址</span>,<span style="color: red">标题</span><br />
说明：视频地址与标题之间用","分开，标题部分为可选项，可省略。
</td>
<td>
<select name="video[pid][]"><?php echo $video['player'][$key];?></select><br />
<textarea name="video[urls][]" cols="80" rows="8" style="margin: 5px 0px;" wrap="off"><?php echo $value;?></textarea>
<br />
<input type="button" class="button2" onclick="del(this);" value="删除" />
</td>
</tr><?php } } ?></table><br />
<center><input id="btnSubmit" type="submit" value="提 交" class="button1" /></center><br />
</form>
<?php } ?>

<script type="text/javascript">
function onUploadImgChange(sender){   
    if(!sender.value.match(/.jpg|.gif|.png|.bmp/i))
{   
        alert('图片格式无效');   
        return false;   
    }  
    var objPreview = document.getElementById('preview');   
    var objPreviewFake = document.getElementById('preview_fake');   
    if( sender.files && sender.files[0] )
{   
        objPreview.style.display = 'block';   
        objPreview.src = sender.files[0].getAsDataURL();       
    }
else if( objPreviewFake.filters )
{    
        sender.select();   
        var imgSrc = document.selection.createRange().text;   
        objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;   
    objPreview.style.display = 'none';   
    }   
}  

function add()
{
var caption = '视频地址<span style="color:red;">*</span><br />每行输入一个视频地址<br />格式：<span style="color: green">视频地址</span>,<span style="color: red">标题</span><br />说明：视频地址与标题之间用","分开，标题部分为可选项，可省略。';
var html = '<select name="video[pid][]"><?php echo $video['player'][$key];?></select><br /><textarea name="video[urls][]" cols="80" rows="8" style="word-wrap: normal; overflow-x: auto; margin: 5px 0px;"></textarea><br /><input type="button" class="button2" onclick="del(this);" value="删除" />';
var tr = document.getElementById("tp").insertRow(-1);
tr.insertCell(-1).innerHTML=caption;
tr.insertCell(-1).innerHTML=html;  
}

function del(obj)
{
var i=obj.parentNode.parentNode.rowIndex;
document.getElementById('tp').deleteRow(i);
}
</script>
