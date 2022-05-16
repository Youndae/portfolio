//에디터
$(function () {
    var obj = [];

    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "con",
        sSkinURI: "/editor/SmartEditor2Skin.html",
        htParams: {
            bUseToolbar: true,
            bUseVerticalResizer: true,
            bUseModeChanger: true,
        }
    });

    var token = $("meta[name='_csrf']").attr('content');
    var header = $("meta[name='_csrf_header']").attr('content');

    $("#insertBoard").click(function () {

        obj.getById["con"].exec("UPDATE_CONTENTS_FIELD", []);

        var form = $('#insertBoardFrm')[0];

        var formData = new FormData(form);

        $.ajaxSettings.traditional = true;
        $.ajax({
            url: '/insertProc',
            contentType: false,
            processData: false,
            cache: false,
            type: 'post',
            data: formData,
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(data){
                if(data == 1){
                    location.href="/";
                }else{
                    alert("upload fail");
                }
            },
            error: function(request, status, error){
                alert("code : " + request.status + "\n"
                    + "message : " + request.responseText
                    + "\n" + "error : " + error);
            }
        })
    });



    $("#modifyBoard").click(function () {

        obj.getById["con"].exec("UPDATE_CONTENTS_FIELD", []);

        var form = $('#modifyBoardFrm')[0];

        var formData = new FormData(form);

        $.ajaxSettings.traditional = true;
        $.ajax({
            url: '/modifyProc',
            contentType: false,
            processData: false,
            cache: false,
            type: 'post',
            data: formData,
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(data){
                if(data == 1){
                    location.href="/";
                }else{
                    alert("upload fail");
                }
            },
            error: function(request, status, error){
                alert("code : " + request.status + "\n"
                    + "message : " + request.responseText
                    + "\n" + "error : " + error);
            }
        })
    });


    $("#deleteBoard").click(function(){
        var bno = $("input[name='bno']").val();

        $.ajax({
            url: '/deletePort',
            type: 'post',
            data: {bno: bno},
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(data){
                if(data == 1){
                    location.href="/";
                }else{
                    alert("delete fail");
                }
            },
            error: function(request, status, error){
                alert("code: "+ request.status + "\n"
                    + "message : " + request.responseText
                    + "\n" + "error : " + error);
            }
        });
    });
});