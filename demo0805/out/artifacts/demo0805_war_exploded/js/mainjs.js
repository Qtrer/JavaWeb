$(function (){
    $(":checkbox").click(function () {
        $("input:not(:checked)").each(function () {
            $(this).prev().attr("disabled",true);
        });
        var price = $(this).parent().prev().html()
        var num = $(this).prev().val()
        $(this).val(num*price)
        var count = 0;
        $(":checked").each(function () {
            count=$(this).val() - 0 + count
            $(this).prev().attr("disabled",false)
        })
        $("#sum").html(count)
    })
    $(".number").blur(function (){
        var price = $(this).parent().prev().html()
        var num = $(this).val()
        $(this).next().val(num*price)
        var count = 0;
        $(":checked").each(function () {
            count=$(this).val() - 0 + count
        })
        $("#sum").html(count)
    })
})