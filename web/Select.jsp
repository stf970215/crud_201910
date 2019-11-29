<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
   <script src="/js/jquery-3.4.1.js"></script>
</head>
<script>

    $(function () {

        $.ajax({
            url: "/Sheng",
            type: "get",
            data: "",
            //text
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#province").append(html);
            }

        });

        $("#province").change(function () {
            var id = $("#province option:selected").val();
            if(id==-1){
                $("#city").empty();
                $("#qu").empty();
                return;
            }
            $.ajax({
                url: "/city",
                type: "get",
                data: {abc: id},
                dataType: "json",
                success: function (data) {
                    $("#city").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#city").append(html);
                }
            });
        });


        $("#city").change(function () {
            var id = $("#city option:selected").val();
            if(id==-1){
                $("#qu").empty();
                return;
            }
            $.ajax({
                url: "/city",
                type: "get",
                data: {abc: id},
                dataType: "json",
                success: function (data) {
                    $("#qu").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#qu").append(html);
                }
            });
        });
    });

</script>

<body>

请选择省份：
<select id="province">

</select>

<br>

请选择市：
<select id="city">

</select>

请选择区：
<select id="qu">

</select>
</body>
</html>
