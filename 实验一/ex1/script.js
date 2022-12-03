$(document).ready(function(){
    function get_contact_form_info(){
        var email = $("#email").val();
        var message = $("#message").val();
        alert("你的邮箱是： "+ email + " 你的留言是： " + message);}
     $("#submit-button").click(function(){
        get_contact_form_info();
    });
});

